package com.vikings.ragnar.services;


import com.vikings.ragnar.ejb.*;
import com.vikings.ragnar.entities.*;

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



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allUeInfo")
    public Collection<UeEntity> getAllUeInfo(){
        return ueServiceEjb.getAllInfo();
    }
}
