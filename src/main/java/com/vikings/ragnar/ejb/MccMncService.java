package com.vikings.ragnar.ejb;

import com.vikings.ragnar.entities.EventCauseEntity;
import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 15/02/2017.
 */
@Local
public interface MccMncService {
    Collection<MccMncEntity> getAllInfo();

    void add(MccMncEntity eventCause);

    MccMncEntity getById(Integer mccCode, Integer mncCode);

    void update(MccMncEntity mcc_mnc);

    void remove(Integer mccCode, Integer mncCode);
}
