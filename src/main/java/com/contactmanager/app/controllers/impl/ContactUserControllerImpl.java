package com.contactmanager.app.controllers.impl;

import com.contactmanager.app.controllers.ContactUserController;
import com.contactmanager.app.entities.Contact;
import com.contactmanager.app.services.ContactUserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;

@Slf4j
@Controller
public class ContactUserControllerImpl implements ContactUserController {

    private final ContactUserService contactUserService;

    @Autowired
    public ContactUserControllerImpl(ContactUserService contactUserService){
        this.contactUserService = contactUserService;
    }

    @Override
    public String dashboard(Model model, Principal principal) {
        log.info("In contact user controller");
        return contactUserService.fetchContactUser(model, principal);
    }

    @Override
    public String addContact(Model model, Principal principal) {
        log.info("In add contact controller");
        return contactUserService.addContactUser(model, principal);
    }

    @Override
    public String processContact(Model model, Contact contact, Principal principal, HttpSession httpSession) {
        log.info("In process contact");
        return contactUserService.processContact(model, contact, principal, httpSession);
    }

    @Override
    public String fetchContacts(Model model, Principal principal) {
        log.info("In fetch contacts");
        return contactUserService.fetchContacts(model, principal);
    }
}
