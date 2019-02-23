package ru.hh.todo.mvc.dao;

import ru.hh.todo.mvc.model.ToDoItem;

public class CollectionDAOFactory extends DAOFactory {

    private static final ToDoItemDAOImpl toDoItemDAO = new ToDoItemDAOImpl();

    public ToDoItemDAO getToDoItemDAO() {
        return toDoItemDAO;
    }

    public void populateTestData() {
        ToDoItem item = new ToDoItem(1, "ToDoTest");
        toDoItemDAO.insertItem(item);
    }
}
