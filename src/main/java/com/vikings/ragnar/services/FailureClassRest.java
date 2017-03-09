package com.vikings.ragnar.services;


import com.vikings.ragnar.ejb.FailureClassService;
import com.vikings.ragnar.entities.FailureClassEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by carlmccann2 on 01/03/2017.
 */
@Path("/failure_class")
public class FailureClassRest implements Crud {
    @EJB    FailureClassService failureClassService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(FailureClassEntity failureClass) {
        failureClassService.addFailureClass(failureClass);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/{id}")
    public FailureClassEntity read(@PathParam("id") Integer id) {
        return failureClassService.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<FailureClassEntity> readAll() {
        return failureClassService.getAllInfo();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(FailureClassEntity failureClass) {
        failureClassService.update(failureClass);
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        failureClassService.remove(id);
    }

}
