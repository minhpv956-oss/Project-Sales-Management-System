
package entity;

import java.sql.Date;
import java.util.Scanner;

public class Product {
    // mã sản phẩm
    private String id;
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
    public Date createdAt;
    

    public Product(String id, double price, int stockQuantity, String category,String unit, String imageUrl, Date createdAt) {

        this.id = id;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;

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

    // method

    public void addProduct() {
        // code to add product to database or list
        System.out.println("Product added successfully!");
    }

    public void updateProduct() {
        // code to update product in database or list
        System.out.println("Product updated successfully!");
    }

    public void removeProduct() {
        // code to remove product from database or list
        System.out.println("Product removed successfully!");
    }

 public void viewAll(){


 System.out.println(" viewAll successfully!");    
 }

 public void searchByNameOrCategory(){

    System.out.println(" searchByNameOrCategory successfully!");
 }

 public boolean isInStock(){
    return stockQuantity > 0;
 }

 public double applyDiscount(double rate){
    if (rate > 0 && rate < 1) {
        return price * (1 - rate);
    } else {
        System.out.println("Invalid discount rate. Please enter a value between 0 and 1.");
        return price;
    }
 }

    while(true)

    {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of products to add:");
            int n = Integer.parseInt(sc.nextLine());
            Product P1[] = new Product[n];
  
            for (int i = 0; i < n; i++) {
                    System.out.println("Enter product ID:");
                    String id = sc.nextLine();
                    System.out.println("Enter product price:");
                    double price = sc.nextDouble();
                    System.out.println("Enter stock quantity:");
                    int stockQuantity = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    System.out.println("Enter product category:");
                    String category = sc.nextLine();
    
                    P1[i] = new Product(id, price, stockQuantity, category, id, category, createdAt);
                    P1[i].addProduct();
                }



        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");

        }

    }

}
