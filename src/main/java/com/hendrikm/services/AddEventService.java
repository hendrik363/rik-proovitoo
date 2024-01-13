package com.hendrikm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hendrikm.models.EventModel;

@Service
public class AddEventService implements EventsServiceInterface {

    List<EventModel> events;

    @Override
    public void test() {
        System.out.println("EventsService is working");
    }

    @Override
    public List<EventModel> getEvents() {

       return events;
    }

    @Override
    public void init() {
        events = new ArrayList<EventModel>();
        System.out.println("Init method of the AddEventsService");
    }

    @Override
    public void destroy() {

    }

}
