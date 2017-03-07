package com.vikings.ragnar.services;

import com.vikings.ragnar.ejb.EventCauseService;
import com.vikings.ragnar.entities.EventCauseEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by carlmccann2 on 01/03/2017.
 */
@Path("/event_cause")
public class EventCauseRest implements Crud {
    @EJB    EventCauseService eventCauseService;



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(EventCauseEntity eventCause){
        eventCauseService.add(eventCause);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{causeCode}/{id}")
    public EventCauseEntity read(@PathParam("causeCode") Integer causeCode,@PathParam("id") Integer id) {
        return eventCauseService.getById(causeCode, id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventCauseEntity> readAll() {
        return eventCauseService.getAllInfo();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(EventCauseEntity eventCause) {
        eventCauseService.update(eventCause);
    }

    @DELETE
    @Path("/{causeCode}/{id}")
    public void delete(@PathParam("causeCode") Integer causeCode, @PathParam("id") Integer id) {
        eventCauseService.remove(causeCode, id);
    }
}

