package entity;

import java.util.Scanner;

public class ProductList extends Product {

    private int count = 0;
    private Product[] productList = new Product[100];
    // Đưa Scanner lên đầu thuộc tính để dùng chung cho toàn bộ class
    private Scanner sc = new Scanner(System.in);

    // Constructors
    public ProductList() {
        super();
    }

    public ProductList(String name, String id, double price, int stockQuantity, String category, String unit,
            String imageUrl, java.sql.Date createdAt) {
        super(name, id, price, stockQuantity, category, unit, imageUrl, createdAt);
    }

    // Hàm nhập thông tin sản phẩm từ bàn phím
    public Product inputProduct() {
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product id: ");
        String id = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        System.out.println("Enter product stock quantity: ");
        int stockQuantity = sc.nextInt();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter product category: ");
        String category = sc.nextLine();
        System.out.println("Enter product unit: ");
        String unit = sc.nextLine();
        System.out.println("Enter product image URL: ");
        String imageUrl = sc.nextLine();
        
        java.sql.Date createdAt = new java.sql.Date(System.currentTimeMillis());

        return new Product(name, id, price, stockQuantity, category, unit, imageUrl, createdAt);
    }

    // Hàm thêm sản phẩm vào mảng
    public void addProduct(Product newProduct) {
        if (count >= productList.length) {
            System.out.println("List is full! Cannot add more product.");
            return;
        }
        this.productList[count] = newProduct;
        this.count++;
        System.out.println("Product added successfully!");
    }

    // Hàm cập nhật sản phẩm (Đã sửa lỗi trùng biến và mất ID)
    public void updateProduct() {
        System.out.println("--- UPDATE PRODUCT ---");
        System.out.println("Enter product name to update: ");
        String searchName = sc.nextLine(); // Đã sửa: đặt tên biến rõ ràng tránh trùng

        for (int i = 0; i < count; i++) {
            if (productList[i].getName().equalsIgnoreCase(searchName)) {
                // Lấy ra ID hiện tại của sản phẩm để giữ nguyên không bị mất
                String currentId = productList[i].getId();

                System.out.println("Enter new product name: ");
                String newName = sc.nextLine();
                System.out.println("Enter new product price: ");
                double price = sc.nextDouble();
                System.out.println("Enter new product stock quantity: ");
                int stockQuantity = sc.nextInt();
                sc.nextLine(); // consume the newline character
                
                System.out.println("Enter new product category: ");
                String category = sc.nextLine();
                System.out.println("Enter new product unit: ");
                String unit = sc.nextLine();
                System.out.println("Enter new product image URL: ");
                String imageUrl = sc.nextLine();
                
                java.sql.Date createdAt = new java.sql.Date(System.currentTimeMillis());

                // Truyền currentId vào đối tượng cập nhật mới
                Product updatedProduct = new Product(newName, currentId, price, stockQuantity, category, unit, imageUrl, createdAt);
                
                productList[i] = updatedProduct; // Thay thế sản phẩm cũ bằng sản phẩm mới
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product with name " + searchName + " not found!");
    }

    // Hàm tìm kiếm theo Tên hoặc Danh mục
    public void searchByNameorCategory() {
        System.out.println("Enter product name or category to search: ");
        String keyword = sc.nextLine().toLowerCase();
        System.out.println("Search results:");
        boolean hasResult = false;

        for (int i = 0; i < count; i++) {
            if (productList[i].getName().toLowerCase().contains(keyword) || productList[i].getCategory().toLowerCase().contains(keyword)) {
                System.out.println("Product Name: " + productList[i].getName());
                System.out.println("Product ID: " + productList[i].getId());
                System.out.println("Product Price: " + productList[i].getPrice());
                System.out.println("Product Stock Quantity: " + productList[i].getStockQuantity());
                System.out.println("Product Category: " + productList[i].getCategory());
                System.out.println("Product Unit: " + productList[i].getUnit());
                System.out.println("Product Image URL: " + productList[i].getImageUrl());
                System.out.println("Product Created At: " + productList[i].getCreatedAt());
                System.out.println("-----------------------------------");
                hasResult = true;
            }
        }
        if (!hasResult) {
            System.out.println("No products match your keyword.");
        }
    }

    // Hàm xóa sản phẩm (Logic dồn dịch mảng rất tốt)
    public void removeProduct() {
        System.out.println("Enter product name to remove: ");
        String name = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (productList[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    productList[j] = productList[j + 1];
                }
                productList[count - 1] = null; // Xóa trắng ô cuối để giải phóng bộ nhớ
                count--;
                System.out.println("Product removed successfully!");
                return;
            }
        }
        System.out.println("Product with name " + name + " not found!");
    }

    // Hàm xuất tất cả sản phẩm
    public void viewAllProducts() {
        if (count == 0) {
            System.out.println("The product list is currently empty.");
            return;
        }
        System.out.println("All products:");
        for (int i = 0; i < count; i++) {
            System.out.println("Product Name: " + productList[i].getName());
            System.out.println("Product ID: " + productList[i].getId());
            System.out.println("Product Price: " + productList[i].getPrice());
            System.out.println("Product Stock Quantity: " + productList[i].getStockQuantity());
            System.out.println("Product Category: " + productList[i].getCategory());
            System.out.println("Product Unit: " + productList[i].getUnit());
            System.out.println("Product Image URL: " + productList[i].getImageUrl());
            System.out.println("Product Created At: " + productList[i].getCreatedAt());
            System.out.println("-----------------------------------");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("=== PRODUCT MANAGEMENT MENU ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Search Product by Name or Category");
            System.out.println("5. View All Products");
            System.out.println("0. Exit");
            System.out.print("Please choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addProduct(inputProduct());
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    searchByNameorCategory();
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 0:
                    System.out.println("Exiting product management menu.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
}