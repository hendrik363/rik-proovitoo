package com.hendrikm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hendrikm.data.EventsDataAccessInterface;
import com.hendrikm.models.EventModel;

@Service
public class GetEventsService implements EventsServiceInterface {

    @Autowired
    EventsDataAccessInterface<EventModel> eventsDAO;

    @Override
    public void test() {
        System.out.println("EventsService is working");
    }

    @Override
    public List<EventModel> getEvents() {

       return eventsDAO.getEvents();
    }

    @Override
    public void init() {
        System.out.println("Init method of the GetEventsService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the GetEventsService");
    }

    @Override
    public EventModel getById(long id) {
        return eventsDAO.getById(id);
    }

    @Override
    public long addOne(EventModel newEvent) {
        return eventsDAO.addOne(newEvent);
    }

    @Override
    public boolean deleteOne(long id) {
        return eventsDAO.deleteOne(id);
    }

    @Override
    public EventModel updateEvent(long id, EventModel updateEvent) {
        return eventsDAO.updateEvent(id, updateEvent);
    }

}