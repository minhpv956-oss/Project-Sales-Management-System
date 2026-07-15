package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {

    private ArrayList<Product> products = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ProductList() {
        loadAll();
    }

    public void loadAll() {
        products.clear();
        List<String> lines = FileHelper.readLines("product.txt");

        System.out.println("the number of product dowload by file: " + lines.size());

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                products.add(Product.fromFileString(line));
            }
        }
        System.out.println("the data loaded from file successfully!!");
    }

    public void saveAll() {
        List<String> lines = new ArrayList<>();
        for (Product product : products) {
            lines.add(product.toFileString());
        }
        FileHelper.writeLines("product.txt", lines);
        System.out.println("the data saved to file successfully!!");
    }

    public void inputProduct() {
        System.out.println("Enter information of product:");
        System.out.print("Enter product id: ");
        String id = sc.nextLine();
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter product category: ");
        String category = sc.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Product newProduct = new Product(id, name, price, category, quantity);
        add(newProduct);
        System.out.println("Product added successfully!!!");
    }

    public void add(Product newProduct) {
        products.add(newProduct);
    }

    public void remove() {
        System.out.print("Please enter name or id to remove: ");
        String input = sc.nextLine();

        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getName().equalsIgnoreCase(input)
                    || products.get(i).getId().equalsIgnoreCase(input)) {
                products.remove(i);
                System.out.println("Product removed successfully!!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void update() {
        System.out.print("Please enter ID of Product to update: ");
        String input = sc.nextLine();
        boolean found = false;

        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(input)) {
                System.out.println("====Input new value====");
                System.out.print("New name: ");
                p.setName(sc.nextLine());
                System.out.print("New price: ");
                p.setPrice(Double.parseDouble(sc.nextLine()));
                System.out.print("New category: ");
                p.setCategory(sc.nextLine());
                System.out.print("New quantity: ");
                p.setQuantity(Integer.parseInt(sc.nextLine()));

                System.out.println("Update product successfully!");
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println(input + " not found!");
    }

    public void display() {
        System.out.println("=====Product list=====");
        if (products.isEmpty()) {
            System.out.println("null");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void menu() {
        System.out.println("\n1. Add \n2. Remove \n3. Update \n4. Display \n5. Exit");
        System.out.print("Please enter a number: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                inputProduct();
                saveAll();
                break;
            case 2:
                remove();
                saveAll();
                break;
            case 3:
                update();
                saveAll();
                break;
            case 4:
                display();
                saveAll();
                break;
            case 5:
                saveAll();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}