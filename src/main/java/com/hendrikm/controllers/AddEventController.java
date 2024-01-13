package com.hendrikm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrikm.models.EventModel;
import com.hendrikm.services.AddEventService;

@Controller
@RequestMapping("/lisa-yritus")
public class AddEventController {

    AddEventService addEventService;

    public AddEventController(AddEventService addEventService) {
        super();
        this.addEventService = addEventService;
    }

    @GetMapping
    public String displayEventForm() {

        return "lisayritus";

    }

    @PostMapping
    public String addEventForm(EventModel event, Model model) {
        model.addAttribute("name", event.getName());
        model.addAttribute("date", event.getDate());
        model.addAttribute("time", event.getTime());
        model.addAttribute("location", event.getLocation());
        model.addAttribute("information", event.getInformation());

        System.out.println("Test name " + event.getName());
        return "avaleht";
    }

}
