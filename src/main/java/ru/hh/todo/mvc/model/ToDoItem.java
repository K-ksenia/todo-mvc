package ru.hh.todo.mvc.model;

public class ToDoItem {

    private long id;

    private String content;

    private boolean completed;

    public ToDoItem() {}

    public ToDoItem(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public ToDoItem(ToDoItemDTO itemDTO) {
        this.id = itemDTO.getId();
        this.content = itemDTO.getTitle();
        this.completed = itemDTO.isCompleted();
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(long id) {
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

        ToDoItem item = (ToDoItem) o;

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
