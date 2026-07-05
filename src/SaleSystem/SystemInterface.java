package SaleSystem;

import entity.Customerlist;
import entity.Inventory;
import entity.ProductList;
import entity.Report;
import entity.SalesTransaction;
import java.util.Scanner;

public class SystemInterface {

    public static void main(String[] args) {
        Customerlist customerlist = new Customerlist();
        ProductList productList = new ProductList();
        Inventory inventory = new Inventory();
        SalesTransaction salesTransaction = new SalesTransaction(customerlist, inventory);

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("========================");
                    System.out.println("SALES MANAGEMENT SYSTEM");
                    System.out.println("========================");
                    System.out.println("1. Manage Products");
                    System.out.println("2. Manage Customers");
                    System.out.println("3. Manage Sales Transactions");
                    System.out.println("4. Reports");
                    System.out.println("5. Inventory");
                    System.out.println("6. Exit");
                    System.out.println("----------------------------");

                    System.out.print("Choose an option: ");

                    int n = Integer.parseInt(sc.nextLine());

                    switch (n) {

                        case 1:
                            System.out.println("Manage Products");

                            productList.menu();
                            break;
                        case 2:
                            System.out.println("Manage Customers");

                            customerlist.chooseService();
                            break;
                        case 3:
                            System.out.println("Manage Sales Transactions");
                            salesTransaction.createSale();
                            break;
                        case 4:
                            System.out.println("Reports");

                            Report report = new Report(customerlist, inventory);
                            report.menuReport();
                            break;
                        case 5:
                            System.out.println("Inventory");
                            inventory.inventoryMenu();
                            break;
                        // System.out.print("Enter Product ID: ");
                        // String id = sc.nextLine();

                        // Inventory inventory = productList.findInventoryById(id);
                        // if (inventory == null) {
                        // System.out.println( "Product not found!");

                        // } else {
                        // inventory.inventoryMenu();

                        // }

                        case 6:
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