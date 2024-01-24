package com.hendrikm.controllers;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hendrikm.models.EventModel;
import com.hendrikm.models.ParticipantModel;
import com.hendrikm.services.EventsServiceInterface;

@Controller
@RequestMapping("/lisa-osavotjad")
public class AddParticipantController {

    EventsServiceInterface service;

    public AddParticipantController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/{event_id}")
    public String displayEventForm(@PathVariable Long event_id, Model model) {

        ParticipantModel newParticipant = new ParticipantModel();
        EventModel event = service.getById(event_id);

        System.out.println("participants" + event.getParticipants());
        newParticipant.setParticipantType("Eraisik");

        model.addAttribute("newParticipant", newParticipant);
        model.addAttribute("participants", event.getParticipants());
        model.addAttribute("event", event);

        return "lisaosaleja";

    }

    public boolean isPersonalCodeUnique(String personalCode, EventModel event) {

        List<ParticipantModel> participants = event.getParticipants();

        boolean isTaken = participants.stream()
                .anyMatch(participant -> Objects.equals(participant.getPersonalCode(), personalCode));
        System.out.println("ISTAKEN: " + isTaken);

        if (isTaken) {
            return true;
        } else
            return false;

    }

    @PostMapping("/{event_id}")
    public String addParticipants(@PathVariable Long event_id, ParticipantModel newParticipant,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        EventModel event = service.getById(event_id);

        if (isPersonalCodeUnique(newParticipant.getPersonalCode(), event)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Personal code is already taken.");
            return "redirect:/lisa-osavotjad/" + event_id;
        }

        List<ParticipantModel> participants = event.getParticipants();

        newParticipant = new ParticipantModel(newParticipant.getFirstName(), newParticipant.getParticipantType(),
                newParticipant.getLastName(), newParticipant.getPersonalCode(), newParticipant.getPaymentMethod(),
                newParticipant.getInformation());

        System.out.println("new Participant generated id" + newParticipant);

        participants.add(newParticipant);

        event.setParticipants(participants);

        service.updateEvent(event_id, event);
        redirectAttributes.addFlashAttribute("successMessage", "Osaleja lisatud");
        System.out.println("updated event participants " + event.getParticipants());

        return "redirect:/lisa-osavotjad/" + event_id;
    }

    @GetMapping("/{event_id}/eemalda_osaleja/{participant_id}")
    public String deleteParticipant(@PathVariable Long event_id, @PathVariable UUID participant_id, Model model) {
        EventModel event = service.getById(event_id);
        List<ParticipantModel> updatedParticipants = event.getParticipants()
                .stream()
                .filter(p -> !p.getId().equals(participant_id))
                .collect(Collectors.toList());

        event.setParticipants(updatedParticipants);
        service.updateEvent(event_id, event);

        return "redirect:/lisa-osavotjad/" + event_id;
    }

}