package com.vikings.ragnar.services;

import com.vikings.ragnar.ejb.UeService;
import com.vikings.ragnar.entities.UeEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by C07589301 on 02/03/2017.
 */
@Path("/ue")
public class UeRest {

    @EJB
    UeService ueService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(UeEntity ue) {
        ueService.addUe(ue);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/{id}")
    public UeEntity read(@PathParam("id") Integer id) {
        return ueService.getById(id);
    }

    @GET @Produces(MediaType.APPLICATION_JSON)
    public Collection<UeEntity> readAll() {
        return ueService.getAllInfo();
    }


    @PUT @Consumes(MediaType.APPLICATION_JSON)
    public void update(UeEntity ue) {
        ueService.update(ue);
    }


    @DELETE @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        ueService.remove(id);
    }
}
