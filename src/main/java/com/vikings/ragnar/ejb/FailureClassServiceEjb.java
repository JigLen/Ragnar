package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.FailureClassDao;
import com.vikings.ragnar.entities.FailureClassEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;

/**
 * Created by carlmccann2 on 17/02/2017.
 */
@Stateless
@Local
public class FailureClassServiceEjb implements FailureClassService {
    @EJB
    private FailureClassDao failureClassDao;

    @Override
    public Collection<FailureClassEntity> getAllInfo() {
        return failureClassDao.getAllInfo();
    }

    @Override
    public void addFailureClass(FailureClassEntity failureClassEntity) {
        failureClassDao.addFailureClass(failureClassEntity);
    }

    @Override
    public void remove(int id) {
        failureClassDao.remove(id);
    }

    @Override
    public void update(FailureClassEntity failureClassEntity) {
        failureClassDao.update(failureClassEntity);
    }
}
