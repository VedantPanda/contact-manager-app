package com.contactmanager.app.services.impl;

import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.repositories.ContactUserRepository;
import com.contactmanager.app.services.ContactUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

    @Override
    public String fetchContactUser(Model model, Principal principal) {
        log.info("Fetching Contact User");
        Optional<ContactUser> contactUserOptional = contactUserRepository.findByEmail(principal.getName());
        contactUserOptional.ifPresent(contactUser -> model.addAttribute("contactUser", contactUser));
        return "normal/user_dashboard";
    }
}
