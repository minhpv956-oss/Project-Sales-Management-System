package entity;

public class SaleItem {

    private String saleId, productId, productName;
    private int quantity;
    private double unitPrice, subtotal;

    public SaleItem(String saleId, String productId, String productName,
            int quantity, double unitPrice, double subtotal) {
        this.saleId = saleId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public String getSaleId() {
        return saleId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String toFileString() {
        return saleId + "," + productId + "," + productName + "," + quantity + "," + unitPrice + "," + subtotal;
    }

    public static SaleItem fromFileString(String line) {
        String[] p = line.split(",");
        return new SaleItem(p[0], p[1], p[2], Integer.parseInt(p[3]), Double.parseDouble(p[4]), Double.parseDouble(p[5]));
    }
}
