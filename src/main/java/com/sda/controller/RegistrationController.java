package com.sda.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RegistrationController {


@GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("");
        return "register";
    }
}
