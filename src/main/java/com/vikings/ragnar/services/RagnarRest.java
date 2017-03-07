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
    @EJB UeService ueServiceEjb;
    @EJB UserService userServiceEjb;


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



    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUeInfo")
    public Collection<UeEntity> getAllUeInfo(){
        return ueServiceEjb.getAllInfo();
    }
<<<<<<< HEAD

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userLogin")
    public Collection<UserEntity> getUser(){
        return userServiceEjb.getUser(1,"test");
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userLogin")
    public UserEntity getUser(Integer id, String password){
        return userServiceEjb.getUser(1,"test");
    }*/
    /*public UserEntity getUser(Integer id, String password){
        return userServiceEjb.getUser(id,password);
    }*/
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


=======
>>>>>>> db633113f9cad94cf2fcdb81508c89093edd9b03
}
