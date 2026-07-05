package entity;

public class Customer {

    protected String id;
    private String name;
    private String address;
    private String phone;

    public Customer() {
    }

    public Customer(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTier() {
        return "Normal";
    }

    public double getDiscountRate() {
        return 0.0;
    }

    public void addPurchase(double amount) {
    }

    public void showCustomerInfo() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Tier: " + getTier());
        System.out.println("Discount: " + (getDiscountRate() * 100) + "%");
    }

    public String toFileString() {
        return id + "," + getName() + "," + getAddress() + "," + getPhone() + ",Normal,0,None,0.00";
    }

}
