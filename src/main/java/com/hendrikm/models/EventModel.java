package com.hendrikm.models;

import java.sql.Date;
import java.sql.Time;

public class EventModel {

    private int id;
    private String name;
    private Date date;
    private Time time;
    private String location;
    private String information;

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", location=" + location
                + ", information=" + information + "]";
    }

    public EventModel() {
        super();
    }

    public EventModel(int id, String name, Date date, Time time, String location, String information) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.information = information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

}