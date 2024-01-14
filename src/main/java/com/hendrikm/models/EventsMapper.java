package com.hendrikm.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EventsMapper implements RowMapper<EventModel>{

    @Override
    public EventModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        EventModel event = new EventModel(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("DATE"), rs.getTime("TIME"), rs.getString("LOCATION"), rs.getString("INFORMATION"));

        return event;
    }

}
