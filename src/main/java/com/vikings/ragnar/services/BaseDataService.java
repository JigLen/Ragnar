package com.vikings.ragnar.services;

import com.vikings.ragnar.entities.BaseDataEntity;
import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Local
public interface BaseDataService {
    public Collection<BaseDataEntity> getAllInfo();
}
