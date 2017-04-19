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

    // US 4
    Collection<?> searchErrorInfoBasedOnIMSI(Long imsi);
    // US 5
    Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo);
    // US 6
    Collection<?> getUniqueCauseCodes(Long imsi);
    // US 7
    Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2);
    // US 8
    Collection<?> countNoOfCallFailuresForGivenModel(String model, Date date1, Date date2);
    // US 9
    List<?> countNoOfFailuresForImsi(Date date1, Date date2);
    // US 10
    Collection<?> getAllUniqueCallFailuresForGivenModelOfPhone(String model);
    // US 11
    Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo);
    // US 12
    Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2);
    // US 14
    Collection<?> getImsisByFailureClass(Integer failureClass);

    Collection<?> getUniqueImsiNumbers();

    Collection<?> getUniqueModels();

}

