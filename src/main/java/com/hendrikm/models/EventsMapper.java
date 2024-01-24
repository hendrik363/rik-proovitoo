package com.hendrikm.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventsMapper implements RowMapper<EventModel> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public EventModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        List<ParticipantModel> participants;
        
        String participantsJson = rs.getString("EVENT_PARTICIPANTS");
        //System.out.println("participantjson" + participantsJson);
        if(participantsJson == null) {
            participants = new ArrayList<ParticipantModel>();
        }
        else {
            participants = convertJsonToParticipants(participantsJson);
        }
        
        EventModel event = new EventModel(rs.getLong("ID"), rs.getString("NAME"), rs.getString("DATETIME"),
                 rs.getString("LOCATION"), rs.getString("INFORMATION"), participants);



        return event;
    }

    private List<ParticipantModel> convertJsonToParticipants(String json) {
        try {
            
            return objectMapper.readValue(json, new TypeReference<List<ParticipantModel>>() {
            });
        } catch (Exception e) {
            // Handle the exception according to your needs
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
