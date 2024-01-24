package com.hendrikm.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hendrikm.models.EventModel;
import com.hendrikm.models.EventsMapper;
import com.hendrikm.models.ParticipantModel;

@Repository
@Primary
public class EventsDataService implements EventsDataAccessInterface<EventModel> {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public EventModel getById(Long id) {
        List<EventModel> result = jdbcTemplate.query("SELECT * FROM EVENTS WHERE ID = ?", new EventsMapper(), id);

        if(result.size() > 0){
            return result.get(0);
        } 
        else 
            return null;
    }

    @Override
    public List<EventModel> getEvents() {
        List<EventModel> results = jdbcTemplate.query("SELECT * FROM EVENTS", new EventsMapper());

        return results;
    }

    @Override
    public long addOne(EventModel newEvent) {

        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleInsert.withTableName("EVENTS").usingGeneratedKeyColumns("ID");

        List<ParticipantModel> emptyArray = new ArrayList<>();

        Map<String, Object> paramtetrs = new HashMap<String, Object>();
        paramtetrs.put("NAME", newEvent.getEventName());
        paramtetrs.put("DATETIME", newEvent.getDateTime());
        paramtetrs.put("LOCATION", newEvent.getLocation());
        paramtetrs.put("INFORMATION", newEvent.getInformation());
        paramtetrs.put("EVENT_PARTICIPANTS", emptyArray);

        Number result = simpleInsert.executeAndReturnKey(paramtetrs);

        return result.longValue();
                
    }

    @Override
    public boolean deleteOne(Long id) {
        long result = jdbcTemplate.update("DELETE FROM EVENTS WHERE ID = ?", id);

        if(result > 0) {
            return true;
        }
        else
            return false;
    }

    @Override
    public EventModel updateEvent(long idToUpdate, EventModel updateEvent) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ParticipantModel> participants = updateEvent.getParticipants();

        String jsonParticipants = null;

        try {
            // Convert List to JSON string
            jsonParticipants = objectMapper.writeValueAsString(participants);

            // Print the JSON string
            System.out.println("jsonParticipants" + jsonParticipants);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("jsonParticipants outside try" + jsonParticipants);

        long result = jdbcTemplate.update("UPDATE EVENTS SET NAME = ?, DATETIME = ?, LOCATION = ?, INFORMATION = ?, EVENT_PARTICIPANTS = ? WHERE ID = ?", updateEvent.getEventName(), updateEvent.getDateTime(), updateEvent.getLocation(), updateEvent.getInformation(), jsonParticipants, idToUpdate);

        if(result > 0) {
            return updateEvent;
        }
        else 
            return null;
    }

}