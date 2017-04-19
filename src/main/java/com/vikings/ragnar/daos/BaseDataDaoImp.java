package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.BaseDataEntity;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by carlmccann2 on 16/02/2017.
 */


@Stateless
@Local
public class BaseDataDaoImp implements BaseDataDao {
    @PersistenceContext
    EntityManager em;

    // US 4
    @Override
    public Collection<?> searchErrorInfoBasedOnIMSI(Long imsi) {
        Query query = em.createNamedQuery("US4").setParameter("imsi", imsi);
        List<?> list = query.getResultList();
        return list;
    }

    // US 5
    @Override
    public Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo) {
        Query query = em.createNamedQuery("US5");
        query.setParameter("imsi", imsi);
        query.setParameter("d1", dateFrom);
        query.setParameter("d2", dateTo);
        Long count = (Long)query.getSingleResult();
        return count;
    }

    //US 6
    @Override
    public Collection<?> getUniqueCauseCodes(Long imsi) {
        Query query = em.createNamedQuery("US6").setParameter("imsi", imsi);
        List<?> uCC = query.getResultList();
        return uCC;
    }

    // US 7
    @Override
    public Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2){
        Query query = em.createNamedQuery("US7");
        query.setParameter("d1", d1);
        query.setParameter("d2", d2);
        List<BaseDataEntity> lstIMSI = query.getResultList();
        return lstIMSI;
    }

    //US8
    @Override
    public Collection<?> countNoOfCallFailuresForGivenModel(String model, Date date1, Date date2) {
        Query query = em.createNamedQuery("US8");
        query.setParameter("model", model);
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        Collection<?> results = query.getResultList();
        return results;
    }

    // US 9
    @Override
    public List<?> countNoOfFailuresForImsi(Date date1, Date date2) {
        Query query = em.createNamedQuery("US9");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        List<?> data = query.getResultList();
        return data;
    }

    //US10
    @Override
    public Collection<?> getAllUniqueCallFailuresForGivenModelOfPhone(String model) {
        Query query = em.createNamedQuery("US10").setParameter("model", model);
        Collection<?> results = query.getResultList();
        return results;
    }

    // US 11
    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo){
        Query query = em.createNamedQuery("US11");
        query.setParameter("dateOne", dateOne);
        query.setParameter("dateTwo", dateTwo);
        query.setMaxResults(10);
        List<BaseDataEntity> lstCombo = query.getResultList();
        return lstCombo;
    }

    // US 12
    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2)
    {
        Query query = em.createNamedQuery("US12");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        query.setMaxResults(10);
        List<BaseDataEntity> lstCombo = query.getResultList();
        return lstCombo;
    }

    // US 14
    @Override
    public Collection<?> getImsisByFailureClass(Integer failureClass) {
        Query query = em.createNamedQuery("US14").setParameter("input",failureClass);
        Collection<?> results = query.getResultList();
        return results;
    }

    //
    @Override
    public Collection<?> getUniqueImsiNumbers() {
        Query query = em.createQuery(" SELECT DISTINCT base.imsi FROM BaseDataEntity base");
        Collection<?> results = query.getResultList();
        return results;
    }
}
