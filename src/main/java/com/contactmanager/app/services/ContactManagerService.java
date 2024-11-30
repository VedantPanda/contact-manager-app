package com.contactmanager.app.services;

import com.contactmanager.app.entities.ContactUser;
import org.springframework.ui.Model;

public interface ContactManagerService {

    public String registerContactUser(ContactUser contactUser, Boolean agreement, Model model);

}
