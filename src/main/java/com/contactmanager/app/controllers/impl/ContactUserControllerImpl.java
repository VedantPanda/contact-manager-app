package com.contactmanager.app.controllers.impl;

import com.contactmanager.app.controllers.ContactUserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ContactUserControllerImpl implements ContactUserController {
    @Override
    public String dashboard() {
        return "normal/user_dashboard";
    }
}
