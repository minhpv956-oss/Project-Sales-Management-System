package entity;

import java.util.Scanner;

public class ProductList extends Product {
    public ProductList() {
        super();
    }

    private int count = 0;
    private Product[] productList = new Product[100];

    public ProductList(String name, double id, double price, int stockQuantity, String category, String unit,
            String imageUrl, java.sql.Date createdAt) {
        super(name, id, price, stockQuantity, category, unit, imageUrl, createdAt);
    }

    Scanner sc = new Scanner (System.in);

public Product inputProduct(){
  System.out.println("Enter product name: ");
  String name = sc.nextLine();          
    System.out.println("Enter product id: ");       
    double id = sc.nextDouble();    
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

    Product newProduct = new Product(name, id, price, stockQuantity, category, unit, imageUrl, createdAt);
    return newProduct;



}

    public void addProduct(Product newProduct) {
        // code to add a product to the list

        System.out.println("Please add product");
       
      this.productList[count] = newProduct;
      this.count++;
         System.out.println("Product added successfully!");  
        }


        public void updateProduct() {
            // code to update a product in the list
            System.out.println("Please update product");
            System.out.println("Enter product name to update: ");
             name = sc.nextLine();
            for (int i = 0; i < count; i++) {
                if (productList[i].getName().equalsIgnoreCase(name)) {
                    System.out.println("Enter new product name: ");
                    String name = sc.nextLine();
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
                    Product updatedProduct = new Product(name, id, price, stockQuantity, category, unit, imageUrl,
                            createdAt);
                    productList[i] = updatedProduct;
                    System.out.println("Product updated successfully!");
                    return;
                }
            }
            System.out.println("Product with name " + name + " not found!");
        }       

public void searchByNameorCategory(){
    System.out.println("Enter product name or category to search: ");

    }


