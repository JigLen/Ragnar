package com.vikings.ragnar.services;


import com.vikings.ragnar.entities.BaseDataEntity;
import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by carlmccann2 on 15/02/2017.
 */

@Path("/ragnar")
public class RagnarRest {
    @EJB
    MccMncService mccMncServiceEjb;

    @EJB
    BaseDataService baseDataServiceEjb;

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

}
