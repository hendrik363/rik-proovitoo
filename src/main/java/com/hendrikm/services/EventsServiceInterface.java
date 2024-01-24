package com.hendrikm.services;

import java.util.List;

import com.hendrikm.models.EventModel;

public interface EventsServiceInterface {
    public void test();

    public void init();

    public void destroy();

    public EventModel getById(long id);
    public List<EventModel> getEvents();
    public long addOne(EventModel newEvent);
    public boolean deleteOne(long id);
    public EventModel updateEvent(long id, EventModel updateEvent);

}
