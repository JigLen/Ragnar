package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.UeDao;
import com.vikings.ragnar.entities.UeEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created by carlmccann2 on 19/02/2017.
 */
@Stateless
@Local
public class UeServiceEjb implements UeService {
    @EJB
    UeDao ueDao;

    @Override
    public Collection<UeEntity> getAllInfo() {
        return ueDao.getAllInfo();
    }

    @Override
    public void addUe(UeEntity ue) {
        ueDao.addUe(ue);
    }

    @Override
    public UeEntity getById(Integer id) {
        return ueDao.getById(id);
    }

    @Override
    public void update(UeEntity ue) {
        ueDao.update(ue);
    }

    @Override
    public void remove(Integer id) {
        ueDao.remove(id);
    }
}
