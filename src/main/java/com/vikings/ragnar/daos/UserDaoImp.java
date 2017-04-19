package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.UserEntity;

import java.util.*;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Ciaran on 23/02/2017.
 */
@Stateless
@Local
public class UserDaoImp implements  UserDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public UserEntity getUser(Integer id,String password) {

        Query query = em.createNamedQuery("getUser");

        query.setParameter("id", id);
        query.setParameter("password", password);
        List<UserEntity> allUserInfo = query.getResultList();
        return allUserInfo.get(0);
    }

    @Override
    public void addUser(UserEntity user) {
        em.persist(user);
    }


    // Annotation says that we do not need to open a transaction
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public UserEntity findUserById(Integer id) {
        return em.find(UserEntity.class, id);
    }


}
