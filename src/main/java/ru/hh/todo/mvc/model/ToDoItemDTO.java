package ru.hh.todo.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoItemDTO {

    @JsonProperty(required = true)
    private long id;

    @JsonProperty(required = true)
    private String title;

    @JsonProperty(required = true)
    private boolean completed;

    public ToDoItemDTO() {}

    public ToDoItemDTO(long id, String content, boolean completed) {
        this.id = id;
        this.title = content;
        this.completed = completed;
    }

    public ToDoItemDTO(ToDoItem item) {
        this.id = item.getId();
        this.title = item.getContent();
        this.completed = item.isCompleted();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void changeState() {
        completed = !completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ToDoItemDTO item = (ToDoItemDTO) o;

        if (id != item.id) {
            return false;
        }
        return title.equals(item.title);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"title\":\"" + title + '\"' +
                ", \"completed\":\"" + completed + '\"' +
                '}';
    }
};
