package bid.client;


import bid.model.Todo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
* Created by a13168 on 2014/04/07.
*/
public class Tester {
    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        // create one todo
        Todo todo = new Todo("4", "Blabla4");
        ClientResponse response = service.path("webapi").path("todos")
                .path(todo.getId()).accept(MediaType.APPLICATION_XML)
                .put(ClientResponse.class, todo);
        // Return code should be 201 == created resource
        System.out.println(response.getStatus());

        // Get the Todos
//        System.out.println(service.path("webapi").path("todos")
//                .accept(MediaType.TEXT_XML).get(String.class));

        // Get JSON for application
//        System.out.println(service.path("webapi").path("todos")
//                .accept(MediaType.APPLICATION_JSON).get(String.class));

        // Get XML for application
        System.out.println(service.path("webapi").path("todos")
                .accept(MediaType.APPLICATION_XML).get(String.class));
        // Get the Todo with id 1
        System.out.println(service.path("webapi").path("todos/1")
        .accept(MediaType.APPLICATION_XML).get(String.class));

        // delete Todo with id 4
        service.path("webapi").path("todos/4").delete();

        // get the all Todos, id 3 should be deleted
        System.out.println(service.path("webapi").path("todos").accept(MediaType.APPLICATION_XML).get(String.class));

        // create a Todo

        Form form = new Form();
        form.add("id", "6");
        form.add("summary", "Demonstration of the client lib for forms");
        response = service.path("webapi").path("todos").type(MediaType.APPLICATION_FORM_URLENCODED)
                .post(ClientResponse.class, form);
        System.out.println("Form response " + response.getEntity(String.class));

        // Get the all todos, id 6 should be created
        System.out.println(service.path("webapi").path("todos").accept(MediaType.APPLICATION_XML).get(String.class));
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080").build();
    }
}
