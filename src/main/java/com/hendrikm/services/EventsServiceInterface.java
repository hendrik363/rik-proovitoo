package com.hendrikm.services;

import java.util.List;

import com.hendrikm.models.EventModel;

public interface EventsServiceInterface {
    public void test();

    public void init();

    public void destroy();

    public EventModel getById(int id);
    public List<EventModel> getEvents();
    public int addOne(EventModel newEvent);
    public boolean deleteOne(int id);
    public EventModel updateEvent(int id, EventModel updateEvent);

}
