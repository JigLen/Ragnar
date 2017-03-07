package com.vikings.ragnar.services;
import com.vikings.ragnar.ejb.MccMncService;
import com.vikings.ragnar.entities.MccMncEntity;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by C07589301 on 02/03/2017.
 */
@Path("/mcc_mnc")
public class MccMncRest {

    @EJB
    MccMncService mccMncServiceService;



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(MccMncEntity mccMnc){
        mccMncServiceService.add(mccMnc);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{mcc}/{mnc}")
    public MccMncEntity read(@PathParam("mcc") Integer mccCode,@PathParam("mnc") Integer mncCode) {
        return mccMncServiceService.getById(mccCode, mncCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<MccMncEntity> readAll() {
        return mccMncServiceService.getAllInfo();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(MccMncEntity mccMnc) {
        mccMncServiceService.update(mccMnc);
    }

    @DELETE
    @Path("/{mcc}/{mnc}")
    public void delete(@PathParam("mcc") Integer mccCode, @PathParam("mnc") Integer mncCode) {
        mccMncServiceService.remove(mccCode, mncCode);
    }
}
