package com.hendrikm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hendrikm.models.EventModel;

@Service
public class GetEventsService implements EventsServiceInterface {

    @Override
    public void test() {
        System.out.println("EventsService is working");
    }

    @Override
    public List<EventModel> getEvents() {
       List<EventModel> events = new ArrayList<EventModel>();

       return events;
    }

    @Override
    public void init() {
        System.out.println("Init method of the GetEventsService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the GetEventsService");
    }

}