package ru.hh.todo.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoItemDTO {

    @JsonProperty(required = true)
    private int id;

    @JsonProperty(required = true)
    private String content;

    @JsonProperty(required = true)
    private boolean completed;

    public ToDoItemDTO() {}

    public ToDoItemDTO(int id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public ToDoItemDTO(ToDoItem item) {
        this.id = item.getId();
        this.content = item.getContent();
        this.completed = item.isCompleted();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
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
        return content.equals(item.content);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"content\":\"" + content + '\"' +
                ", \"completed\":\"" + completed + '\"' +
                '}';
    }
};
