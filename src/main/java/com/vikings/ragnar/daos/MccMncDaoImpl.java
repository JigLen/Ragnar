package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 15/02/2017.
 */

@Stateless
@Local
public class MccMncDaoImpl implements MccMncDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<MccMncEntity> getAllInfo() {
        Query query = em.createQuery("from MccMncEntity");
        List<MccMncEntity> countryNetworkCodes = query.getResultList();
        return countryNetworkCodes;
    }
}
