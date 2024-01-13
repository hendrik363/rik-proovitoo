package com.hendrikm.data;

import java.util.List;

import com.hendrikm.models.EventModel;

public interface EventsDataAccessInterface {
    public EventModel getById(int id);
    public List<EventModel> getEvents();
    public int addOne(EventModel newEvent);
    public boolean deleteOne(int id);
    public EventModel updateEvent(int id, EventModel updateEvent);
}
