package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.UserDao;
import com.vikings.ragnar.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created by c12317616 on 28/02/2017.
 */
@Stateless
@Local
public class UserServiceEjb implements UserService{
    @EJB
    private UserDao userDao;

    @Override
    public UserEntity getUser(String username,String password) {
        return userDao.getUser(username,password);
    }

    @Override
    public UserEntity findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void addUser(UserEntity user) {
        userDao.addUser(user);
    }
}
