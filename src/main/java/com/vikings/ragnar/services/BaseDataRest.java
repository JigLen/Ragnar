package com.vikings.ragnar.services;
import com.vikings.ragnar.ejb.BaseDataService;
import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by C07589301 on 02/03/2017.
 */
@Path("/baseData")
public class BaseDataRest {

    @EJB
    BaseDataService baseDataService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(BaseDataEntity baseData) {
        baseDataService.addBaseData(baseData);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/{id}")
    public BaseDataEntity read(@PathParam("id") Integer id) {
        return baseDataService.getById(id);
    }

    @GET @Produces(MediaType.APPLICATION_JSON)
    public Collection<BaseDataEntity> readAll() {
        return baseDataService.getAllInfo();
    }


    @PUT @Consumes(MediaType.APPLICATION_JSON)
    public void update(BaseDataEntity baseData) {
        baseDataService.update(baseData);
    }


    @DELETE @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        baseDataService.remove(id);
    }

}

