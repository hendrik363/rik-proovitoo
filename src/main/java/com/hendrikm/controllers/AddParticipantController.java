package com.hendrikm.controllers;

import java.util.ArrayList;
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

import com.hendrikm.models.CompanyModel;
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
        CompanyModel newCompany = new CompanyModel();
        List<Object> participants = event.getAllParticipants();

        model.addAttribute("newParticipant", newParticipant);
        model.addAttribute("newCompany", newCompany);
        model.addAttribute("participants", participants);
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

    public boolean isRegisterCodeUnique(String registerCode, EventModel event) {

        List<CompanyModel> participants = event.getCompanyParticipants();

        boolean isTaken = participants.stream()
                .anyMatch(participant -> Objects.equals(participant.getRegisterCode(), registerCode));

        if (isTaken) {
            return true;
        } else
            return false;

    }

    @PostMapping("/eraisik/{event_id}")
    public String addParticipants(@PathVariable Long event_id, ParticipantModel newParticipant,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        EventModel event = service.getById(event_id);

        if (isPersonalCodeUnique(newParticipant.getPersonalCode(), event)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Isikukood on juba võetud.");
            return "redirect:/lisa-osavotjad/" + event_id;
        }

        List<ParticipantModel> participants = event.getParticipants();

        newParticipant = new ParticipantModel(newParticipant.getFirstName(),
                newParticipant.getLastName(), newParticipant.getPersonalCode(), newParticipant.getPaymentMethod(),
                newParticipant.getInformation());

        participants.add(newParticipant);

        event.setParticipants(participants);

        List<Object> allParticipants = new ArrayList<>();

        allParticipants.addAll(participants);
        allParticipants.addAll(event.getCompanyParticipants());

        event.setAllParticipants(allParticipants);

        service.updateEvent(event_id, event);
        redirectAttributes.addFlashAttribute("successMessage", "Osaleja lisatud");
        // event.getAllParticipants());

        return "redirect:/lisa-osavotjad/" + event_id;
    }

    @PostMapping("/ettevote/{event_id}")
    public String addCompanyParticipants(@PathVariable Long event_id, CompanyModel newCompany,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        EventModel event = service.getById(event_id);

        if (isRegisterCodeUnique(newCompany.getRegisterCode(), event)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Registri kood on juba võetud.");
            return "redirect:/lisa-osavotjad/" + event_id;
        }

        List<CompanyModel> companyParticipants = event.getCompanyParticipants();

        newCompany = new CompanyModel(newCompany.getCompanyName(),
                newCompany.getRegisterCode(), newCompany.getCompanyParticipants(), newCompany.getPaymentMethod(),
                newCompany.getInformation());

        companyParticipants.add(newCompany);

        event.setCompanyParticipants(companyParticipants);

        List<Object> allParticipants = new ArrayList<>();

        allParticipants.addAll(companyParticipants);
        allParticipants.addAll(event.getParticipants());

        event.setAllParticipants(allParticipants);

        service.updateEvent(event_id, event);
        redirectAttributes.addFlashAttribute("successMessage", "Ettevõte lisatud");
        // event.getAllParticipants());

        return "redirect:/lisa-osavotjad/" + event_id;
    }

    @GetMapping("/{event_id}/eemalda_osaleja/{participant_id}")
    public String deleteParticipant(@PathVariable Long event_id, @PathVariable UUID participant_id, Model model) {
        EventModel event = service.getById(event_id);
        List<ParticipantModel> participants = event.getParticipants();
        List<CompanyModel> companyParticipants = event.getCompanyParticipants();
        List<Object> allParticipants = new ArrayList<>();

        participants = participants.stream()
                .filter(participant -> !participant.getId().equals(participant_id))
                .collect(Collectors.toList());

        companyParticipants = companyParticipants.stream()
                .filter(participant -> !participant.getId().equals(participant_id))
                .collect(Collectors.toList());
        
        allParticipants.addAll(participants);
        allParticipants.addAll(companyParticipants);

        System.out.println("ALLPARTICIPANTS " + allParticipants);
        event.setParticipants(participants);
        event.setCompanyParticipants(companyParticipants);
        event.setAllParticipants(allParticipants);
        service.updateEvent(event_id, event);

        return "redirect:/lisa-osavotjad/" + event_id;
    }

}