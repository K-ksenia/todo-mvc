package ru.hh.todo.mvc.dao;

import ru.hh.todo.mvc.model.ToDoItem;
import java.util.List;

public interface ToDoItemDAO {

    List<ToDoItem> getAllItems();

    ToDoItem getItemById(int id);

    void insertItem(ToDoItem item);

    boolean updateItem(int id, ToDoItem item);

    boolean deleteItem(int id);

    void deleteAllItems();

};
