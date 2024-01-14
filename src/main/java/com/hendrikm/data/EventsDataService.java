package com.hendrikm.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.hendrikm.models.EventModel;
import com.hendrikm.models.EventsMapper;

@Repository
@Primary
public class EventsDataService implements EventsDataAccessInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public EventModel getById(int id) {
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
    public int addOne(EventModel newEvent) {

        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleInsert.withTableName("EVENTS").usingGeneratedKeyColumns("ID");

        Map<String, Object> paramtetrs = new HashMap<String, Object>();
        paramtetrs.put("NAME", newEvent.getName());
        paramtetrs.put("DATE", newEvent.getDate());
        paramtetrs.put("TIME", newEvent.getTime());
        paramtetrs.put("LOCATION", newEvent.getLocation());
        paramtetrs.put("INFORMATION", newEvent.getInformation());

        Number result = simpleInsert.executeAndReturnKey(paramtetrs);

        return result.intValue();
                
    }

    @Override
    public boolean deleteOne(int id) {
        int result = jdbcTemplate.update("DELETE FROM EVENTS WHERE ID = ?", id);

        if(result > 0) {
            return true;
        }
        else
            return false;
    }

    @Override
    public EventModel updateEvent(int id, EventModel updateEvent) {
        int result = jdbcTemplate.update("UPDATE EVENTS SET NAME = ?, DATE = ?, TIME = ?, LOCATION = ?, INFORMATION = ?, ID = ?", updateEvent.getName(), updateEvent.getDate(), updateEvent.getTime(), updateEvent.getLocation(), updateEvent.getInformation(), id);

        if(result > 0) {
            return updateEvent;
        }
        else 
            return null;
    }

}