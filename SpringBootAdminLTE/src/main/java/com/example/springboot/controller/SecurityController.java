package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/examples/security")
public class SecurityController {
    @GetMapping
    public String index() {
        return "redirect:/examples/security/";
    }

    @GetMapping(value = {"/protected1"})
    public String protectedPage1(Model model) {
        model.addAttribute("message", "this can be viewed by USER!");
        return "examples/security/protected1";
    }

    @GetMapping(value = {"/protected2"})
    public String protectedPage2(Model model) {
        model.addAttribute("message", "this can be viewed by ADMIN!");
        return "examples/security/protected2";
    }
}
