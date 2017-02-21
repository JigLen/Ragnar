package com.vikings.ragnar.services;


import com.vikings.ragnar.daos.UeDao;
import com.vikings.ragnar.ejb.*;
import com.vikings.ragnar.entities.*;
import javafx.event.EventTarget;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by carlmccann2 on 15/02/2017.
 */

@Path("/ragnar")
public class RagnarRest {
    @EJB MccMncService mccMncServiceEjb;
    @EJB BaseDataService baseDataServiceEjb;
    @EJB FailureClassService failureClassServiceEjb;
    @EJB UeService ueServiceEjb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allMccMncInfo")
    public Collection<MccMncEntity> getAllMccMncInfo(){
        return mccMncServiceEjb.getAllInfo();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allBaseDataInfo")
    public Collection<BaseDataEntity> getAllBaseDataInfo(){
        return baseDataServiceEjb.getAllInfo();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allFailureClassInfo")
    public Collection<FailureClassEntity> getAllFailureClassInfo(){
        return failureClassServiceEjb.getAllInfo();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUeInfo")
    public Collection<UeEntity> getAllUeInfo(){
        return ueServiceEjb.getAllInfo();
    }

    /////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFailureClass(FailureClassEntity failureClass){
        failureClassServiceEjb.addFailureClass(failureClass);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCharacter(@PathParam("id") int id) {
        failureClassServiceEjb.remove(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(FailureClassEntity failureClass){
        failureClassServiceEjb.update(failureClass);
    }


}
