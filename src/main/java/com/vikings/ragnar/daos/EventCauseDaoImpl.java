package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.EventCauseEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 28/02/2017.
 */
@Stateless
@Local
public class EventCauseDaoImpl implements EventCauseDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public Collection<EventCauseEntity> getAllInfo() {
        Query query = em.createQuery("from EventCauseEntity");
        List<EventCauseEntity> eventCauseData = query.getResultList();
        return eventCauseData;
    }

    @Override
    public void add(EventCauseEntity eventCause) {
        Query query = em.createQuery("from EventCauseEntity");
        List<EventCauseEntity> list = query.getResultList();
        if (!list.contains(eventCause))
            em.persist(eventCause);
    }

    @Override
    public void remove(int causeCode,int id) {
        Query query = em.createQuery("from EventCauseEntity " +
                "where cpk.causeCode = :causeCode AND cpk.eventId= :id")
                .setParameter("causeCode",causeCode).setParameter("id", id);

        EventCauseEntity tmp = (EventCauseEntity) query.getSingleResult();
        if(tmp != null){
            em.remove(tmp);
        }else{
            System.out.println("Not found");
        }

    }

    @Override
    public void update(EventCauseEntity eventCause) {
        Query query = em.createQuery("from EventCauseEntity ");
        List<EventCauseEntity> list = query.getResultList();
        for (EventCauseEntity mc : list) {
            if(mc.getCauseCode().equals(eventCause.getCauseCode()) &&
                    mc.getEventId().equals(eventCause.getEventId())) {
                em.merge(eventCause);
            }else{
                System.out.print("Not found");
            }
        }
    }

    @Override
    public EventCauseEntity getById(int causeCode, int id){
        Query query = em.createNamedQuery("searchEventCauseByCompKey")
                .setParameter("causeCode",causeCode).setParameter("id",id);
        EventCauseEntity tmp = (EventCauseEntity) query.getSingleResult();
        if(tmp != null){
            System.out.println("Found");
        }else{
            System.out.println("Not found");
        }
        return tmp;
    }
}
