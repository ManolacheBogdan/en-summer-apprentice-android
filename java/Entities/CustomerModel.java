package Entities;

public class CustomerModel {
    private int customerId;
    private int name;
    private String email;

    public CustomerModel(int customerId, int name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerId=" + customerId +
                ", name=" + name +
                ", email='" + email + '\'' +
                '}';
    }
}
