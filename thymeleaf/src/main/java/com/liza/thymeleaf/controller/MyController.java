package com.liza.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

   @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("today", java.time.LocalDate.now());
        return "helloworld";
    }
}
