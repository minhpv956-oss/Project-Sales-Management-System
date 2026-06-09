package SaleSystem;

import java.util.Scanner;

import entity.Customerlist;
import entity.Product;
import entity.ProductList;
import entity.Customer;
public class SystemInterface {

    public static void main(String[] args) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss
        // dd/MM/yyyy");
        // Customerlist customerlist = new Customerlist();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("========================");
                    System.out.println("SALES MANAGEMENT SYSTEM");
                    // System.out.println("Current Time: " + LocalDateTime.now().format(formatter));
                    System.out.println("========================");
                    System.out.println("1. Manage Products");
                    System.out.println("2. Manage Customers");
                    System.out.println("3. Manage Sales Transactions");
                    System.out.println("4. Reports");
                    System.out.println("5. Exit");
                    System.out.println("----------------------------");

                    System.out.print("Choose an option: ");

                    int n = sc.nextInt();

                    switch (n) {

                        case 1:
                            System.out.println("Manage Products");
                            ProductList productList = new ProductList();
                            productList.menu();
                            break;
                        case 2:
                            System.out.println("Manage Customers");
                                Customerlist customerlist = new Customerlist();
                            customerlist.chooseService();
                             break;
                        case 3:
                            System.out.println("Manage Sales Transactions");
                            break;
                        case 4:
                            System.out.println("Reports");
                            break;
                        case 5:
                            System.out.println("Exit Program");
                            return;
                        default:
                            System.out.println("Invalid option");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a number!");
                    sc.nextLine();
                }
            }
        }
    }
}