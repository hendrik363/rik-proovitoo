package com.hendrikm.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrikm.models.EventModel;
import com.hendrikm.services.EventsServiceInterface;



@Controller
@RequestMapping("/lisa-yritus")
public class EventController {

    EventsServiceInterface service;

    public EventController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping
    public String displayAddEventForm(Model model) {
        model.addAttribute("event", new EventModel());

        return "lisayritus";
    }

    @PostMapping
    public String addEventForm(@Valid EventModel newEvent, BindingResult bindingResult, Model model) {

        newEvent.setId(null);

        service.addOne(newEvent);

        return "redirect:/";
    }

    

}
