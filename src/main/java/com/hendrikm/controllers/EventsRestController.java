package com.hendrikm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hendrikm.models.EventModel;
import com.hendrikm.services.EventsServiceInterface;

@RestController
@RequestMapping("/api/v1/events")
public class EventsRestController {

    EventsServiceInterface service;

    @Autowired
    public EventsRestController(EventsServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping
    public List<EventModel> showEvents(Model model) {
        List<EventModel> events = service.getEvents();
        
        return events; 
    } 
    
    @PostMapping
    public int addEvent(EventModel model) {
        
        return service.addOne(model); 
    } 

    @GetMapping("/{id}")
    public EventModel getById(@PathVariable(name="id") int id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteEvent(@PathVariable(name="id") int id){
        return service.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public EventModel updateEvent(@RequestBody EventModel model, @PathVariable(name="id") int id){
        return service.updateEvent(id, model);
    }
}