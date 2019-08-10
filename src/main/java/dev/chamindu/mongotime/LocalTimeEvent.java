package dev.chamindu.mongotime;

public class LocalTimeEvent {
    private MongoLocalDateTime eventTime;

    public MongoLocalDateTime getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(MongoLocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}
