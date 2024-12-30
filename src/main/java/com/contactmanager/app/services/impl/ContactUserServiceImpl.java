package com.contactmanager.app.services.impl;

import com.contactmanager.app.entities.Contact;
import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.repositories.ContactRepository;
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

    private ContactRepository contactRepository;

    @Autowired
    public ContactUserServiceImpl(ContactUserRepository contactUserRepository, ContactRepository contactRepository){
        this.contactUserRepository = contactUserRepository;
        this.contactRepository = contactRepository;
    }


    private void commonData(Model model, Principal principal){
        log.info("In common data");
        Optional<ContactUser> contactUserOptional = contactUserRepository.findByEmail(principal.getName());
        contactUserOptional.ifPresent(contactUser -> model.addAttribute("contactUser", contactUser));
    }

    @Override
    public String fetchContactUser(Model model, Principal principal) {
        log.info("Fetching Contact User");
        model.addAttribute("title", "User Dashboard");
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

    @Override
    public String processContact(Contact contact, Principal principal) {
        log.info("In process contact service");
        try{
            Optional<ContactUser> contactUserOptional = contactUserRepository.findByEmail(principal.getName());
            if(contactUserOptional.isPresent()){
                ContactUser contactUser = contactUserOptional.get();
                contactUser.getContacts().add(contact);
                contact.setContactUser(contactUser);
                contactRepository.save(contact);
            }
            return "normal/add_contact_form";
        }
        catch (Exception e){
//            model.addAttribute("contactUser", contactUser);
//            session.setAttribute("message", new Message("Something Went Wrong "+e.getMessage(),
//                    "alert-danger"));
            return "normal/add_contact_form";
        }
    }
}
