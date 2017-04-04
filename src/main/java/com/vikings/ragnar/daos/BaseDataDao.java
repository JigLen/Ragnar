package com.vikings.ragnar.daos;

import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.Local;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Local
public interface BaseDataDao {
    Collection<BaseDataEntity> getAllInfo();

    void add(BaseDataEntity baseData);

    BaseDataEntity getById(Integer id);

    void update(BaseDataEntity baseData);

    void remove(Integer id);

    Collection<?> searchErrorInfoBasedOnIMSI(Long imsi);

    List<?> countNoOfFailuresForImsi(Date date1, Date date2);

    Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo);

    Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2);

    Collection<?> getUniqueCauseCodes(Long imsi);

    Collection<?> getImsisByFailureClass(Integer failureClass);

    Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2);

    Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo);
}
