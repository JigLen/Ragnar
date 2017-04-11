package com.vikings.ragnar.entities;

/**
 * Created by carlmccann2 on 16/02/2017.
 */



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="base_data")
public class BaseDataEntity implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="Date_Time") private Timestamp dateTime;
//    @Column(name="Market") private Integer market;
//    @Column(name="Operator") private Integer operator;
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
//        if(getEventId() == null) return true;
        if(failureClassEntity.getFailureClass() == null) return true;
        if(ueEntity.getTac() == null) return true;
        if(mccMncEntity.getMcc() == null) return true;
        if(mccMncEntity.getMnc() == null) return true;
        if(cellId == null) return true;
        if(duration == null) return true;
        if(eventCauseEntity.getCauseCode() == null) return true;
//        if(getCauseCode() == null) return true;
        if(neVersion== null) return true;
        if(imsi == null) return true;
        if(hier3Id == null) return true;
        if(hier32Id == null) return true;
        if(hier321Id == null) return true;
        return false;
    }

    public boolean failureClassIsValid(){
        Integer failureClass = failureClassEntity.getFailureClass();
        if(failureClass >= 0 && failureClass < 5) return true;
        return false;
    }

    public boolean eventIdCauseCodeIsValid(){
        int eventId = eventCauseEntity.getEventId();
        int causeCode = eventCauseEntity.getCauseCode();

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

    public boolean mccMncIsValid(){
        int mcc = mccMncEntity.getMcc();
        int mnc = mccMncEntity.getMnc();
        switch(mcc){
            case 238:
                if(mnc > 0 && mnc < 4) return true;
                break;
            case 240:
                if(mnc == 1 || mnc == 2 || mnc == 3 || mnc == 20 || mnc == 21) return true;
                break;
            case 302:
                if(mnc == 36 || mnc == 37 || mnc == 62 || mnc == 63) return true;
                break;
            case 310:
                if(mnc == 10 || mnc == 12 || mnc == 13 || mnc == 540 || mnc == 550
                        || mnc == 560 || mnc == 570 || mnc == 580 || mnc == 590) return true;
                break;
            case 340:
                if(mnc > 0 && mnc < 4) return true;
                break;
            case 344:
                if(mnc == 30 || mnc == 920 || mnc == 930) return true;
                break;
            case 405:
                if(mnc > 0 && mnc < 6) return true;
                break;
            case 440:
                if(mnc > 8 && mnc < 12) return true;
                break;
            case 505:
                if(mnc == 62 || mnc == 68 || mnc == 71 || mnc == 72
                        || mnc == 88 || mnc == 90) return true;
                break;
        }
        return false;
    }
}

