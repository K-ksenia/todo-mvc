package ru.hh.todo.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ToDoResource.class)
public class ToDoJerseyConfig {
}
