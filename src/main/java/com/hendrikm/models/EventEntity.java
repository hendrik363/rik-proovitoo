package com.hendrikm.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EVENTS")
public class EventEntity {

    @Id
    @Column("ID")
    Long id = 0L;

    @Column("NAME")
    String eventName = "";

    @Column("DATE")
    String date = "";

    @Column("TIME")
    String time = "";

    @Column("LOCATION")
    String location = "";

    @Column("INFORMATION")
    String information = "";

    @Column("EVENT_PARTICIPANTS")
    List<ParticipantModel> participants = new ArrayList<ParticipantModel>();

    @Override
    public String toString() {
        return "Event [id=" + id + ", eventName=" + eventName + ", date=" + date + ", time=" + time + ", location=" + location
                + ", information=" + information + "]";
    }

    public EventEntity() {
        super();
    }

    public EventEntity(Long id, String eventName, String date, String time, String location, String information, List<ParticipantModel> participants) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.information = information;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<ParticipantModel> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantModel> participants) {
        this.participants = participants;
    }

}