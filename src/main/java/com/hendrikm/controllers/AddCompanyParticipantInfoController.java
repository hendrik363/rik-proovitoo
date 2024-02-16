package com.hendrikm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hendrikm.models.CompanyModel;
import com.hendrikm.models.EventModel;
import com.hendrikm.services.EventsServiceInterface;

@Controller
@RequestMapping("/lisa-ettevote-info/{event_id}/{participant_id}")
public class AddCompanyParticipantInfoController {

    EventsServiceInterface service;

    public AddCompanyParticipantInfoController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping
    public String displayChangeParticipantInfo(@PathVariable Long event_id,@PathVariable UUID participant_id, Model model) {

        EventModel event = service.getById(event_id);
        CompanyModel participant = null;
        List<CompanyModel> participants = event.getCompanyParticipants();
        Optional<CompanyModel> optionalParticipant = participants.stream().filter(p -> p.getId().equals(participant_id)).findFirst();

        if(optionalParticipant.isPresent()) {
            participant = optionalParticipant.get();
        }
        else {
            return "lisaosavotjainfo";
        }

        model.addAttribute("event", event);
        model.addAttribute("participant", participant);

        System.out.println("EVENTID" + event_id);

        return "lisaettevoteinfo";
    }

    @PostMapping
    public String changeParticipantInfo(@PathVariable Long event_id,@PathVariable UUID participant_id, CompanyModel updateParticipant, BindingResult bindingResult, Model model) {

        EventModel event = service.getById(event_id);
        List<Object> allParticipants = new ArrayList<>();

        updateParticipant.setCompanyName(updateParticipant.getCompanyName());
        updateParticipant.setRegisterCode(updateParticipant.getRegisterCode());
        updateParticipant.setCompanyParticipants(updateParticipant.getCompanyParticipants());
        updateParticipant.setPaymentMethod(updateParticipant.getPaymentMethod());
        updateParticipant.setInformation(updateParticipant.getInformation());

        event.getCompanyParticipants().stream().filter(p -> p.getId().equals(participant_id)).findFirst().ifPresent(par -> {
            par.setCompanyName(updateParticipant.getCompanyName());
            par.setRegisterCode(updateParticipant.getRegisterCode());
            par.setCompanyParticipants(updateParticipant.getCompanyParticipants());
            par.setPaymentMethod(updateParticipant.getPaymentMethod());
            par.setInformation(updateParticipant.getInformation());
        });

        allParticipants.addAll(event.getParticipants());
        allParticipants.addAll(event.getCompanyParticipants());

        event.setAllParticipants(allParticipants);
        
        service.updateEvent(event_id, event);
        

        return "redirect:/lisa-osavotjad/" + event_id;
    }

}
