package Entities;

public class TicketCategoryModel {
    private int ticketCategoryId;
    private EventModel event;
    private String ticketDescription;
    private double price;

    public TicketCategoryModel(int ticketCategoryId, EventModel event, String ticketDescription, double price) {
        this.ticketCategoryId = ticketCategoryId;
        this.event = event;
        this.ticketDescription = ticketDescription;
        this.price = price;
    }

    public int getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(int ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketCategoryModel{" +
                "ticketCategoryId=" + ticketCategoryId +
                ", event=" + event +
                ", ticketDescription='" + ticketDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
