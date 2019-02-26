package ru.hh.todo.mvc.dao;

import ru.hh.todo.mvc.model.ToDoItem;
import java.util.List;

public interface ToDoItemDAO {

    List<ToDoItem> getAllItems();

    ToDoItem getItemById(long id);

    void insertItem(ToDoItem item);

    boolean updateItem(long id, ToDoItem item);

    boolean deleteItem(long id);

    void deleteAllItems();

};
