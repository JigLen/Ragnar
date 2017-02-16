package com.vikings.ragnar.services;

import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<MccMncEntity> getAllInfo(){
        return mccMncServiceEjb.getAllInfo();
    }
}
