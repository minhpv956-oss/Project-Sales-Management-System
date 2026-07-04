package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    public void loadAll() {
        java.io.File file = new java.io.File("product.txt");
        System.out.println("--- DEBUG ---");
        System.out.println("File đang tìm tại: " + file.getAbsolutePath());
        System.out.println("File có tồn tại không: " + file.exists());

        products.clear();
        List<String> lines = FileHelper.readlines("product.txt");
        System.out.println("Số dòng đọc được: " + lines.size());
        // ... code cũ của bạn
    }

    private ArrayList<Product> products = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ProductList() {
        loadAll();
    }

    public void saveAll() {
        List<String> lines = new ArrayList<>();

        for (Product product : products) {
            lines.add(product.toFileString());
        }
        // gọi hàm static của helper
        FileHelper.writeLines("product.txt", lines);
        System.out.println("the data saved to file successfully!!");

    }

    // public void loadAll() {
    // products.clear();
    // List<String> lines = FileHelper.readlines("product.txt");
    // for (String line : lines) {
    // products.add(Product.fromFileString(line));

    // }
    // System.out.println("the data loaded from file successfully!!");
    // }

    public void inputProduct() {
        System.out.println("Enter infomation of product:");
        System.out.print(" Enter product name:");
        String name = sc.nextLine();
        System.out.print("Enter product id:");
        String id = sc.nextLine();
        System.out.print("Enter product price:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter product category:");
        String category = sc.nextLine();

        // tạo object
        Product newProduct = new Product(id, name, price, category);
        // add vào ArrayList

        add(newProduct);
        System.out.println("Product added successfully!!!");

    }

    public void add(Product newProduct) {
        products.add(newProduct);
    }

    public void remove() {
        System.out.print("Please enter name or id to remove:");
        String input = sc.nextLine();

        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getName().equalsIgnoreCase(input)
                    || products.get(i).getId().equalsIgnoreCase(input)) {
                products.remove(i);
            }
        }
        System.out.println(" Product removed successfull!! ");
    }

    public void update() {
        System.out.print("please enter name of Product to update:");
        String searchName = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(searchName)) {

                System.out.println("====Input new value====");
                System.out.print("Input new price:");
                double newPrice = Double.parseDouble(sc.nextLine());
                System.out.print("Input new category:");
                String newCategory = sc.nextLine();
                System.out.print("Input new id:");
                String newId = sc.nextLine();
                System.out.print("Input new name:");
                String newName = sc.nextLine();

                products.get(i).setPrice(newPrice);
                products.get(i).setCategory(newCategory);
                products.get(i).setId(newId);
                products.get(i).setName(newName);
                System.out.println("update data of product is successfull!");

                found = true;
                break;
            }
        }
        if (found == false) {

            System.out.println(searchName + "not found!");
        }
    }

    /*
     * public void display(){
     * system.out.println("products list");
     * for(int i = 0; i <= products.size();i++){
     * system.out.println(products);
     * }
     * 
     * }
     */

    public void display() {
        System.out.println("=====Product list=====");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // 2 cách sort
    // sort đò công nghệ và gia dụng và thực phẩm và khác
    // sort theo mã.
    public void sortProducts() {
        System.out.println("====SORT-PRODUCTS BY NAME====");
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {

                if (products.get(i).getName().compareToIgnoreCase(products.get(j).getName()) > 0) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        System.out.println("thanhcong");
    }

    public void menu() {

        System.out.println("1.add");
        System.out.println("2.remove");
        System.out.println("3.update");
        System.out.println("4.display");
        System.out.println("5.exit");
        System.out.println("Please enter a number!");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                inputProduct();

                break;
            case 2:
                remove();
                break;

            case 3:
                update();
                break;
            case 4:
                display();
                break;
            case 5:
                saveAll();
                System.out.println("Exiting...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid!!");
                break;
        }
    }

}