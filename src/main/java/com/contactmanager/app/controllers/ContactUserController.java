package com.contactmanager.app.controllers;

import com.contactmanager.app.entities.Contact;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/scm/contactUser")
public interface ContactUserController {

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal);

    @RequestMapping("/addContact")
    public String addContact(Model model, Principal principal);

    @PostMapping("/process-contact")
    public String processContact(Model model, @ModelAttribute Contact contact, Principal principal, HttpSession httpSession);

}
