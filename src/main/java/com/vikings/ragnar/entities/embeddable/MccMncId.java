package com.vikings.ragnar.entities.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by C07589301 on 10/04/2017.
 */
@Embeddable
public class MccMncId implements Serializable {


    @Column(name="MCC")
    private Integer mcc;

    @Column(name="MNC")
    private Integer mnc;

    public MccMncId(){
    }

    public MccMncId(Integer mcc, Integer mnc){
        this.mcc = mcc;
        this.mnc = mnc;
    }

    public Integer getMCC() {
        return mcc;
    }

    public Integer getMNC() {
        return mnc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof com.vikings.ragnar.entities.embeddable.MccMncId)) return false;
        com.vikings.ragnar.entities.embeddable.MccMncId that = (com.vikings.ragnar.entities.embeddable.MccMncId) o;
        return Objects.equals(getMCC(), that.getMCC()) &&
                Objects.equals(getMNC(), that.getMNC());
    }


    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(getMCC(), getMNC());
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
    }

    public void setMcc(Integer mcc) {

        this.mcc = mcc;
    }
}