package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by a13168 on 2014/04/04.
 */
@Path("helloworld")
public class HelloWorldResource {
    public  static  final  String CLICHED_MESSAGE = "Hello World Jersey!";

    @GET
    @Produces("text/plain")
    public String getHello() {
        return CLICHED_MESSAGE;
    }
}
