package Entities;


import java.util.List;

public class EventModel {
    private int eventId;
    private EventTypeModel eventTypeModel;
    private LocationModel location;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private List<TicketCategoryModel> ticketCategories;
    private String eventImageUrl;

    public EventModel(int eventId, EventTypeModel eventTypeModel, LocationModel location,
                      String name, String description, String startDate,
                      String endDate, List<TicketCategoryModel> ticketCategories,
                      String eventImageUrl) {
        this.eventId = eventId;
        this.eventTypeModel = eventTypeModel;
        this.location = location;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategories = ticketCategories;
        this.eventImageUrl = eventImageUrl;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public EventTypeModel getEventType() {
        return eventTypeModel;
    }

    public void setEventType(EventTypeModel eventTypeModel) {
        this.eventTypeModel = eventTypeModel;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<TicketCategoryModel> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategoryModel> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId=" + eventId +
                ", eventTypeModel=" + eventTypeModel +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", ticketCategories=" + ticketCategories +
                ", eventImageUrl='" + eventImageUrl + '\'' +
                '}';
    }
}