package com.hendrikm.data;

import java.util.List;

public interface EventsDataAccessInterface <T> {

    public T getById(Long id);
    public List<T> getEvents();
    public long addOne(T newEvent);
    public boolean deleteOne(Long id);
    public T updateEvent(long idToUpdate, T updateEvent);
}
