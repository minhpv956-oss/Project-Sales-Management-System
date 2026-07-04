package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {

    // products : parameter
    // ArrayList<Product>: khai báo kiểu dữ liệu cho trình biên dịch biết products
    // là danh sách chứa các đối tượng thuộc Product
    // new ArrayList<>(): cấp bộ nhơ streen heap
    // <> diamond operator tức khồn cần viết lại dữ liệuk khai báo từ java7 trở đii

    private ArrayList<Product> products = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

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
        String searchName = sc.nextLine();
        String searchId = sc.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(searchName) || products.get(i).equals(searchId)) {
                products.remove(i);
            }
        }
        System.out.println(" Product removed successfull!! ");
    }

    public void update() {
        System.out.print("please enter name of Product to update:");
        String searchName = sc.nextLine();
        if (searchName.equalsIgnoreCase(searchName)) {

            System.out.println("====Input new value====");
            System.out.print("Input new price:");
            double newPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Input new category:");
            String newCategory = sc.nextLine();
            System.out.print("Input new id:");
            String newId = sc.nextLine();
            System.out.print("Input new name:");
            String newName = sc.nextLine();

            System.out.println("update data of product is successfull!");
        }
    }

    public void display() {
        System.out.println("=====Product list=====");
        for (Product product : products) {
            System.out.println(products);
        }
    }

    // 2 cách sort

    public void sortProducts() {
        System.out.println("====SORT-PRODUCTS BY PRICES====");
        for (int i = 0; i < products.size() - 1; i++) {
            for (int j = i + 1; j < products.size(); j++) {

                if (products.get(i).getPrice() > products.get(j).getPrice()) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
        System.out.println("thanhcong");
    }

}