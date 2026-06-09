
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
    protected String unit;
    // đường dẫn ảnh
    protected String imageUrl;
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



   
   

    
}
