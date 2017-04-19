package com.vikings.ragnar.daos;


import com.vikings.ragnar.entities.UeEntity;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;


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

    @Override
    public void addUe(UeEntity ue) {
        Query query = em.createQuery("from UeEntity");
        List<UeEntity> list = query.getResultList();
        if (!list.contains(ue))
            em.persist(ue);
    }

    @Override
    public UeEntity getById(Integer id) {
        Query query = em.createQuery("from UeEntity where tac = :id").setParameter("id", id);
        UeEntity tmp = (UeEntity) query.getSingleResult();
        if(tmp != null){
            System.out.println("Id found");
        }else{
            System.out.println("Id not found");
        }
        return tmp;
    }

    @Override
    public void update(UeEntity ue) {
        Query query = em.createQuery("from UeEntity");
        List<UeEntity> list = query.getResultList();
        for (UeEntity mc : list) {
            if(mc.getTac().equals(ue.getTac())){
                em.merge(ue);
            }else{
                System.out.print("Not found");
            }
        }
    }

    @Override
    public void remove(Integer id) {
        Query query = em.createQuery("from UeEntity where tac = :id").setParameter("id", id);
        UeEntity tmp = (UeEntity) query.getSingleResult();
        if(tmp != null){
            em.remove(tmp);
        }else{
            System.out.println("Id not found");
        }

    }
}
