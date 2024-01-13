package com.hendrikm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hendrikm.models.ParticipantModel;

@Controller
public class AddParticipantInfoController {
    @GetMapping("/lisa-osavotja-info")
    public String displayEventForm() {

        return "lisaosavotjainfo";

    }

    @PostMapping("/lisa-osavotja-info")
    public String addEventForm(ParticipantModel participant, Model model) {
        model.addAttribute("id", participant.getId());
        model.addAttribute("name", participant.getName());
        model.addAttribute("personalCode", participant.getPersonalCode());
        model.addAttribute("paymentMethod", participant.getPaymentMethod());
        model.addAttribute("information", participant.getInformation());

        System.out.println("Test name " + participant.getName());
        return "avaleht";
    }
}
