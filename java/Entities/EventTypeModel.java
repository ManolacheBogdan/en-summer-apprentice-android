package Entities;

public class EventTypeModel {
    private int eventTypeId;
    private String eventTypeName;

    public EventTypeModel(int eventTypeId, String eventTypeName) {
        this.eventTypeId = eventTypeId;
        this.eventTypeName = eventTypeName;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    @Override
    public String toString() {
        return "EventTypeModel{" +
                "eventTypeId=" + eventTypeId +
                ", eventTypeName='" + eventTypeName + '\'' +
                '}';
    }
}
