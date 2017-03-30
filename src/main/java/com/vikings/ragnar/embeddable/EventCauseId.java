package com.vikings.ragnar.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by C07589301 on 20/03/2017.
 */
@Embeddable
public class EventCauseId implements Serializable
{

    @Column(name="Cause_Code")
    private Integer causeCode;

    @Column(name="Event_id")
    private Integer eventId;

    public EventCauseId(){
    }

    public EventCauseId(Integer causeCode, Integer eventId){
        this.causeCode = causeCode;
        this.eventId = eventId;
    }

    public Integer getCauseCode() {
        return causeCode;
    }

    public Integer getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventCauseId)) return false;
        EventCauseId that = (EventCauseId) o;
        return Objects.equals(getCauseCode(), that.getCauseCode()) &&
                Objects.equals(getEventId(), that.getEventId());
    }


    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(getCauseCode(), getEventId());
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public void setCauseCode(Integer causeCode) {

        this.causeCode = causeCode;
    }
}
