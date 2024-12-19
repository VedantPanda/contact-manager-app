package com.contactmanager.app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/scm/contactUser")
public interface ContactUserController {

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal);

}
