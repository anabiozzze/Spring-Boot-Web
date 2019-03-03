package com.anabiozzze;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// аннотация ниже автоматически применяет такие настройки, как @Configuration, @EnableWebMvc, @ComponentScan
// т.е. может искать бины в этом классе, конфигурации в пакете (контроллер, например), настраивает DispatcherServlet
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
