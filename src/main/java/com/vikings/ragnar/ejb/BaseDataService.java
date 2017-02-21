package com.vikings.ragnar.ejb;

import com.vikings.ragnar.entities.BaseDataEntity;
import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Local
public interface BaseDataService {
    Collection<BaseDataEntity> getAllInfo();
}