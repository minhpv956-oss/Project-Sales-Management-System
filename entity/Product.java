
package entity;

import java.sql.Date;

public class Product {
    protected String name;
    
    protected double id;
    
    protected double price;
    // số lượng tồn kho
    protected int stockQuantity;
    // danh mục sản phẩm

    protected String category;



    // đơn vị tính
    public String unit;
    // đường dẫn ảnh
    public String imageUrl;
    // ngày tạo sản phẩm
    protected Date createdAt;
 

    public Product() {
    }   

    public Product(String name, double id, double price, int stockQuantity, String category, String unit, String imageUrl, Date createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;

    
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }       

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;

        System.out.println("Product updated successfully!");
    }

    public void removeProduct(double id) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }

        }
        System.out.println("Product removed successfully!");
    }

    public void viewAll() {
        for (Product p : products) {
            System.out.println("Product ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Stock Quantity: " + p.getStockQuantity());
            System.out.println("Category: " + p.getCategory());
            System.out.println("-----------------------------");
        }
        System.out.println(" viewAll successfully!");
    }

    public void searchByNameOrCategory(String keyword) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())
                    || p.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Product found: " + p.getId());
            }
        }
        System.out.println(" searchByNameOrCategory successfully!");
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public double applyDiscount(double rate) {

        return price * (1 - rate);

    }

    
}
