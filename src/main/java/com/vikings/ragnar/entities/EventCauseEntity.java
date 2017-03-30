package com.vikings.ragnar.entities;

import com.vikings.ragnar.embeddable.EventCauseId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 28/02/2017.
 */
@Entity


@NamedQueries({
        @NamedQuery(name="searchEventCauseByCompKey",
                query="SELECT e " +
                        "FROM EventCauseEntity e " +
                        "WHERE e.cpk.causeCode = :causeCode AND " +
                        "      e.cpk.eventId = :id")
})


@Table(name="event_cause")
public class EventCauseEntity implements Serializable{
    //@Id @Column(name="Cause_Code")  private Integer causeCode;
    //@Id @Column(name="Event_id")    private Integer eventId;


    @EmbeddedId
    protected EventCauseId cpk;

    @Column(name="Description")     private String description;


    public EventCauseEntity() {
    }

    public EventCauseId getCpk() {
        return cpk;
    }

    public void setCpk(EventCauseId cpk) {
        this.cpk = cpk;
    }

    public EventCauseEntity(Integer causeCode, Integer eventId, String description) {
        //this.causeCode = causeCode;
        //this.eventId = eventId;
        cpk = new EventCauseId(causeCode,eventId);
        this.description = description;
    }

    public Integer getCauseCode() {
        return cpk.getCauseCode();
    }

    public void setCauseCode(Integer causeCode) {
        cpk.setCauseCode(causeCode);
    }

    public Integer getEventId() {
        return cpk.getEventId();
    }

    public void setEventId(Integer eventId) {
        cpk.setEventId(eventId);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}
