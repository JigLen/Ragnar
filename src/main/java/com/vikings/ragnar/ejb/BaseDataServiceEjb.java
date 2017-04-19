package com.vikings.ragnar.ejb;

import com.vikings.ragnar.daos.BaseDataDao;
import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by carlmccann2 on 16/02/2017.
 */
@Stateless
@Local
public class BaseDataServiceEjb implements BaseDataService{

    @EJB
    private BaseDataDao baseDataDao;


    // US 4
    @Override
    public Collection<?> searchErrorInfoBasedOnIMSI(Long imsi) {
        return baseDataDao.searchErrorInfoBasedOnIMSI(imsi);
    }

    // US 5
    @Override
    public Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo) {
        return Long.valueOf(baseDataDao.getByIMSIAndTimePeriod(imsi, dateFrom, dateTo));
    }

    // US 6
    @Override
    public Collection<?> getUniqueCauseCodes(Long imsi) {
        return baseDataDao.getUniqueCauseCodes(imsi);
    }

    // US 7
    @Override
    public Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2){
        return baseDataDao.getAllIMSIByDate(d1,d2);
    }

    // US 8
    @Override
    public Collection<?> countNoOfCallFailuresForGivenModel(String model, Date date1, Date date2) {
        return baseDataDao.countNoOfCallFailuresForGivenModel(model, date1, date2);
    }

    // US 9
    @Override
    public List<?> countNoOfFailuresForImsi(Date date1, Date date2) {
        return baseDataDao.countNoOfFailuresForImsi(date1, date2);
    }

    // US 10
    @Override
    public Collection<?> getAllUniqueCallFailuresForGivenModelOfPhone(String model) {
        return baseDataDao.getAllUniqueCallFailuresForGivenModelOfPhone(model);
    }

    // US 11
    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo) {
        return baseDataDao.getTopTenMostCommonMarketOperatorCellCombo(dateOne, dateTwo);
    }


    // US 12
    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2) {
        return baseDataDao.getTopTenMostCommonImsi(date1,date2 );
    }

    // US 14
    @Override
    public Collection<?> getImsisByFailureClass(Integer failureClass) {
        return baseDataDao.getImsisByFailureClass(failureClass);
    }

    @Override
    public Collection<?> getUniqueImsiNumbers() {
        return baseDataDao.getUniqueImsiNumbers();
    }
    @Override
    public Collection<?> getUniqueModels() {
        return baseDataDao.getUniqueModels();
    }



}
