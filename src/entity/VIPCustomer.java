package entity;

public class VIPCustomer extends Customer {

    private String vipLevel;
    private double discountRate;
    private double loyaltyPoints;

    public VIPCustomer(String id, String name, String address, String phone,
            String vipLevel, double discountRate, double loyaltyPoints) {
        super(id, name, address, phone);
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public String getTier() {
        return vipLevel;
    }

    @Override
    public void addPurchase(double amount) {
        loyaltyPoints += amount / 1000;

        if (loyaltyPoints < 10000) {
            vipLevel = "Normal";
            discountRate = 0.0;
        } else if (loyaltyPoints < 50000) {
            vipLevel = "Silver";
            discountRate = 0.05;
        } else if (loyaltyPoints < 100000) {
            vipLevel = "Gold";
            discountRate = 0.10;
        } else {
            vipLevel = "Diamond";
            discountRate = 0.15;
        }
    }

    @Override
    public String toFileString() {
        return getId() + "," + getName() + "," + getAddress() + "," + getPhone()
                + ",VIP," + loyaltyPoints + "," + vipLevel + "," + discountRate;
    }
}
