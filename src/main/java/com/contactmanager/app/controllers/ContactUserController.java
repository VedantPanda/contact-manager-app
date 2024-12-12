package com.contactmanager.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/scm/contactUser")
public interface ContactUserController {

    @RequestMapping("/index")
    public String dashboard();

}
