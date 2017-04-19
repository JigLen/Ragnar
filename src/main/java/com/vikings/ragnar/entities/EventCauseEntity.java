package com.vikings.ragnar.entities;

import com.vikings.ragnar.entities.embeddable.EventCauseId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 28/02/2017.
 */

@NamedQueries({
        @NamedQuery(name="searchEventCauseByCompKey", query="SELECT e FROM EventCauseEntity e WHERE e.cpk.causeCode = :causeCode AND e.cpk.eventId = :id")
})

@Entity
@Table(name="event_cause")
public class EventCauseEntity implements Serializable{
    @EmbeddedId                     protected EventCauseId cpk;
    @Column(name="Description")     private String description;


    public EventCauseEntity() {
    }

    public EventCauseEntity(EventCauseId cpk) {
        this.cpk = cpk;
    }
    public EventCauseEntity(EventCauseId cpk, String description) {
        this.cpk = cpk;
        this.description = description;
    }

    public EventCauseId getCpk() {
        return cpk;
    }

    public void setCpk(EventCauseId cpk) {
        this.cpk = cpk;
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
}
