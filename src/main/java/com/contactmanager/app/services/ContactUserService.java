package com.contactmanager.app.services;

import org.springframework.ui.Model;

import java.security.Principal;

public interface ContactUserService {

    public String fetchContactUser(Model model, Principal principal);

    public String addContactUser(Model model, Principal principal);

}
