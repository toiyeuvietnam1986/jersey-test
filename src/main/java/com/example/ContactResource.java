package com.example;

import bean.Contact;
import storage.ContactStore;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

/**
 * Created by a13168 on 2014/04/04.
 */
@Path("contact-resource")
public class ContactResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String contact;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it , oh yeah!";
    }

//    public ContactResource(UriInfo uriInfo, Request request, String contact) {
//        this.uriInfo = uriInfo;
//        this.request = request;
//        this.contact = contact;
//    }

//    @GET
//    @Produces({"application/xml", "application/json"})
//    public Contact getContact() {
//        Contact cont = ContactStore.getStore().get(contact);
//        if(cont == null){
//            throw new NotFoundException("No such Contact.");
//        }
//        return cont;
//    }
}
