package com.contactmanager.app.services.impl;

import com.contactmanager.app.entities.Contact;
import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.repositories.ContactUserRepository;
import com.contactmanager.app.services.ContactUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.Optional;

@Service
@Slf4j
public class ContactUserServiceImpl implements ContactUserService {

    private ContactUserRepository contactUserRepository;

    @Autowired
    public ContactUserServiceImpl(ContactUserRepository contactUserRepository){
        this.contactUserRepository = contactUserRepository;
    }


    private void commonData(Model model, Principal principal){
        log.info("In common data");
        Optional<ContactUser> contactUserOptional = contactUserRepository.findByEmail(principal.getName());
        contactUserOptional.ifPresent(contactUser -> model.addAttribute("contactUser", contactUser));
    }

    @Override
    public String fetchContactUser(Model model, Principal principal) {
        log.info("Fetching Contact User");
        commonData(model, principal);
        return "normal/user_dashboard";
    }

    @Override
    public String addContactUser(Model model, Principal principal) {
        log.info("Add contact");
        commonData(model, principal);
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }
}
