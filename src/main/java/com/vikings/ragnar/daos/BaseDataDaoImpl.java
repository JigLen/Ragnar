package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.BaseDataEntity;
import com.vikings.ragnar.entities.FailureClassEntity;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.*;
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
    public Collection<?> getImsisByFailureClass(Integer failureClass) {
        Query query = em.createQuery("select b.imsi from BaseDataEntity b where b.failureClass=:input group by b.imsi").setParameter("input", failureClass);
        Collection<?> results = query.getResultList();
        return results;
    }
}
