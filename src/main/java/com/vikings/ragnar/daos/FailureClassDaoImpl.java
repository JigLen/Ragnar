package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.FailureClassEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 17/02/2017.
 */
@Stateless
@Local
public class FailureClassDaoImpl implements FailureClassDao{
    @PersistenceContext
    EntityManager em;
    @Override
    public Collection<FailureClassEntity> getAllInfo() {
        Query query = em.createQuery("from FailureClassEntity");
        List<FailureClassEntity> allData = query.getResultList();
        return allData;
    }

    ////////
    public void addFailureClass(FailureClassEntity failureClass) {
        Query query = em.createQuery("from FailureClassEntity");
        List<FailureClassEntity> list = query.getResultList();
        if (!list.contains(failureClass))
            em.persist(failureClass);

    }
    public FailureClassEntity getById(int id)
    {
        Query query = em.createQuery("from FailureClassEntity where failureClass = :id").setParameter("id", id);
        FailureClassEntity tmp = (FailureClassEntity) query.getSingleResult();
        if(tmp != null){
            System.out.println("Id found");
        }else{
            System.out.println("Id not found");
        }
        return tmp;
    }

    public void remove(int id) {
        //Query query = em.createQuery("from MyCharacter");
        Query query = em.createQuery("from FailureClassEntity where failureClass = :id").setParameter("id", id);
        FailureClassEntity tmp = (FailureClassEntity) query.getSingleResult();
        //List<MyCharacter> list = query.getResultList();
        //for (MyCharacter mc : list) {
        //if(mc.getId() == id){
        if(tmp != null){
            em.remove(tmp);
        }else{
            System.out.println("Id not found");
        }


    }


    public void update(FailureClassEntity failureClass) {
        Query query = em.createQuery("from FailureClassEntity");
        List<FailureClassEntity> list = query.getResultList();
        for (FailureClassEntity mc : list) {
            if(mc.getFailureClass().equals(failureClass.getFailureClass())){
                em.merge(failureClass);
            }else{
                System.out.print("Not found");
            }
        }

    }
}
