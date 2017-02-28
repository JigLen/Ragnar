package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.EventCauseDao;
import com.vikings.ragnar.entities.EventCauseEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created by carlmccann2 on 28/02/2017.
 */
@Stateless
@Local
public class EventCauseServiceEjb implements EventCauseService {
    @EJB    private EventCauseDao eventCauseDao;
    @Override
    public Collection<EventCauseEntity> getAllInfo() {
        return eventCauseDao.getAllInfo();
    }
}
