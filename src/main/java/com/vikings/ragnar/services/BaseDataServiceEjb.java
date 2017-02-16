package com.vikings.ragnar.services;

import com.vikings.ragnar.daos.BaseDataDao;
import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Stateless
@Local
public class BaseDataServiceEjb implements BaseDataService{

    @EJB
    private BaseDataDao baseDataDao;
    @Override
    public Collection<BaseDataEntity> getAllInfo() {
        return baseDataDao.getAllInfo();
    }
}
