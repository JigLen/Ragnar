package com.vikings.ragnar.entities;

/**
 * Created by carlmccann2 on 16/02/2017.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@NamedQueries({
        @NamedQuery(name = "US4", query = "SELECT b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode, b.failureClassEntity.failureClass, e.description FROM BaseDataEntity AS b JOIN b.eventCauseEntity AS e WHERE b.eventCauseEntity.cpk.eventId = e.cpk.eventId AND b.eventCauseEntity.cpk.causeCode = e.cpk.causeCode AND b.imsi = :imsi"),
        @NamedQuery(name = "US5", query = "SELECT COUNT(b.failureClassEntity.failureClass) FROM BaseDataEntity b WHERE b.imsi =:imsi AND b.dateTime BETWEEN :d1 AND :d2"),
        @NamedQuery(name = "US6", query = "SELECT DISTINCT b.eventCauseEntity.cpk.causeCode FROM BaseDataEntity b WHERE b.imsi = :imsi"),
        @NamedQuery(name = "US7", query = "FROM BaseDataEntity b WHERE b.dateTime BETWEEN :d1 AND :d2"),
        // ??
        @NamedQuery(name = "US8", query = "SELECT b.ueEntity.model, COUNT(*) FROM BaseDataEntity b JOIN b.ueEntity AS ue WHERE ue.model =:model AND b.dateTime BETWEEN :date1 AND :date2"),
        @NamedQuery(name = "US9", query = "SELECT b.imsi, COUNT(*), SUM(b.duration) FROM BaseDataEntity b WHERE b.dateTime BETWEEN :date1 AND :date2 GROUP BY b.imsi"),
        @NamedQuery(name = "US10", query = "SELECT b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode, b.eventCauseEntity.description, COUNT(*), b.ueEntity.model FROM BaseDataEntity AS b INNER JOIN b.ueEntity AS ue WHERE b.ueEntity.model=:model GROUP BY b.eventCauseEntity.cpk.eventId, b.eventCauseEntity.cpk.causeCode"),
        @NamedQuery(name = "US11", query = "SELECT b.mccMncEntity.mccMncId.mcc, b.mccMncEntity.mccMncId.mnc,b.cellId FROM BaseDataEntity b WHERE dateTime BETWEEN :dateOne AND :dateTwo GROUP BY b.mccMncEntity.mccMncId.mcc, b.mccMncEntity.mccMncId.mnc,b.cellId ORDER BY COUNT(b) DESC"),
        @NamedQuery(name = "US12", query = "SELECT b.imsi FROM BaseDataEntity b WHERE dateTime BETWEEN :date1 AND :date2 GROUP BY b.imsi ORDER BY COUNT(b) DESC"),
        @NamedQuery(name = "US14", query = "SELECT b.imsi FROM BaseDataEntity b WHERE b.failureClassEntity.failureClass=:input GROUP BY b.imsi")
})
@Entity
@Table(name="base_data")
public class BaseDataEntity implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="Date_Time") private Timestamp dateTime;
    @Column(name="Cell_id") private Integer cellId;
    @Column(name="Duration") private Integer duration;
    @Column(name="NE_Version") private String neVersion;
    @Column(name="IMSI") private Long imsi;
    @Column(name="HIER3_ID") private BigDecimal hier3Id;
    @Column(name="HIER32_ID") private BigDecimal hier32Id;
    @Column(name="HER321_ID") private BigDecimal hier321Id;

    @JoinColumns({
            @JoinColumn(name="Market", referencedColumnName="MCC"),
            @JoinColumn(name="Operator", referencedColumnName="MNC")

    })
    @ManyToOne
    private MccMncEntity mccMncEntity;

    @JoinColumn(name="UE_Type", referencedColumnName="TAC")
    @ManyToOne
    private UeEntity ueEntity;

    @JoinColumn(name="Failure_Class", referencedColumnName="Failure_Class")
    @ManyToOne
    private FailureClassEntity failureClassEntity;
    @JoinColumns({
            @JoinColumn(
                    name = "Cause_Code", referencedColumnName = "Cause_Code"),
            @JoinColumn(
                    name = "Event_id", referencedColumnName = "Event_id")
    })
    @ManyToOne
    private EventCauseEntity eventCauseEntity;

    public EventCauseEntity getEventCauseEntity() {
        return eventCauseEntity;
    }

    public void setEventCauseEntity(EventCauseEntity eventCauseEntity) {
        this.eventCauseEntity = eventCauseEntity;
    }

    public BaseDataEntity(){
    }

    public BaseDataEntity(Timestamp dateTime, EventCauseEntity eventCauseEntity, FailureClassEntity failureClassEntity, UeEntity ueEntity, MccMncEntity mccMncEntity,
                          Integer cellId, Integer duration, String neVersion, Long imsi, BigDecimal hier3Id, BigDecimal hier32Id,
                          BigDecimal hier321Id) {
        this.dateTime = dateTime;
        this.eventCauseEntity = eventCauseEntity;
        this.failureClassEntity = failureClassEntity;
        this.ueEntity = ueEntity;
        this.mccMncEntity = mccMncEntity;
        this.cellId = cellId;
        this.duration = duration;
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
        return eventCauseEntity.getEventId();
    }

    public void setEventId(Integer event_id) {
        eventCauseEntity.setEventId(event_id);
    }

    public Integer getFailureClass() {
        return failureClassEntity.getFailureClass();
    }

    public void setFailureClass(Integer failure_class) {
        this.failureClassEntity.setFailureClass(failure_class);
    }

    public Integer getUeType() {
        return ueEntity.getTac();
    }

    public UeEntity getUeEntity() {
        return ueEntity;
    }

    public void setUeEntity(UeEntity ueEntity) {
        this.ueEntity = ueEntity;
    }

    public void setUeType(Integer ue_type) {
        this.ueEntity.setTac(ue_type);
    }

    public Integer getMarket() {
        return mccMncEntity.getMcc();
    }

    public void setMarket(Integer market) {
        this.mccMncEntity.setMcc(market);
    }

    public Integer getOperator() {
        return this.mccMncEntity.getMnc();
    }

    public void setOperator(Integer operator) {
        this.mccMncEntity.setMnc(operator);
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
        return eventCauseEntity.getCauseCode();
    }

    public void setCauseCode(Integer cause_code) {
        eventCauseEntity.setCauseCode(cause_code);
    }

    public String getNeVersion() {
        return neVersion;
    }

    public void setNeVersion(String ne_version) {
        this.neVersion = ne_version;
    }

    public Long getImsi() {
        return imsi;
    }

    public void setImsi(Long imsi) {
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

    public FailureClassEntity getFailureClassEntity() {
        return failureClassEntity;
    }

    public void setFailureClassEntity(FailureClassEntity failureClassEntity) {
        this.failureClassEntity = failureClassEntity;
    }

    public MccMncEntity getMccMncEntity() {
        return mccMncEntity;
    }

    public void setMccMncEntity(MccMncEntity mccMncEntity) {
        this.mccMncEntity = mccMncEntity;
    }

    @Override
    public String toString(){
    return "BaseDataEntity: " +
            "\ndateTime: " + dateTime +
//            "\neventId: " + eventId +
            "\neventId: " + eventCauseEntity.getEventId() +
            "\nfailureClass: " + failureClassEntity.getFailureClass() +
            "\nueType: " + ueEntity.getTac() +
            "\nmarket: " + mccMncEntity.getMcc() +
            "\noperator: " + mccMncEntity.getMnc() +
            "\ncellId: " + cellId +
            "\nduration: " + duration +
//            "\ncauseCode: " + causeCode +
            "\ncauseCode: " + eventCauseEntity.getCauseCode() +
            "\nneVersion: " + neVersion +
            "\nimsi: " + imsi +
            "\nhier3Id: " + hier3Id +
            "\nhier32Id: " + hier32Id +
            "\nhier321Id: " + hier321Id + "\n";
    }

    public boolean isIncomplete(){
        if(dateTime == null) return true;
        if(eventCauseEntity.getEventId() == null) return true;
        if(failureClassEntity.getFailureClass() == null) return true;
        if(ueEntity.getTac() == null) return true;
        if(mccMncEntity.getMcc() == null) return true;
        if(mccMncEntity.getMnc() == null) return true;
        if(cellId == null) return true;
        if(duration == null) return true;
        if(eventCauseEntity.getCauseCode() == null) return true;
        if(neVersion== null) return true;
        if(imsi == null) return true;
        if(hier3Id == null) return true;
        if(hier32Id == null) return true;
        if(hier321Id == null) return true;
        return false;
    }
}

