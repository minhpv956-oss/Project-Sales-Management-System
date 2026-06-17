package entity;

import java.util.Scanner;

public class ProductList {

    private int count = 0;
    private Product[] List;

    public ProductList(int size) {
        this.List = new Product[size];
    }
    public Product[] getProductList() {  // Mhung them getter dêt lấy qua bên oderdetail dùng được
    return List;
    }

    private Scanner sc = new Scanner(System.in);

    // java.sql.Date createdAt = new java.sql.Date(System.currentTimeMillis());

    // Structure inputProduct()

    public Product inputProduct() {
        System.out.println("Enter product name: ");
        String name = sc.nextLine();
        System.out.println("Enter product id: ");
        String id = sc.nextLine();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        System.out.println("Enter product stock quantity: ");
        int stockQuantity = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter product category: ");
        String category = sc.nextLine();
        System.out.println("Enter product unit: ");
        String unit = sc.nextLine();
        System.out.println("Enter product image URL: ");
        String imageUrl = sc.nextLine();

        java.sql.Date createdAt = new java.sql.Date(System.currentTimeMillis());

        return new Product(name, id, price, stockQuantity, category, unit, imageUrl, createdAt);
    }

    // Structure addProduct
    public void addProduct(Product pro) {
        if (count >= List.length) {
            System.out.println("List is full! Cannot add more product.");
            return;
        }
        List[count++] = pro;
        System.out.println("Product added successfully!");
    }

    public void updateProduct() {

        System.out.println("--- UPDATE PRODUCT ---");
        System.out.println("Enter product name to update: ");
        String searchName = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (List[i].getName().equalsIgnoreCase(searchName)) {
                System.out.println("Enter new product price: ");
                double newPrice = sc.nextDouble();

                System.out.println("Enter new stock quantity: ");
                int newStockQuantity = sc.nextInt();
                sc.nextLine();

                List[i].setPrice(newPrice);
                List[i].setStockQuantity(newStockQuantity);

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

        for (int i = 0; i < count; i++) {
            if (List[i].getName().toLowerCase().contains(keyword)
                    || List[i].getCategory().toLowerCase().contains(keyword)) {

                System.out.println("Product Name: " + List[i].getName());
                System.out.println("Product ID: " + List[i].getId());
                System.out.println("Product Price: " + List[i].getPrice());
                System.out.println("Product Stock Quantity: " + List[i].getStockQuantity());
                System.out.println("Product Category: " + List[i].getCategory());
                System.out.println("Product Unit: " + List[i].getUnit());
                System.out.println("Product Image URL: " + List[i].getImageUrl());
                System.out.println("Product Created At: " + List[i].getCreatedAt());
                System.out.println("-----------------------------------");

            }
        }

    }

    public void removeProduct() {
        System.out.println("Enter product name to remove: ");
        String name = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (List[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    this.List[j] = this.List[j + 1];
                }
                this.List[count - 1] = null;
                count--;
                System.out.println("Product removed successfully!");
                break;

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
            System.out.println("Product Name: " + List[i].getName());
            System.out.println("Product ID: " + List[i].getId());
            System.out.println("Product Price: " + List[i].getPrice());
            System.out.println("Product Stock Quantity: " + List[i].getStockQuantity());
            System.out.println("Product Category: " + List[i].getCategory());
            System.out.println("Product Unit: " + List[i].getUnit());
            System.out.println("Product Image URL: " + List[i].getImageUrl());
            System.out.println("Product Created At: " + List[i].getCreatedAt());
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
            sc.nextLine();

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