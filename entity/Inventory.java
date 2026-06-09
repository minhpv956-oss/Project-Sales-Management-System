package entity;

import java.sql.Date;

public class Inventory extends Product {

    public Inventory(String name, String id, double price,  int stockQuantity, String category, String unit String imageUrl, Date createdAt) {

        super(name, id, price, stockQuantity,
              category, unit, imageUrl, createdAt);
    }

    public boolean checkStock(int quantity) {
        return quantity > 0 && stockQuantity >= quantity;
    }

    public boolean reduceStock(int quantity) {

        if(quantity <= 0){
            return false;
        }

        if(stockQuantity >= quantity){
            stockQuantity -= quantity;
            return true;
        }

        return false;
    }

    public void addStock(int quantity){

        if(quantity > 0){
            stockQuantity += quantity;
        }
    }

    public void updateStock(int newStock){

        if(newStock >= 0){
            stockQuantity = newStock;
        }
    }

    @Override
public String toString() {
    return String.format("ID: " + id + ", Name: " + name + ", Stock: " + stockQuantity);
}
}