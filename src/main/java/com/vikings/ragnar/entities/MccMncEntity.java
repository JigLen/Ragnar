package com.vikings.ragnar.entities;

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
                        "WHERE e.mcc = :mcc AND " +
                        "      e.mnc = :mnc")
})

@Table(name="mcc_mnc")
public class MccMncEntity implements Serializable{

    // Mobile Country Codes (MCC) and Mobile Network Codes (MNC)
    @Id @Column(name="MCC")     private Integer mcc;
    @Id @Column(name="MNC")     private Integer mnc;
    @Column(name="Country")     private String country;
    @Column(name="Operator")    private String operator;

    public MccMncEntity(){}

    public MccMncEntity(Integer mcc, Integer mnc, String country, String operator) {
        this.mcc = mcc;
        this.mnc = mnc;
        this.country = country;
        this.operator = operator;
    }

    public Integer getMcc() {
        return mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    public Integer getMnc() {
        return mnc;
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
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
