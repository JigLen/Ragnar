package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.MccMncDao;
import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.*;
import java.util.Collection;

/**
 * Created by carlmccann2 on 15/02/2017.
 */

@Stateless
@Local
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MccMncServiceEjb implements MccMncService {

    @EJB
    private MccMncDao mccMncDao;

    @Override
    public Collection<MccMncEntity> getAllInfo() {
        return mccMncDao.getAllInfo();
    }

    @Override
    public void add(MccMncEntity mcc_mnc) {
        mccMncDao.add(mcc_mnc);
    }

    @Override
    public MccMncEntity getById(Integer mccCode, Integer mncCode) {
        return mccMncDao.getById(mccCode, mncCode);
    }

    @Override
    public void update(MccMncEntity mcc_mnc) {
        mccMncDao.update(mcc_mnc);

    }

    @Override
    public void remove(Integer mccCode, Integer mncCode) {
        mccMncDao.remove(mccCode,mncCode);
    }
}
