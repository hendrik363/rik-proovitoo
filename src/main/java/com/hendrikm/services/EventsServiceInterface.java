package com.hendrikm.services;

import java.util.List;

import com.hendrikm.models.EventModel;

public interface EventsServiceInterface {
    public void test();

    public List<EventModel> getEvents();

    public void init();

    public void destroy();

}
