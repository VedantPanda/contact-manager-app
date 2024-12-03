package com.contactmanager.app.controllers.impl;

import com.contactmanager.app.controllers.ContactMangerController;
import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.services.ContactManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@Slf4j
public class ContactMangerControllerImpl implements ContactMangerController {

    @Autowired
    private ContactManagerService contactManagerService;

    @Override
    public String home(Model model){
        log.info("In home");
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @Override
    public String about(Model model){
        log.info("In about");
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @Override
    public String signup(Model model){
        log.info("In signup");
        model.addAttribute("title", "Signup - Smart Contact Manager");
        model.addAttribute("contactUser", new ContactUser());
        return "signup";
    }

    @Override
    public String registerContactUser(ContactUser contactUser, BindingResult bindingResult, Boolean agreement, Model model,
                                       HttpSession session) {
        log.info("In register contact user");
        return contactManagerService.registerContactUser(contactUser, bindingResult, agreement, model, session);
    }

}
