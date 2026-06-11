package SaleSystem;

import entity.Customerlist;
import entity.ProductList;
import entity.Report;
import entity.SalesTransaction;
import entity.Inventory;
import java.util.Scanner;
import java.util.Date;

public class SystemInterface {

    public static void main(String[] args) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss
        // dd/MM/yyyy");
        // Customerlist customerlist = new Customerlist();
        Customerlist customerlist = new Customerlist();
        ProductList productList = new ProductList();
       Inventory inventory = new Inventory("Sample Product", "P001", 10.0, 100, "Category A", "pcs", "image.jpg", new java.sql.Date(System.currentTimeMillis()));

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
                            SalesTransaction salesTransaction = new SalesTransaction(customerlist, productList);
                            salesTransaction.showTransaction();
                            break;
                        case 4:
                            System.out.println("Reports");
                            Report report = new Report("Monthly Report", new Date());
                            report.salesReport(SalesTransaction.getTransactions());
                            report.bestSellingProducts(SalesTransaction.getTransactions());
                            report.highestPurchaseCustomer(SalesTransaction.getTransactions());
                            break;
                        case 5:

    while (true) {

        System.out.println("\n===== INVENTORY MENU =====");
        System.out.println(inventory);

        System.out.println("1. Check Stock");
        System.out.println("2. Reduce Stock");
        System.out.println("3. Add Stock");
        System.out.println("4. Update Stock");
        System.out.println("5. Back");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:

                System.out.print("Enter quantity: ");
                int qtyCheck = Integer.parseInt(sc.nextLine());

                if (inventory.checkStock(qtyCheck)) {
                    System.out.println("Enough stock.");
                } else {
                    System.out.println("Not enough stock.");
                }

                break;

            case 2:

                System.out.print("Quantity to sell: ");
                int qtySell = Integer.parseInt(sc.nextLine());

                if (inventory.reduceStock(qtySell)) {
                    System.out.println("Sale successful.");
                } else {
                    System.out.println("Sale failed.");
                }

                break;

            case 3:

                System.out.print("Quantity to add: ");
                int qtyAdd = Integer.parseInt(sc.nextLine());

                inventory.addStock(qtyAdd);

                System.out.println("Stock added.");

                break;

            case 4:

                System.out.print("New stock quantity: ");
                int newStock = Integer.parseInt(sc.nextLine());

                inventory.updateStock(newStock);

                System.out.println("Stock updated.");

                break;

            case 5:
                break;

            default:
                System.out.println("Invalid option.");
        }

        if(choice == 5){
            break;
        }
    }

    break;    
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