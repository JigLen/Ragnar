package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.UserEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by  Ciaran Sweeney on 23/02/2017.
 */
@Local
public interface UserDao {
    //UserEntity getUser(Integer id,String password);
    //Collection<UserEntity> getAllUsers();
    UserEntity getUser(Integer id,String password);
    UserEntity findUserById(Integer id);
    void addUser(UserEntity user);
}
