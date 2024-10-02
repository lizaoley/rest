package com.liza.crud_wine.controller;

import com.liza.crud_wine.entity.Wine;
import com.liza.crud_wine.service.WineService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wines")
public class WineController {

    private WineService wineService;

    @Autowired
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/list")
    public String listWine(Model model) {

        List<Wine> wines = wineService.findAll();
        System.out.println(wines);
        model.addAttribute("wines", wines);

        return "wine-list";
    }

    @GetMapping("/addNewWine")
    public String addNewWine(Model model) {
        model.addAttribute("wine", new Wine());
        return "new-wine-form";
    }

    @GetMapping("/updateWine")
    public String updateWine(@RequestParam("id") int id, Model model) {
        model.addAttribute("wine", wineService.findById(id));
        return "new-wine-form";
    }

    @GetMapping("/deleteWine")
    public String deleteWine(@RequestParam("id") int id) {
        wineService.deleteById(id);
        return "redirect:/wines/list";
    }

    @PostMapping("/save")
    public String saveNewWine(@ModelAttribute("wine") Wine wine) {
        wineService.save(wine);
        return "redirect:/wines/list";
    }

}
