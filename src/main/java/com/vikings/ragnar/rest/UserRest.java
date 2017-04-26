package com.vikings.ragnar.rest;

import com.vikings.ragnar.ejb.UserService;
import com.vikings.ragnar.entities.UserEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by c12317616 on 02/03/2017.
 */
@Path("/user")
public class UserRest {
    @EJB    UserService userServiceEjb;

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/{userId}/{password}")
    public UserEntity getUser(@PathParam("userId") String username, @PathParam("password") String password){
        return userServiceEjb.getUser(username,password);
    }

    @POST @Consumes(MediaType.APPLICATION_JSON)
    public void create(UserEntity user) {
        userServiceEjb.addUser(user);
    }
}
