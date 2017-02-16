package com.vikings.ragnar.entities;

/**
 * Created by carlmccann2 on 16/02/2017.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="base_data")
public class BaseDataEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="Date_Time") private Date date_time;
    @Column(name="Event_id") private Integer event_id;
    @Column(name="Failure_Class") private String failure_class;
    @Column(name="UE_Type") private String ue_type;
    @Column(name="Market") private Integer market;
    @Column(name="Operator") private Integer operator;
    @Column(name="Cell_id") private Integer cell_id;
    @Column(name="Duration") private Integer duration;
    @Column(name="Cause_Code") private Integer cause_code;
    @Column(name="NE_Version") private String ne_version;
    @Column(name="IMSI") private BigDecimal imsi;
    @Column(name="HIER3_ID") private BigDecimal hier3_id;
    @Column(name="HIER32_ID") private BigDecimal hier32_id;
    @Column(name="HER321_ID") private BigDecimal hier321_id;

    public BaseDataEntity(){}

    public BaseDataEntity(Date date_time, Integer event_id, String failure_class, String ue_type, Integer market, Integer operator,
                          Integer cell_id, Integer duration, Integer cause_code, String ne_version, BigDecimal imsi, BigDecimal hier3_id, BigDecimal hier32_id,
                          BigDecimal hier321_id) {
        this.date_time = date_time;
        this.event_id = event_id;
        this.failure_class = failure_class;
        this.ue_type = ue_type;
        this.market = market;
        this.operator = operator;
        this.cell_id = cell_id;
        this.duration = duration;
        this.cause_code = cause_code;
        this.ne_version = ne_version;
        this.imsi = imsi;
        this.hier3_id = hier3_id;
        this.hier32_id = hier32_id;
        this.hier321_id = hier321_id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getFailure_class() {
        return failure_class;
    }

    public void setFailure_class(String failure_class) {
        this.failure_class = failure_class;
    }

    public String getUe_type() {
        return ue_type;
    }

    public void setUe_type(String ue_type) {
        this.ue_type = ue_type;
    }

    public Integer getMarket() {
        return market;
    }

    public void setMarket(Integer market) {
        this.market = market;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getCell_id() {
        return cell_id;
    }

    public void setCell_id(Integer cell_id) {
        this.cell_id = cell_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCause_code() {
        return cause_code;
    }

    public void setCause_code(Integer cause_code) {
        this.cause_code = cause_code;
    }

    public String getNe_version() {
        return ne_version;
    }

    public void setNe_version(String ne_version) {
        this.ne_version = ne_version;
    }

    public BigDecimal getImsi() {
        return imsi;
    }

    public void setImsi(BigDecimal imsi) {
        this.imsi = imsi;
    }

    public BigDecimal getHier3_id() {
        return hier3_id;
    }

    public void setHier3_id(BigDecimal hier3_id) {
        this.hier3_id = hier3_id;
    }

    public BigDecimal getHier32_id() {
        return hier32_id;
    }

    public void setHier32_id(BigDecimal hier32_id) {
        this.hier32_id = hier32_id;
    }

    public BigDecimal getHier321_id() {
        return hier321_id;
    }

    public void setHier321_id(BigDecimal hier321_id) {
        this.hier321_id = hier321_id;
    }




}

