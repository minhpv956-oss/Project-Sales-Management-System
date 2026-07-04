package entity;

public class VIPCustomer extends Customer {
    private String vipLevel;
    private double discountRate;
    private double loyaltyPoints;

    public VIPCustomer(String id, String name, String address, String phone, String vipLevel, double discountRate, double loyaltyPoints) {
        super(id, name, address, phone);
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
        this.loyaltyPoints = loyaltyPoints;
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

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

   public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
// lever vip theo số điểm tích lũy, mỗi 1000 đồng chi tiêu sẽ được 1 điểm tích lũy
    public void updateVipLevel(double amount) {
        loyaltyPoints += totalBill( amount) /1000;
        if(loyaltyPoints > 100000){
            vipLevel = "diamond";
            discountRate = 0.2;
        }
        else if(loyaltyPoints > 50000){
            vipLevel = "gold";
            discountRate = 0.15;
        }
        else if(loyaltyPoints > 10000){
            vipLevel = "silver";
            discountRate = 0.1;
        }
    }
    //tính giảm giá
    public double calculateDiscount(double amount) {
        return amount * discountRate;
    }
    //tiền sau giảm giá
    public double totalBill( double amount) {
        amount -= calculateDiscount(amount);
       return amount;
    }
    //thông tin khách hàng VIP
    @Override
    public void showCustomerInfo() {
        super.showCustomerInfo();
        System.out.println("VIP Level: " + vipLevel);
        System.out.println("Discount Rate: " + (discountRate * 100) + "%");
    }
    @Override
public String toFileString() {
    // Định dạng mong đợi: id, name, address, phone, type, loyaltyPoints, tier, discount
    return getId() + "," + getName() + "," + getAddress() + "," + getPhone() 
         + ",VIP," + getLoyaltyPoints() + "," + getVipLevel() + "," + getDiscountRate();
}
    
    
}
