package com.anabiozzze.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BaseController {


    // можем использовать RequestParam для извлечения параметров запроса
        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World!!!")
                                               String name, Map<String, Object> model) {
            model.put("name", name);
            return "greeting.mustache";
        }
}
