package Entities;

import java.time.LocalDateTime;

public class OrderModel {
    private int orderId;
    private CustomerModel customer;
    private TicketCategoryModel ticketCategory;
    private LocalDateTime orderedAt;
    private int numberOfTickets;
    private double totalPrice;

    public OrderModel(int orderId, CustomerModel customer, TicketCategoryModel ticketCategory,
                      LocalDateTime orderedAt, int numberOfTickets, double totalPrice) {
        this.orderId = orderId;
        this.customer = customer;
        this.ticketCategory = ticketCategory;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public TicketCategoryModel getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategoryModel ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", ticketCategory=" + ticketCategory +
                ", orderedAt=" + orderedAt +
                ", numberOfTickets=" + numberOfTickets +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
