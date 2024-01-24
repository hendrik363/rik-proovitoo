package com.hendrikm.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hendrikm.models.EventEntity;

public interface EventsRepositoryInterface extends CrudRepository<EventEntity, Long> {

    List<EventEntity> findByEventNameContainingIgnoreCase(String searchTerm);

    

}