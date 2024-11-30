package com.contactmanager.app.controllers;

import com.contactmanager.app.entities.ContactUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContactMangerController {

    @RequestMapping("/")
    public String home(Model model);

    @RequestMapping("/about")
    public String about(Model model);

    @RequestMapping("/signup")
    public String signup(Model model);

    @PostMapping("/registerContactUser")
    public String registerContactUser(@ModelAttribute("contactUser")ContactUser contactUser,
                                      @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,
                                      Model model, HttpSession session);

}
