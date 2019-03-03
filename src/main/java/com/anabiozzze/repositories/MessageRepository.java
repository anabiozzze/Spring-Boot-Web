package com.anabiozzze.repositories;

import com.anabiozzze.entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Интерфейс для общих операций CRUD в хранилище для типа данных Message
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
