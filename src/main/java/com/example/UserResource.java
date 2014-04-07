package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.awt.*;
import java.net.URI;

/**
 * Created by a13168 on 2014/04/04.
 */
@Path("/users/{username:[a-zA-Z][a-zA-Z_0-9]*}")
public class UserResource {

    @Context
    UriInfo uriInfo;
    @Context
    Container container;

    @GET
    @Produces("text/html")
    public String getUser(@PathParam("username") String username) {
        return username;
    }
}

