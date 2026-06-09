
package entity;


public class Inventory {
    
    private String productId;
    private int currentStock;
    public Inventory(String productId, int currentStock){
    this.currentStock = currentStock;
    this.productId = productId;
   
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
    
    
}
