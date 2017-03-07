package com.vikings.ragnar.daos;
import com.vikings.ragnar.entities.MccMncEntity;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by carlmccann2 on 15/02/2017.
 */

@Stateless
@Local
public class MccMncDaoImpl implements MccMncDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<MccMncEntity> getAllInfo() {
        Query query = em.createQuery("from MccMncEntity");
        List<MccMncEntity> countryNetworkCodes = query.getResultList();
        return countryNetworkCodes;
    }

    @Override
    public void add(MccMncEntity mcc_mnc) {
        Query query = em.createQuery("from EventCauseEntity");
        List<MccMncEntity> list = query.getResultList();
        if (!list.contains(mcc_mnc))
            em.persist(mcc_mnc);


    }

    @Override
    public MccMncEntity getById(Integer mccCode, Integer mncCode) {
        Query query = em.createNamedQuery("searchMccMncByCompKey")
                .setParameter("mcc",mccCode).setParameter("mnc",mncCode);
        MccMncEntity tmp = (MccMncEntity) query.getSingleResult();
        if(tmp != null){
            System.out.println("Found");
        }else{
            System.out.println("Not found");
        }
        return tmp;
    }

    @Override
    public void update(MccMncEntity mcc_mnc) {
        Query query = em.createQuery("from MccMncEntity ");
        List<MccMncEntity> list = query.getResultList();
        for (MccMncEntity mc : list) {
            if(mc.getMcc().equals(mcc_mnc.getMcc()) &&
                    mc.getMnc().equals(mcc_mnc.getMnc())) {
                em.merge(mcc_mnc);
            }else{
                System.out.print("Not found");
            }
        }

    }

    @Override
    public void remove(Integer mccCode, Integer mncCode) {
        Query query = em.createQuery("from MccMncEntity " +
                "where mcc = :mccCode AND mnc = :mncCode")
                .setParameter("mccCode",mccCode).setParameter("mncCode", mncCode);

        MccMncEntity tmp = (MccMncEntity) query.getSingleResult();
        if(tmp != null){
            em.remove(tmp);
        }else{
            System.out.println("Not found");
        }

    }
}
