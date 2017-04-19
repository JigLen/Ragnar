package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.UeEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 19/02/2017.
 */
@Local
public interface UeDao {
    Collection<UeEntity> getAllInfo();
    void addUe(UeEntity ue);
    UeEntity getById(Integer id);
    void update(UeEntity ue);
    void remove(Integer id);
}