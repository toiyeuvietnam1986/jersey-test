package bid.resources;

import bid.dao.TodoDao;
import bid.model.Todo;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

/**
 * Created by a13168 on 2014/04/06.
 */
public class TodoResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public TodoResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    // Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Todo getTodo() {
        Todo todo = TodoDao.instance.getModel().get(id);
        if(todo == null) {
            throw new RuntimeException("Get: Todo with " + id + "not found");
        }
        return todo;
    }

    // for the browser
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public Todo getTodoHTML() {
//        Todo todo = TodoDao.instance.getModel().get(id);
//        if(todo == null) {
//            throw new RuntimeException("Get: Todo with " + id + "not found");
//        }
//        return todo;
//    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTodo(JAXBElement<Todo> todo) {
        Todo c = todo.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteTodo() {
        Todo c = TodoDao.instance.getModel().remove(id);
        if(c == null) {
            throw new RuntimeException("Delete: Todo with " + id + "not found!");
        }
    }

    private Response putAndGetResponse(Todo todo) {
        Response res;
        if(TodoDao.instance.getModel().containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        TodoDao.instance.getModel().put(todo.getId(), todo);
        return res;
    }

}
