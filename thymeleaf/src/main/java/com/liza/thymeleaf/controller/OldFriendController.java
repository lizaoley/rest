package com.liza.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OldFriendController {

    @RequestMapping("/showFriendForm")
    public String showWineForm() {
        return "oldfriend-form";
    }

    @RequestMapping("/processFriendForm")
    public String processFriendForm() {
        return "friend-info";
    }

//    @RequestMapping("/processFriendForm2")
//    public String correctName(HttpServletRequest request, Model model) {
//        String oldNameLoverCase = request.getParameter("friendName").toLowerCase();
//        String correctName = "";
//        String[] wordsName = oldNameLoverCase.split(" ");
//        for (String word : wordsName) {
//            String first = word.substring(0, 1).toUpperCase();
//            word = first + word.substring(1);
//            correctName += word + " ";
//        }
//        correctName = correctName.trim();
//        model.addAttribute("correctName", correctName);
//        return "friend-info";
//    } первый вариант, лучше, когда параметров несколько

    @RequestMapping(value = "/processFriendForm3")
    public String correctName3(@RequestParam("friendName") String friendName, Model model) {
        String oldNameLoverCase = friendName.toLowerCase();
        String correctName = "";
        String[] wordsName = oldNameLoverCase.split(" ");
        for (String word : wordsName) {
            String first = word.substring(0, 1).toUpperCase();
            word = first + word.substring(1);
            correctName += word + " ";
        }
        correctName = correctName.trim();
        model.addAttribute("correctName", correctName);
        return "friend-info";
    } // вариант лучше, когда параметр один

}
