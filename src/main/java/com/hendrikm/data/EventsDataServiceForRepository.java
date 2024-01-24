package com.hendrikm.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hendrikm.models.EventEntity;
import com.hendrikm.models.EventModel;

public class EventsDataServiceForRepository implements EventsDataAccessInterface<EventModel>{

    @Autowired
    EventsRepositoryInterface eventsRepository;

    private JdbcTemplate jdbcTemplate;

    ModelMapper modelMapper = new ModelMapper();

    public EventsDataServiceForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public EventModel getById(Long id) {
        EventEntity entity = eventsRepository.findById(id).orElse(null);

        EventModel model = modelMapper.map(entity, EventModel.class);

        return model;
    }

    @Override
    public List<EventModel> getEvents() {
        Iterable<EventEntity> eventsEntity = eventsRepository.findAll();

        List<EventModel> models = new ArrayList<EventModel>();
        
        for(EventEntity item: eventsEntity) {
            models.add(modelMapper.map(item, EventModel.class));
        }

        return models;
    }

    @Override
    public long addOne(EventModel newEvent) {
        EventEntity entity = modelMapper.map(newEvent, EventEntity.class);
        EventEntity result = eventsRepository.save(entity);
        
        if(result == null) {
            return 0;
        }   
        else {
            return result.getId();
        }
    }

    @Override
    public boolean deleteOne(Long id) {
        eventsRepository.deleteById(id);

        return true;
    }

    @Override
    public EventModel updateEvent(long idToUpdate, EventModel updateEvent) {
        EventEntity entity = modelMapper.map(updateEvent, EventEntity.class);
        EventEntity result = eventsRepository.save(entity);
        EventModel event = modelMapper.map(result, EventModel.class);

        return event;
    }

}
