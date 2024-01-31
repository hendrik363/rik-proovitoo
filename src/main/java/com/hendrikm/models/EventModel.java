package com.hendrikm.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventModel {

    private Long id;
    private String eventName;
    private String dateTime;
    private String location;
    private String information;
    private List<Object> allParticipants;
    private List<ParticipantModel> participants;
    private List<CompanyModel> companyParticipants;

    public EventModel() {
        super();
    }

    public EventModel(Long id, String eventName, String dateTime, String location, String information, List<ParticipantModel> participants, List<CompanyModel> companyParticipants,
            List<Object> allParticipants) {
        this.id = id;
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.location = location;
        this.information = information;
        this.participants = participants;
        this.companyParticipants = companyParticipants;
        this.allParticipants = allParticipants;
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
        if (participants == null) {
            return new ArrayList<ParticipantModel>();
        } else
            return participants;
    }

    public void setParticipants(List<ParticipantModel> participants) {
        this.participants = participants;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
        return localDateTime.format(formatter);
    }

    public List<CompanyModel> getCompanyParticipants() {
        if (companyParticipants == null) {
            return new ArrayList<CompanyModel>();
        } else
            return companyParticipants;
    }

    public void setCompanyParticipants(List<CompanyModel> companyParticipants) {
        this.companyParticipants = companyParticipants;
    }

    @Override
    public String toString() {
        return "EventModel [id=" + id + ", eventName=" + eventName + ", dateTime=" + dateTime + ", location=" + location
                + ", information=" + information + ", participants=" + participants + ", companyParticipants="
                + companyParticipants + "]";
    }

    public List<Object> getAllParticipants() {
        return allParticipants;
    }

    public void setAllParticipants(List<Object> allParticipants) {
        this.allParticipants = allParticipants;
    }

}