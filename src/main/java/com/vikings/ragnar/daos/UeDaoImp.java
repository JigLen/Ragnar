package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.UeEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 19/02/2017.
 */
@Stateless
@Local
public class UeDaoImp implements UeDao {
    @PersistenceContext
    EntityManager em;


    @Override
    public Collection<UeEntity> getAllInfo() {
        Query query = em.createQuery("from UeEntity");
        List<UeEntity> allInfo = query.getResultList();
        return allInfo;
    }
}
