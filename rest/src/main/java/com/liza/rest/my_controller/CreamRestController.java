package com.liza.rest.my_controller;

import com.liza.rest.entity.Cream;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CreamRestController {

    private List<Cream> creams;

    @PostConstruct
    public void createListOfCream() {
        creams = new ArrayList<>();

        Cream cream1 = new Cream("Manoy", "dry");
        Cream cream2 = new Cream("Vichy", "normal");
        Cream cream3 = new Cream("Yadah", "oil");

        creams.add(cream1);
        creams.add(cream2);
        creams.add(cream3);
    }

    @GetMapping("/creams")
    public List<Cream> getCream() {
        return creams;
    }

    @GetMapping("/creams/{creamIndex}")
    public Cream getCreamId(@PathVariable(name = "creamIndex") int id) {
        if (id<0 || id >= creams.size()) {
            System.out.println("Cream №" + id +  " not found");
            throw new CreamNotFoundException("Cream №" + id +  " not found");
        }
        return creams.get(id);
    } // можно простов везде указать id или любое другое обозначение, тогда можно не писать (name = "creamIndex")

}
