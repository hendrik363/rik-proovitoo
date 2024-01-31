package com.hendrikm.controllers;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.hendrikm.models.EventModel;
import com.hendrikm.services.EventsServiceInterface;

@SpringBootApplication
@Controller
@ComponentScan("com.hendrikm")
public class MainController {

    public static void main(String[] args) {
		SpringApplication.run(MainController.class, args);
	}

    EventsServiceInterface service;
    
    public MainController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public String displayMainPage(Model model) throws ParseException {
        List<EventModel> events = service.getEvents();

        LocalDateTime currentDateTime = LocalDateTime.now();
        List<EventModel> passedEvents = new ArrayList<>();
        List<EventModel> comingEvents = new ArrayList<>();

        for (EventModel event : events) {
            String eventDateTime = event.getDateTime();
            LocalDateTime dateTime = LocalDateTime.parse(eventDateTime, DateTimeFormatter.ISO_DATE_TIME);
            if(dateTime.isBefore(currentDateTime )) {
                passedEvents.add(event);
            } else{
                comingEvents.add(event);
            }
        }



        model.addAttribute("comingEvents", comingEvents);
        model.addAttribute("passedEvents", passedEvents);
        //model.addAttribute("minDate", formattedCurrentDate);


        return "avaleht";

    }

    @GetMapping("/eemalda/{event_id}")
    public String deleteEvent(@PathVariable Long event_id, Model model) {
        System.out.println("eemalda event : " + event_id);
        service.deleteOne(event_id);

        return "redirect:/";
    }
}
