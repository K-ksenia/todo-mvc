package ru.hh.todo.mvc;

import ru.hh.nab.starter.NabApplication;

public class Main {

  public static void main(String[] args) {
    NabApplication.builder()
      .configureJersey(ToDoJerseyConfig.class).bindToRoot()
      .build().run(ToDoConfig.class);
  }
}
