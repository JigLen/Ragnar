package com.vikings.ragnar.services;

import com.vikings.ragnar.entities.MccMncEntity;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 15/02/2017.
 */
@Local
public interface MccMncService {
    public Collection<MccMncEntity> getAllInfo();
}
