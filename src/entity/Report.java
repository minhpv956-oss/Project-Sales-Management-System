package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Report {

    private Customerlist customerList;
    private Inventory inventory;
    private Scanner sc = new Scanner(System.in);

    public Report(Customerlist customerList, Inventory inventory) {

        this.customerList = customerList;
        this.inventory = inventory;

        customerList.loadFromFile();
        inventory.loadData();

        new SalesTransaction(customerList, inventory);
    }



    public void totalBillLastMonth() {

        ArrayList<Sale> sales = SalesTransaction.getTransactions();

        LocalDate today = LocalDate.now();

        double total = 0;

        for (Sale sale : sales) {

            LocalDate saleDate = LocalDate.parse(sale.getDate());

            long days = ChronoUnit.DAYS.between(saleDate, today);

            if (days >= 0 && days <= 30) {

                total += sale.getTotalAmount();

            }

        }

        System.out.println("----------------------------------------");
        System.out.printf("Revenue of last 30 days : %.2f VND\n", total);
        System.out.println("----------------------------------------");
    }

    

    public void searchBillByCustomer() {

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine().trim();

        ArrayList<Sale> sales = SalesTransaction.getTransactions();
        ArrayList<SaleItem> items = SalesTransaction.getSaleItems();

        boolean found = false;

        for (Sale sale : sales) {

            if (sale.getCustomerId().equalsIgnoreCase(customerId)) {

                found = true;

                System.out.println("\n======================================");
                System.out.println("Sale ID : " + sale.getSaleId());
                System.out.println("Date    : " + sale.getDate());
                System.out.printf("Total   : %,.0f VND\n", sale.getTotalAmount());

                System.out.println("--------------------------------------");
                System.out.printf("%-10s %-25s %-8s %-12s\n",
                        "ID", "Product", "Qty", "Subtotal");

                for (SaleItem item : items) {

                    if (item.getSaleId().equalsIgnoreCase(sale.getSaleId())) {

                        System.out.printf("%-10s %-25s %-8d %.2f\n",
                                item.getProductId(),
                                item.getProductName(),
                                item.getQuantity(),
                                item.getSubtotal());

                    }

                }

                System.out.println("======================================");

            }

        }

        if (!found) {

            System.out.println("No bill found!");

        }

    }

       

    public void rankingCustomer() {

        ArrayList<Customer> customers = customerList.getCustomers();
        ArrayList<Sale> sales = SalesTransaction.getTransactions();

        ArrayList<Customer> rankList = new ArrayList<>();
        ArrayList<Double> totalList = new ArrayList<>();

        
        for (Customer customer : customers) {

            double total = 0;

            for (Sale sale : sales) {

                if (sale.getCustomerId().equalsIgnoreCase(customer.getId())) {

                    total += sale.getTotalAmount();

                }

            }

            rankList.add(customer);
            totalList.add(total);

        }

        for (int i = 0; i < totalList.size() - 1; i++) {

            for (int j = i + 1; j < totalList.size(); j++) {

                if (totalList.get(j) > totalList.get(i)) {

                    double tempMoney = totalList.get(i);
                    totalList.set(i, totalList.get(j));
                    totalList.set(j, tempMoney);

                    Customer tempCustomer = rankList.get(i);
                    rankList.set(i, rankList.get(j));
                    rankList.set(j, tempCustomer);

                }

            }

        }

        System.out.println("==========================================================================================");
        System.out.printf("%-10s %-20s %-25s %-18s %-12s\n",
                "ID", "Name", "Address", "Total Purchase", "VIP");

        System.out.println("==========================================================================================");

        for (int i = 0; i < rankList.size(); i++) {

            Customer c = rankList.get(i);

            System.out.printf("%-10s %-20s %-25s %.2f %-12s\n",
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    totalList.get(i),
                    c.getTier());

        }

        System.out.println("==========================================================================================");

    }



    public void top5Product() {

        ArrayList<SaleItem> items = SalesTransaction.getSaleItems();

        ArrayList<String> productIds = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> quantitySold = new ArrayList<>();

        
        for (SaleItem item : items) {

            int index = -1;

            for (int i = 0; i < productIds.size(); i++) {

                if (productIds.get(i).equalsIgnoreCase(item.getProductId())) {

                    index = i;
                    break;

                }

            }

            if (index == -1) {

                productIds.add(item.getProductId());
                productNames.add(item.getProductName());
                quantitySold.add(item.getQuantity());

            } else {

                quantitySold.set(index,
                        quantitySold.get(index) + item.getQuantity());

            }

        }

      
        for (int i = 0; i < quantitySold.size() - 1; i++) {

            for (int j = i + 1; j < quantitySold.size(); j++) {

                if (quantitySold.get(j) > quantitySold.get(i)) {

                    int tempQty = quantitySold.get(i);
                    quantitySold.set(i, quantitySold.get(j));
                    quantitySold.set(j, tempQty);

                    String tempId = productIds.get(i);
                    productIds.set(i, productIds.get(j));
                    productIds.set(j, tempId);

                    String tempName = productNames.get(i);
                    productNames.set(i, productNames.get(j));
                    productNames.set(j, tempName);

                }

            }

        }

        System.out.println("==============================================================");
        System.out.printf("%-10s %-30s %-15s\n",
                "Product ID", "Product Name", "Quantity Sold");
        System.out.println("==============================================================");

        int limit = Math.min(5, productIds.size());

        for (int i = 0; i < limit; i++) {

            System.out.printf("%-10s %-30s %-15d\n",
                    productIds.get(i),
                    productNames.get(i),
                    quantitySold.get(i));

        }

        System.out.println("==============================================================");

    }


    public void menuReport() {

        int choice;

        do {

            System.out.println("\n============= REPORT =============");
            System.out.println("1. Revenue of last month");
            System.out.println("2. Bills by Customer ID");
            System.out.println("3. Customer Ranking");
            System.out.println("4. Top 5 Best Selling Products");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {

                choice = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {

                System.out.println("Invalid input!");
                choice = -1;

            }

            switch (choice) {

                case 1:
                    totalBillLastMonth();
                    break;

                case 2:
                    searchBillByCustomer();
                    break;

                case 3:
                    rankingCustomer();
                    break;

                case 4:
                    top5Product();
                    break;

                case 0:
                    System.out.println("Exit Report...");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }

        } while (choice != 0);

    }

}

