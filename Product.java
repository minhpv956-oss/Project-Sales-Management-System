
package entity;


public class Product {
    
    private String id;
    private double price;
    private int stockQuantity;
    private  String category;
    
    
    
    
    public Product(String id,double price,int stockQuantity,String category){
  
        this.id = id;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        
        
}
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
        this.price = price;}
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity>=0){
         this.stockQuantity = stockQuantity;
        }
       
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
 
 
    
}


