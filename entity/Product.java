
package entity;

import java.sql.Date;
import java.util.ArrayList;

public class Product {
    private String name;
    // mã sản phẩm
    private double id;
    // giá sản phẩm
    private double price;
    // số lượng tồn kho
    private int stockQuantity;
    // danh mục sản phẩm
    private String category;

    // đơn vị tính
    public String unit;
    // đường dẫn ảnh
    public String imageUrl;
    // ngày tạo sản phẩm
    public String createdAt;

    private static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, double id, double price, int stockQuantity, String category, String unit,
            String imageUrl, String createdAt) {
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
        if (price > 0) {
            this.price = price;
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // method

    public void addProduct() {
        products.add(this);
        System.out.println("Product added successfully!");
    }

    public void updateProduct(String name,
            double price,
            int stockQuantity,
            String category) {

        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;

        System.out.println("Product updated successfully!");
    }

    public void removeProduct(String id) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equalsIgnoreCase(id)) {
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
