package com.vikings.ragnar.entities;

import com.vikings.ragnar.entities.embeddable.MccMncId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 15/02/2017.
 */



@Entity
@NamedQueries({
        @NamedQuery(name="searchMccMncByCompKey",
                query="SELECT e " +
                        "FROM MccMncEntity e " +
                        "WHERE e.mccMncId.mcc = :mcc AND " +
                        "      e.mccMncId.mnc = :mnc")
})

@Table(name="mcc_mnc")
public class MccMncEntity implements Serializable{

    // Mobile Country Codes (MCC) and Mobile Network Codes (MNC)
    @EmbeddedId protected MccMncId mccMncId;
    @Column(name="Country")     private String country;
    @Column(name="Operator")    private String operator;

    public MccMncEntity(){}

    public MccMncEntity(MccMncId mccMncId){
        this.mccMncId = mccMncId;
    }



    public MccMncEntity(MccMncId mccMncId, String country, String operator) {
        this.mccMncId = mccMncId;
        this.country = country;
        this.operator = operator;
    }

    public Integer getMcc() {
        return mccMncId.getMCC();
    }

    public void setMcc(Integer mcc) {
        this.mccMncId.setMcc(mcc);
    }

    public Integer getMnc() {
        return mccMncId.getMNC();
    }

    public void setMnc(Integer mnc) {
        this.mccMncId.setMnc(mnc);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
