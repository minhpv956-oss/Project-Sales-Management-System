package SaleSystem;

import entity.Customerlist;
import entity.ProductList;
import entity.Report;
import entity.SalesTransaction;
import java.util.Scanner;
import java.util.Date;

public class SystemInterface {

    public static void main(String[] args) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss
        // dd/MM/yyyy");
        // Customerlist customerlist = new Customerlist();
        Customerlist customerlist = new Customerlist();
        ProductList productList = new ProductList();

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