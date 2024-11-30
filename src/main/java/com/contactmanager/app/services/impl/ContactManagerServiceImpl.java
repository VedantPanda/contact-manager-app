package com.contactmanager.app.services.impl;

import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.repositories.ContactUserRepository;
import com.contactmanager.app.services.ContactManagerService;
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
    public String registerContactUser(ContactUser contactUser, Boolean agreement, Model model) {
        log.info("Registering Contact User");
        if(Boolean.FALSE.equals(agreement)){
            return "error";
        }
        contactUser.setRole("USER");
        contactUserRepository.save(contactUser);
        log.info("Registered Contact User");
        model.addAttribute("contactUser", contactUser);
        return "signup";
    }
}
