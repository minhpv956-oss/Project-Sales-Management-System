package entity;

public class RegularCustomer extends Customer {
    private double totalSpent;
    public RegularCustomer(String id, String name, String address, String phone, double totalSpent) {
        super(id, name, address, phone);
        this.totalSpent = totalSpent;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }
    public void updateTotalSpent(double amount) {
        totalSpent += amount;
    }
    public void updateVipLevel(VIPCustomer vipCustomer) {
        if(totalSpent/1000 > 100000){
            vipCustomer.setVipLevel("diamond");
            vipCustomer.setDiscountRate(0.2);
        }
        else if(totalSpent/1000 > 50000){
            vipCustomer.setVipLevel("gold");
            vipCustomer.setDiscountRate(0.15);
        }
        else if(totalSpent/1000  > 10000){
            vipCustomer.setVipLevel("silver");
            vipCustomer.setDiscountRate(0.1);
        }
    }
    @Override
    public void showCustomerInfo(){
        super.showCustomerInfo();
        System.out.println("Total Spent: " + totalSpent);
    }
}
