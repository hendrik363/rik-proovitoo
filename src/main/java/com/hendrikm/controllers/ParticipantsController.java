package com.hendrikm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrikm.models.ParticipantModel;

@Controller
@RequestMapping("/lisa-osaleja-info")
public class ParticipantsController {

    @GetMapping
    public String displayEventForm(Model model) {
        model.addAttribute("participant", new ParticipantModel());

        return "lisaosavotjainfo";

    }

    @PostMapping
    public String addParticipant(ParticipantModel participant, Model model) {

        System.out.println("Test name " + participant.getFirstName());
        return "avaleht";
    }

}