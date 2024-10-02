package com.liza.thymeleaf.controller;

import com.liza.thymeleaf.model.Friend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FriendController {

    @Value("${cities}")
    private List<String> cities;

    @Value("${drinks}")
    private List<String> drinks;

    @Value("${pets}")
    private List<String> pets;

    @GetMapping("showFriendForm")
    public String showForm(Model model) {
        model.addAttribute("friend", new Friend()); // упрощенная запись без дополнительного создания переменной friend
        model.addAttribute("cities", cities);
        model.addAttribute("drinks", drinks);
        model.addAttribute("pets", pets);
        return "friend-form";
    }

    @PostMapping("processFriendForm")
    public String processFriendForm(@ModelAttribute("friend") Friend friend) {

        System.out.println(friend);
        return "friend-confirmation";
    }
}
