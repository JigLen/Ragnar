package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 16/02/2017.
 */

@Stateless
@Local
public class BaseDataDaoImpl implements BaseDataDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public Collection<BaseDataEntity> getAllInfo() {
        Query query = em.createQuery("from BaseDataEntity");
        List<BaseDataEntity> baseData = query.getResultList();
        return baseData;
    }
}
