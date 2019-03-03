package com.anabiozzze.repositories;

import com.anabiozzze.entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


// Интерфейс будет автоматически реализован Spring в bean-компонент
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
