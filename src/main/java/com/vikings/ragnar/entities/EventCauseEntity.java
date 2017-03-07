package com.vikings.ragnar.entities;

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
                        "WHERE e.causeCode = :causeCode AND " +
                        "      e.eventId = :id")
})

@Table(name="event_cause")
public class EventCauseEntity implements Serializable{
    @Id @Column(name="Cause_Code")  private Integer causeCode;
    @Id @Column(name="Event_id")    private Integer eventId;
    @Column(name="Description")     private String description;


    public EventCauseEntity() {
    }

    public EventCauseEntity(Integer causeCode, Integer eventId, String description) {
        this.causeCode = causeCode;
        this.eventId = eventId;
        this.description = description;
    }

    public Integer getCauseCode() {
        return causeCode;
    }

    public void setCauseCode(Integer causeCode) {
        this.causeCode = causeCode;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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
