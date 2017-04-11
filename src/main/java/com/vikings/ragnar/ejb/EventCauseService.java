package com.vikings.ragnar.ejb;

import com.vikings.ragnar.entities.EventCauseEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 28/02/2017.
 */
@Local
public interface EventCauseService {
    Collection<EventCauseEntity> getAllInfo();
    void add(EventCauseEntity eventCause);
    void remove(Integer causeCode, Integer id);
    void update(EventCauseEntity eventCause);
    EventCauseEntity getById(Integer causeCode, Integer id);
}