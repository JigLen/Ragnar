package com.vikings.ragnar.ejb;

import com.vikings.ragnar.entities.BaseDataEntity;
import javax.ejb.Local;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Local
public interface BaseDataService {
    Collection<BaseDataEntity> getAllInfo();

    void addBaseData(BaseDataEntity baseData);

    BaseDataEntity getById(Integer id);

    void update(BaseDataEntity baseData);

    void remove(Integer id);

    Collection<BaseDataEntity> searchErrorInfoBasedOnIMSI(Long imsi);

    List<?> countNoOfFailuresForImsi(Date date1, Date date2);

    Collection<BaseDataEntity> getMostCommonMarketOperatorCellCombo();

    Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2);

    Collection<?> getUniqueCauseCodes(Long imsi);

    Collection<?> getImsisByFailureClass(Integer failureClass);

    Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2);

    Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo);
}
