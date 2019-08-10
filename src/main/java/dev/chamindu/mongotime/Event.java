package dev.chamindu.mongotime;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime eventTime;

    public LocalDateTime getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}