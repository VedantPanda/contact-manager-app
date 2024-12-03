package com.contactmanager.app.services;

import com.contactmanager.app.entities.ContactUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface ContactManagerService {

    public String registerContactUser(ContactUser contactUser, BindingResult bindingResult, Boolean agreement, Model model,
                                       HttpSession session);

}
