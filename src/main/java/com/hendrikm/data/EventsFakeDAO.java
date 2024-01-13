package com.hendrikm.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hendrikm.models.EventModel;

@Repository
public class EventsFakeDAO implements EventsDataAccessInterface {

    List<EventModel> events = new ArrayList<EventModel>();

    public EventsFakeDAO() {
        super();
        events.add(new EventModel(1, "01", "01", "01", "01", "01"));
        events.add(new EventModel(2, "02", "02", "02", "02", "02"));
        events.add(new EventModel(3, "03", "03", "03", "03", "03"));
        events.add(new EventModel(4, "04", "04", "04", "04", "04"));
        events.add(new EventModel(5, "05", "05", "05", "05", "05"));
    }

    @Override
    public EventModel getById(int id) {
        for(int i=0; i<events.size(); i++) {
            if(events.get(i).getId() == id) {
                return events.get(i);
            }
        }

        return null;
    }

    @Override
    public List<EventModel> getEvents() {
        return events;
    }

    @Override
    public int addOne(EventModel newEvent) {
        boolean success = events.add(newEvent);

        if(success) {
            System.out.println("Lisatud event");
            return 1;
        }
        else {
            System.out.println("Ei lisatud event");
            return 0;
        }
    }

    @Override
    public boolean deleteOne(int id) {
        for(int i=0; i<events.size(); i++) {
            if(events.get(i).getId() == id) {
                events.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public EventModel updateEvent(int idToUpdate, EventModel updateEvent) {
        for(int i=0; i<events.size(); i++) {
            if(events.get(i).getId() == idToUpdate) {
                events.set(i, updateEvent);
                return events.get(i);
            }
        }

        return null;
    }
    
}
