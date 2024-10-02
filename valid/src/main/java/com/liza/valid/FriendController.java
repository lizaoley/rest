package com.liza.valid;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, ste);
    } // убирает лишние пробелы

    @GetMapping("/friend")
    public String showFriendForm(Model model){
        model.addAttribute("friend", new Friend());
        return "friend-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("friend") Friend friend, BindingResult result){

        System.out.println(result);


        if(result.hasErrors()){
            return "friend-form";
        } else {
            String oldFirstName = friend.getFirstName().toLowerCase();
            String newfirst = oldFirstName.substring(0, 1).toUpperCase() + oldFirstName.substring(1);
            String oldLastName = friend.getLastName().toLowerCase();
            String newlast = oldLastName.substring(0, 1).toUpperCase() + oldLastName.substring(1);
            friend.setFirstName(newfirst);
            friend.setLastName(newlast);
            return "friend-confirmation";
        }
    }
}
