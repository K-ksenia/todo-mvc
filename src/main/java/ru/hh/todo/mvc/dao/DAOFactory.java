package ru.hh.todo.mvc.dao;

public abstract class DAOFactory {

    public static final int COLLECTION = 1;

    public abstract ToDoItemDAO getToDoItemDAO();

    public abstract void populateTestData();

    public static DAOFactory getDAOFactory(int factoryCode) {
        switch (factoryCode) {
            case COLLECTION:
                return new CollectionDAOFactory();
            default:
                return new CollectionDAOFactory();
        }
    }
}
