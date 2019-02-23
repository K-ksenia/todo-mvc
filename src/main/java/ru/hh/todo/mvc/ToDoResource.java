package ru.hh.todo.mvc;

import ru.hh.todo.mvc.model.ToDoItem;
import ru.hh.todo.mvc.model.ToDoItemDTO;
import ru.hh.todo.mvc.service.ToDoService;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ToDoResource {

    private final ToDoService toDoService = new ToDoService();

    @GET
    @Path("/hello")
    public String hello(@DefaultValue("world") @QueryParam("name") String name) {
        return String.format("Hello, %s!", name);
    }

    @GET
    @Path("/all")
    public List<ToDoItemDTO> getAllItems() {
        return toDoService.getAllItems();
    }

    @GET
    @Path("/active")
    public List<ToDoItemDTO> getActiveItems() {
        return toDoService.getActiveItems();
    }

    @GET
    @Path("/completed")
    public List<ToDoItemDTO> getCompletedItems() {
        return toDoService.getCompletedItems();
    }

    @GET
    @Path("/{id}")
    public ToDoItemDTO getItemById(int id) {
        return toDoService.getItemById(id);
    }

    @POST
    @Path("/add")
    public Response insertItem(ToDoItemDTO item) {
        toDoService.insertItem(new ToDoItem(item));
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateItem(@PathParam("id") int id, ToDoItemDTO item) {
        toDoService.updateItem(id, new ToDoItem(item));
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") int id) {
        toDoService.deleteItem(id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/drop")
    public Response deleteAllItems() {
        toDoService.deleteAllItems();
        return Response.status(Response.Status.OK).build();
    }

}
