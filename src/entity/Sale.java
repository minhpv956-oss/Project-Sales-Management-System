package entity;

public class Sale {
    private String saleId, customerId, date;
    private double totalAmount;

    public Sale(String saleId, String customerId, String date, double totalAmount) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public String getSaleId() { return saleId; }
    public String getCustomerId() { return customerId; }
    public String getDate() { return date; }
    public double getTotalAmount() { return totalAmount; }

    public String toFileString() {
        return saleId + "," + customerId + "," + date + "," + totalAmount;
    }

    public static Sale fromFileString(String line) {
        String[] p = line.split(",");
        return new Sale(p[0], p[1], p[2], Double.parseDouble(p[3]));
    }
}
