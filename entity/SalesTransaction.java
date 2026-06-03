
package entity;


public class SalesTransaction {
 
     private String transactionId;
     private String customerId;
     private String productId;
     private int quantity;
     private double totalAmount;
    
     public SalesTransaction(String transactionId,String customerId,String productId,int quantity, double totalAmount){
      this.customerId = customerId;
      this.productId = productId;
      this.quantity = quantity;
      this.totalAmount = totalAmount;
      this.transactionId = transactionId;
      
              
     }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
     
}
