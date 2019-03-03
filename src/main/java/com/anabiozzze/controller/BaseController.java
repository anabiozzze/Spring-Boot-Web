package com.anabiozzze.controller;


import com.anabiozzze.entities.Message;
import com.anabiozzze.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BaseController {
    
    // Т.к. мы используем mustache, а не thymeleaf, Model в контроллере заменяем на Map.


    // Интерфейс будет автоматически реализован Spring'ом в bean-компонент.
    @Autowired
    private MessageRepository repository;

    // RequestParam используем для извлечения параметров запроса.
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "request", required = false, defaultValue = "Default")
                                   String name, Map<String, Object> model) {
        model.put("request", name);
        return "greeting";
    }

    // не указывая конкретный мэппинг, ссылаемся на локалхост.
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = this.repository.findAll();
        model.put("messages", messages);
        return "main";
    }

    // пост-запрос для заполнения формы нового сообщения.
    // получаем от формы два параметра, кладем их в БД (через репо) и в модель.
    @PostMapping
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        repository.save(message);

        Iterable<Message> messages = this.repository.findAll();
        model.put("messages", messages);
        return "main";
    }

    // пост-запрос для заполнения формы поиска по фильтру.
    // получаем от формы один параметр, ищем по нему список сущностей через репо.
    // параметр "filter" в маппинге связывает нас с методом post action на целевой станице
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){

        if (filter ==null || filter.isEmpty()) {
            Iterable<Message> messages = this.repository.findAll();
            model.put("messages", messages);
        } else {

        List<Message> byTag = repository.findByTag(filter);
        model.put("messages", byTag);
        }

        return "main";
    }
}
