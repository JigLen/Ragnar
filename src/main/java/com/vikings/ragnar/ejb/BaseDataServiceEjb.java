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
    @Override
    public Collection<BaseDataEntity> getAllInfo() {
        return baseDataDao.getAllInfo();
    }

    @Override
    public void addBaseData(BaseDataEntity baseData) {
        baseDataDao.add(baseData);
    }

    @Override
    public BaseDataEntity getById(Integer id) {
        return baseDataDao.getById(id);
    }

    @Override
    public void update(BaseDataEntity baseData) {
        baseDataDao.update(baseData);
    }

    @Override
    public void remove(Integer id) {
         baseDataDao.remove(id);
    }

    @Override
    public Collection<?> searchErrorInfoBasedOnIMSI(Long imsi) {
        return baseDataDao.searchErrorInfoBasedOnIMSI(imsi);
    }

    @Override
    public List<?> countNoOfFailuresForImsi(Date date1, Date date2) {
        return baseDataDao.countNoOfFailuresForImsi(date1, date2);
    }

    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonMarketOperatorCellCombo(Date dateOne, Date dateTwo) {
        return baseDataDao.getTopTenMostCommonMarketOperatorCellCombo(dateOne, dateTwo);
    }

    @Override
    public Collection<BaseDataEntity> getTopTenMostCommonImsi(Date date1, Date date2) {
        return baseDataDao.getTopTenMostCommonImsi(date1,date2 );
    }

    @Override
    public Collection<?> getUniqueCauseCodes(Long imsi) {
        return baseDataDao.getUniqueCauseCodes(imsi);
    }

    @Override
    public Collection<?> getImsisByFailureClass(Integer failureClass) {
        return baseDataDao.getImsisByFailureClass(failureClass);
    }

    public Collection<BaseDataEntity> getAllIMSIByDate(Date d1, Date d2){
        return baseDataDao.getAllIMSIByDate(d1,d2);
    }

    @Override
    public Long getByIMSIAndTimePeriod(Long imsi, Date dateFrom, Date dateTo) {
        return Long.valueOf(baseDataDao.getByIMSIAndTimePeriod(imsi, dateFrom, dateTo));
    }
}
