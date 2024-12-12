package com.contactmanager.app.controllers;

import com.contactmanager.app.entities.ContactUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/scm")
public interface ContactManagerController {

    @RequestMapping("/home")
    public String home(Model model);

    @RequestMapping("/about")
    public String about(Model model);

    @RequestMapping("/signup")
    public String signup(Model model);

    @PostMapping("/registerContactUser")
    public String registerContactUser(@Valid @ModelAttribute("contactUser")ContactUser contactUser,
                                      BindingResult bindingResult,
                                      @RequestParam(value = "agreement", defaultValue = "false") Boolean agreement,
                                      Model model, HttpSession session);

}
