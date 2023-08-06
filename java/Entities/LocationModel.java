package Entities;


import java.util.List;

public class LocationModel {
    private int locationId;
    private String locationName;
    private String locationType;
    private int capacity;
    private List<EventModel> events;

    public LocationModel(int locationId, String locationName, String locationType,
                         int capacity, List<EventModel> events) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationType = locationType;
        this.capacity = capacity;
        this.events = events;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", locationType='" + locationType + '\'' +
                ", capacity=" + capacity +
                ", events=" + events +
                '}';
    }
}
