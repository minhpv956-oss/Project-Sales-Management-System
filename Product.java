
package entity;


public class Product {
    
    private String id;
    private double price;
    private int stock;
 
    
    
    
    public Product(String id,double price,int stock){
  
        this.id = id;
        this.price = price;
        this.stock = stock;
 
        
        
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock>=0){
         this.stock = stock;
        }
       
    }
    
 
 
    
}


