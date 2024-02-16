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

import com.hendrikm.models.EventModel;
import com.hendrikm.models.ParticipantModel;
import com.hendrikm.services.EventsServiceInterface;

@Controller
@RequestMapping("/lisa-osavotja-info/{event_id}/{participant_id}")
public class AddParticipantInfoController {

    EventsServiceInterface service;

    public AddParticipantInfoController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping
    public String displayChangeParticipantInfo(@PathVariable Long event_id,@PathVariable UUID participant_id, Model model) {

        EventModel event = service.getById(event_id);
        ParticipantModel participant = null;
        List<ParticipantModel> participants = event.getParticipants();
        Optional<ParticipantModel> optionalParticipant = participants.stream().filter(p -> p.getId().equals(participant_id)).findFirst();

        if(optionalParticipant.isPresent()) {
            participant = optionalParticipant.get();
        }
        else {
            return "lisaosavotjainfo";
        }

        model.addAttribute("event", event);
        model.addAttribute("participant", participant);

        return "lisaosavotjainfo";
    }

    @PostMapping
    public String changeParticipantInfo(@PathVariable Long event_id,@PathVariable UUID participant_id, ParticipantModel updateParticipant, BindingResult bindingResult, Model model) {

        EventModel event = service.getById(event_id);
        List<Object> allParticipants = new ArrayList<>();

        updateParticipant.setFirstName(updateParticipant.getFirstName());
        updateParticipant.setLastName(updateParticipant.getLastName());
        updateParticipant.setPersonalCode(updateParticipant.getPersonalCode());
        updateParticipant.setPaymentMethod(updateParticipant.getPaymentMethod());
        updateParticipant.setInformation(updateParticipant.getInformation());

        event.getParticipants().stream().filter(p -> p.getId().equals(participant_id)).findFirst().ifPresent(par -> {
            par.setFirstName(updateParticipant.getFirstName());
            par.setLastName(updateParticipant.getLastName());
            par.setPersonalCode(updateParticipant.getPersonalCode());
            par.setPaymentMethod(updateParticipant.getPaymentMethod());
            par.setInformation(updateParticipant.getInformation());
        });

        allParticipants.addAll(event.getCompanyParticipants());
        allParticipants.addAll(event.getParticipants());

        event.setAllParticipants(allParticipants);
        
        service.updateEvent(event_id, event);
        

        return "redirect:/lisa-osavotjad/" + event_id;
    }

}
