package nl.terra10.api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/todos")
public class TodosResource {

    @Inject
    TodoService todoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> hello() {
        return todoService.list();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public List<Todo> addTodo(Todo todo) {
        todoService.add(todo);
        return todoService.list();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public List<Todo> delete(@PathParam("id") int id) {
        todoService.remove(id);
        return todoService.list();
    }

    @DELETE
    @Produces("application/json")
    public List<Todo> delete() {
        todoService.removeAll();
        return todoService.list();
    }


}