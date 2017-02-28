package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.EventCauseEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 28/02/2017.
 */
@Local
public interface EventCauseDao {
    Collection<EventCauseEntity> getAllInfo();
}
