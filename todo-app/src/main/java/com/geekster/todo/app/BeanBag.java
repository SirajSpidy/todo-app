package com.geekster.todo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ArrayList;
@Configuration
public class BeanBag {
    @Bean
   public List<Todo> getDatasource()
    {
        return  new ArrayList<>();
    }

}
