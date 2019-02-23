package ru.hh.todo.mvc.dao;

import ru.hh.todo.mvc.model.ToDoItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoItemDAOImpl implements ToDoItemDAO {

    private static Map<Integer, ToDoItem> toDoItemMap = new HashMap<>();

    public List<ToDoItem> getAllItems() {
        return new ArrayList<ToDoItem>(toDoItemMap.values());
    }

    public ToDoItem getItemById(int id) {
        return toDoItemMap.get(id);
    }

    public void insertItem(ToDoItem item) {
        toDoItemMap.put(item.getId(), item);
    }

    public boolean updateItem(int id, ToDoItem item) {
        return toDoItemMap.replace(id, item) != null;
    }

    public boolean deleteItem(int id) {
        return toDoItemMap.remove(id) != null;
    }

    public void deleteAllItems() {
        toDoItemMap.clear();
    }

};
