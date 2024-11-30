package com.contactmanager.app.services.impl;

import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.helper.Message;
import com.contactmanager.app.repositories.ContactUserRepository;
import com.contactmanager.app.services.ContactManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
public class ContactManagerServiceImpl implements ContactManagerService {

    @Autowired
    private ContactUserRepository contactUserRepository;

    @Override
    public String registerContactUser(ContactUser contactUser, Boolean agreement, Model model, HttpSession session) {
        log.info("Registering Contact User");
        try{
            if(Boolean.FALSE.equals(agreement)){
                throw new Exception("You have not agreed to the terms and conditions");
            }
            contactUser.setRole("USER");
            contactUserRepository.save(contactUser);
            log.info("Registered Contact User");
            model.addAttribute("contactUser", new ContactUser());
            model.addAttribute("message", new Message("Successfully Registered", "alert-success"));
            session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
            return "signup";
        }
        catch (Exception e){
            model.addAttribute("contactUser", contactUser);
            session.setAttribute("message", new Message("Something Went Wrong "+e.getMessage(),
                    "alert-danger"));
            return "signup";
        }
    }
}
