package entity;

import java.sql.Date;

public class Product {

    private String name;
    private String id;
    private double price;
    // lượng tồn kho
    private int stockQuantity;
    // loại
    private String category;
    // đơn vị
    private String unit;
    private String imageUrl;
    private Date createdAt;

    public Product() {
    }

    public Product(String name, String id, double price, int stockQuantity,
            String category, String unit, String imageUrl, Date createdAt) {
        this.name = name;
        this.id = id;
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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("invalid");
        }
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            this.stockQuantity = 0;
        } else {
            this.stockQuantity = stockQuantity;
        }
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
