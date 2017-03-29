package com.vikings.ragnar.entities;

/**
 * Created by carlmccann2 on 16/02/2017.
 */


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="base_data")
public class BaseDataEntity implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="Date_Time") private Timestamp dateTime;
    @Column(name="Event_id") private Integer eventId;
    @Column(name="Failure_Class") private Integer failureClass;
    @Column(name="UE_Type") private Integer ueType;
    @Column(name="Market") private Integer market;
    @Column(name="Operator") private Integer operator;
    @Column(name="Cell_id") private Integer cellId;
    @Column(name="Duration") private Integer duration;
    @Column(name="Cause_Code") private Integer causeCode;
    @Column(name="NE_Version") private String neVersion;
    @Column(name="IMSI") private BigDecimal imsi;
    @Column(name="HIER3_ID") private BigDecimal hier3Id;
    @Column(name="HIER32_ID") private BigDecimal hier32Id;
    @Column(name="HER321_ID") private BigDecimal hier321Id;

    public BaseDataEntity(){}

    public BaseDataEntity(Timestamp dateTime, Integer eventId, Integer failureClass, Integer ueType, Integer market, Integer operator,
                          Integer cellId, Integer duration, Integer causeCode, String neVersion, BigDecimal imsi, BigDecimal hier3Id, BigDecimal hier32Id,
                          BigDecimal hier321Id) {
        this.dateTime = dateTime;
        this.eventId = eventId;
        this.failureClass = failureClass;
        this.ueType = ueType;
        this.market = market;
        this.operator = operator;
        this.cellId = cellId;
        this.duration = duration;
        this.causeCode = causeCode;
        this.neVersion = neVersion;
        this.imsi = imsi;
        this.hier3Id = hier3Id;
        this.hier32Id = hier32Id;
        this.hier321Id = hier321Id;
    }

    public long convertDateTimeToMillis()
    {
        return dateTime.getTime();
    }

    public Integer getId(){return id;}

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp date_time) {
        this.dateTime = date_time;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer event_id) {
        this.eventId = event_id;
    }

    public Integer getFailureClass() {
        return failureClass;
    }

    public void setFailureClass(Integer failure_class) {
        this.failureClass = failure_class;
    }

    public Integer getUeType() {
        return ueType;
    }

    public void setUeType(Integer ue_type) {
        this.ueType = ue_type;
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

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cell_id) {
        this.cellId = cell_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(Integer cause_code) {
        this.causeCode = cause_code;
    }

    public String getNeVersion() {
        return neVersion;
    }

    public void setNeVersion(String ne_version) {
        this.neVersion = ne_version;
    }

    public BigDecimal getImsi() {
        return imsi;
    }

    public void setImsi(BigDecimal imsi) {
        this.imsi = imsi;
    }

    public BigDecimal getHier3Id() {
        return hier3Id;
    }

    public void setHier3Id(BigDecimal hier3_id) {
        this.hier3Id = hier3_id;
    }

    public BigDecimal getHier32Id() {
        return hier32Id;
    }

    public void setHier32Id(BigDecimal hier32_id) {
        this.hier32Id = hier32_id;
    }

    public BigDecimal getHier321Id() {
        return hier321Id;
    }

    public void setHier321Id(BigDecimal hier321_id) {
        this.hier321Id = hier321_id;
    }

    @Override
    public String toString(){
    return "BaseDataEntity: " +
            "\ndateTime: " + dateTime +
            "\neventId: " + eventId +
            "\nfailureClass: " + failureClass +
            "\nueType: " + ueType +
            "\nmarket: " + market +
            "\noperator: " + operator +
            "\ncellId: " + cellId +
            "\nduration: " + duration +
            "\ncauseCode: " + causeCode +
            "\nneVersion: " + neVersion +
            "\nimsi: " + imsi +
            "\nhier3Id: " + hier3Id +
            "\nhier32Id: " + hier32Id +
            "\nhier321Id: " + hier321Id + "\n";
    }

    public boolean isIncomplete(){
        if(dateTime == null) return true;
        if(eventId == null) return true;
        if(failureClass == null) return true;
        if(ueType == null) return true;
        if(market == null) return true;
        if(operator == null) return true;
        if(cellId == null) return true;
        if(duration == null) return true;
        if(causeCode == null) return true;
        if(neVersion== null) return true;
        if(imsi == null) return true;
        if(hier3Id == null) return true;
        if(hier32Id == null) return true;
        if(hier321Id == null) return true;
        return false;
    }

    public boolean failureClassIsValid(){
        if(failureClass >= 0 && failureClass < 5) return true;
        return false;
    }

    public boolean eventIdCauseCodeIsValid(){
        // event_id validation
        if(eventId == 4097){
            if(causeCode >= 0 && causeCode < 17) return true;
        }
        if(eventId == 4098){
            if(causeCode >= 0 && causeCode < 4) return true;
        }
        if(eventId == 4125){
            if(causeCode >= 0 && causeCode < 34) return true;
        }
        if(eventId == 4106){
            if(causeCode >= 0 && causeCode < 25) return true;
        }
        return false;
    }
}

