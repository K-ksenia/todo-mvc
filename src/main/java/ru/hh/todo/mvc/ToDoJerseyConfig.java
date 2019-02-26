package ru.hh.todo.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ToDoResource.class, FrontResource.class})
public class ToDoJerseyConfig {
}
