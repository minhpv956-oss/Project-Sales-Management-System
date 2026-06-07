package entity;


public class VIPCustomer extends Customer {
    private String vipLevel;
    private double discountRate;

    public VIPCustomer(String id, String name, String address, String phone, String vipLevel, double discountRate) {
        super(id, name, address, phone);
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }   
    public void upVipLevel(double totalAmount){
        if(totalBill(totalAmount) > 100000000){
            vipLevel = "diamond";
            discountRate = 0.2;
        }
        else if(totalBill(totalAmount) > 50000000){
            vipLevel = "gold";
            discountRate = 0.15;
        }
        else if(totalBill(totalAmount) > 10000000){
            vipLevel = "silver";
            discountRate = 0.1;
        }
    }
    public double calculateDiscount(double totalAmount) {
        return totalAmount * discountRate;
    }
    public double totalBill(double totalAmount) {
        return totalAmount - calculateDiscount(totalAmount);
    }

    
    
}
