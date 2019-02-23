package ru.hh.todo.mvc.service;

import ru.hh.todo.mvc.dao.DAOFactory;
import ru.hh.todo.mvc.model.ToDoItem;
import ru.hh.todo.mvc.model.ToDoItemDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoService {

    private final DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.COLLECTION);

    public List<ToDoItemDTO> getAllItems() {
        return daoFactory.getToDoItemDAO().getAllItems()
                .stream().map(ToDoItemDTO::new).collect(Collectors.toList());
    }

    public List<ToDoItemDTO> getActiveItems() {
        return daoFactory.getToDoItemDAO().getAllItems()
                .stream().filter((toDoItem -> !toDoItem.isCompleted()))
                .map(ToDoItemDTO::new).collect(Collectors.toList());
    }

    public List<ToDoItemDTO> getCompletedItems() {
        return daoFactory.getToDoItemDAO().getAllItems()
                .stream().filter((ToDoItem::isCompleted))
                .map(ToDoItemDTO::new).collect(Collectors.toList());
    }

    public ToDoItemDTO getItemById(int id) {
        return new ToDoItemDTO(daoFactory.getToDoItemDAO().getItemById(id));
    }

    public void insertItem(ToDoItem item) {
        daoFactory.getToDoItemDAO().insertItem(item);
    }

    public boolean updateItem(int id, ToDoItem item) {
        return daoFactory.getToDoItemDAO().updateItem(id, item);
    }

    public boolean deleteItem(int id) {
        return daoFactory.getToDoItemDAO().deleteItem(id);
    }

    public void deleteAllItems() {
        daoFactory.getToDoItemDAO().deleteAllItems();
    }

}
