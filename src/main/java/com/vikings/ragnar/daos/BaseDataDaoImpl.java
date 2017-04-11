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
public class BaseDataDaoImpl implements BaseDataDao {
    @PersistenceContext
    EntityManager em;
    @Override
    public Collection<BaseDataEntity> getAllInfo() {
        Query query = em.createQuery("from BaseDataEntity");
        List<BaseDataEntity> baseData = query.getResultList();
        return baseData;
    }

    @Override
    public void add(BaseDataEntity baseData) {
        Query query = em.createQuery("from BaseDataEntity");
        List<BaseDataEntity> list = query.getResultList();
        if (!list.contains(baseData))
            em.persist(baseData);
    }

    @Override
    public BaseDataEntity getById(Integer id) {
        Query query = em.createQuery("from BaseDataEntity where id = :id").setParameter("id", id);
        BaseDataEntity tmp = (BaseDataEntity) query.getSingleResult();
        if(tmp != null){
            System.out.println("Id found");
        }else{
            System.out.println("Id not found");
        }
        return tmp;
    }

    @Override
    public void update(BaseDataEntity baseData) {
        Query query = em.createQuery("from BaseDataEntity");
        List<BaseDataEntity> list = query.getResultList();
        for (BaseDataEntity mc : list) {
            if(mc.getId().equals(baseData.getId())){
                em.merge(baseData);
            }else{
                System.out.print("Not found");
            }
        }

    }

    @Override
    public void remove(Integer id) {
        Query query = em.createQuery("from BaseDataEntity where id = :id").setParameter("id", id);
        BaseDataEntity tmp = (BaseDataEntity) query.getSingleResult();
        if(tmp != null){
            em.remove(tmp);
        }else{
            System.out.println("Id not found");
        }
    }

    @Override
    public Collection<?> searchErrorInfoBasedOnIMSI(Long imsi) {
        Query query = em.createQuery( "SELECT b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode, b.failureClass, e.description " +
                "FROM BaseDataEntity as b join b.eventCauseEntity as e  " +
                "where b.eventCauseEntity.cpk.eventId = e.cpk.eventId " +
                "and b.eventCauseEntity.cpk.causeCode = e.cpk.causeCode " +
                "and b.imsi = :imsi").setParameter("imsi", imsi);


        List<?> list = query.getResultList();
        return list;

//        Query query = em.createQuery(
//
//                "SELECT BaseDataEntity.eventCauseEntity.cpk.eventId , BaseDataEntity.eventCauseEntity.cpk.causeCode , BaseDataEntity.imsi ," +
//                        " EventCauseEntity.description  " +
//                "FROM BaseDataEntity join  EventCauseEntity  " +
//                "on  BaseDataEntity.eventCauseEntity.cpk.eventId = EventCauseEntity.cpk.eventId " +
//                "and " +
//                "BaseDataEntity.eventCauseEntity.cpk.causeCode = EventCauseEntity.cpk.causeCode " +
//                "WHERE BaseDataEntity.imsi = 310560000000012 ");

/*
       Query query = em.createQuery( "select  b from BaseDataEntity b inner join b.eventCauseEntity.cpk " +
                " where b.imsi = 310560000000012");
                */
        //Query query = em.createQuery( "from BaseDataEntity where imsi =:imsi").setParameter("imsi", imsi);

/*
    "SELECT b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode, b.failureClass, e.description " +
       "FROM BaseDataEntity as b join b.eventCauseEntity as e  " +
       "where b.eventCauseEntity.cpk.eventId = e.cpk.eventId " +
       "and b.eventCauseEntity.cpk.causeCode = e.cpk.causeCode " +
       "and b.imsi = 310560000000012");
        List<BaseDataEntity> baseData =  query.getResultList();
*/
        /*Query query = em.createQuery(
             "SELECT b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode, b.failureClass,e.description" +
                "FROM BaseDataEntity b join EventCauseEntity  e on  " +
                "on   " +
                "WHERE b.imsi = 310560000000012");*/
/*
        List<BaseDataEntity> baseData =  query.getResultList();
        List<Object[]> data = (List<Object[]>) query.getResultList();
        for(Object[] b : data){
            System.out.println("Event Id:" + b[0]);
            System.out.println("Cause Code:" + b[1]);
            System.out.println("Failure Class:" + b[2]);
            System.out.println("IMSI:" + b[3]);
        }
        //List<BaseDataEntity> baseData = query.getResultList();
        */

    }

    // US 9
    @Override
    public List<?> countNoOfFailuresForImsi(Date date1, Date date2) {
        Query query = em.createQuery( "select b.imsi, count(*),sum(b.duration) from BaseDataEntity b " +
                "where b.dateTime between :date1 and :date2 group by b.imsi");
        query.setParameter("date1", date1);
        query.setParameter("date2", date2);
        List<?> data = query.getResultList();
        return data;
    }

    // US 11
    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo){
            Query query = em.createQuery("select base.market, base.operator,base.cellId from BaseDataEntity base where dateTime between :dateOne " +
                    "and :dateTwo " +
                    "group by base.market,base.operator,base.cellId " +
                    "order by count(base) desc ");
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
            Query query = em.createQuery("select base.imsi, count(base) from BaseDataEntity base where dateTime between :date1 and :date2 " +
                    "group by base.imsi order by count(base) desc");
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            query.setMaxResults(10);
            List<BaseDataEntity> lstCombo = query.getResultList();
            return lstCombo;
    }

    //US 6
    @Override
    public Collection<?> getUniqueCauseCodes(Long imsi)
    {
//            Query query = em.createQuery("select distinct b.eventCauseEntity.cpk.causeCode from BaseDataEntity b " +
//                    "where b.imsi = :imsi").setParameter("imsi", imsi);
        Query query = em.createQuery("select distinct b.eventCauseEntity.cpk.causeCode from BaseDataEntity b " +
                "where b.imsi = :imsi").setParameter("imsi", imsi);
            List<?> uCC = query.getResultList();
            return uCC;
    }

    @Override
    public Collection<?> getImsisByFailureClass(Integer failureClass) {
        Query query = em.createQuery("select b.imsi from BaseDataEntity b where b.failureClass=:input group by b.imsi").setParameter("input", failureClass);
        Collection<?> results = query.getResultList();
        return results;
    }

    //7
    @Override
    public Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2){
        Query query = em.createQuery("from BaseDataEntity base where base.dateTime between :d1 and :d2");
        query.setParameter("d1", d1);
        query.setParameter("d2", d2);
        List<BaseDataEntity> lstIMSI = query.getResultList();
        return lstIMSI;
    }

    // US 5
    @Override
    public Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo) {
        Query query = em.createQuery(" SELECT count(base.failureClass) from BaseDataEntity base where base.imsi =:imsi and base.dateTime between :d1 and :d2");
        query.setParameter("imsi", imsi);
        query.setParameter("d1", dateFrom);
        query.setParameter("d2", dateTo);
        Long count = (Long)query.getSingleResult();
        return count;

    }
}
