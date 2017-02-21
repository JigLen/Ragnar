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
}
