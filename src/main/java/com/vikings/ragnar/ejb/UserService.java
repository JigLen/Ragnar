package com.vikings.ragnar.ejb;

import com.vikings.ragnar.entities.UserEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by c12317616 on 28/02/2017.
 */
@Local
public interface UserService {
    //UserEntity getUser(Integer id,String password);
    //Collection<UserEntity> getAllUserInfo();
    Collection<UserEntity> getUser(Integer id,String password);
}
