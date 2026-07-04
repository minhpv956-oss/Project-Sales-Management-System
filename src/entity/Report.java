
package entity;

import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;

public class Report {

    private String reportType;
    private Date reportDate;
    private Scanner sc = new Scanner(System.in);

    public Report(String reportType, Date reportDate) {
        this.reportType = reportType;
        this.reportDate = reportDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    // tổng bill tháng gần nhất
    public void totalBillLastMonth() {

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();

        Date now = new Date();

        long oneMonth = 30L * 24 * 60 * 60 * 1000;

        double total = 0;

        for (SalesTransaction st : list) {

            if (now.getTime() - st.getTransactionDate().getTime() <= oneMonth) {

                total += st.getTotalAmount();

            }

        }

        System.out.printf("Revenue in last month: %.2f\n", total);
    }

    // search id
    public void searchBillByCustomer() {

        System.out.print("Enter customer ID: ");
        String id = sc.nextLine();

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();
        boolean found = false;
        for (SalesTransaction st : list) {

            if (st.getCustomerId().equalsIgnoreCase(id)) {
                System.out.println("----------------------------");
                System.out.println("Transaction ID: " + st.getTransactionId());
                System.out.println("Date: " + st.getTransactionDate());
                System.out.println("Total: " + st.getTotalAmount());
                found = true;
                for (OderDetail od : st.getOrderDetails()) {

                    System.out.println(od.getProduct().getName() + "  Qty: " + od.getQuantity());

                }

            }

        }
        if (!found) {
            System.out.println("Not found!");
        }

    }

    // rank mua
    public void rankingCustomer() {

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();
        ArrayList<Customer> customers = new ArrayList<>();

        // Lấy danh sách khách hàng không trùng
        for (SalesTransaction st : list) {

            Customer c = st.getCustomer();

            if (!customers.contains(c)) {
                customers.add(c);
            }
        }

        // Sort
        for (int i = 0; i < customers.size() - 1; i++) {

            for (int j = i + 1; j < customers.size(); j++) {

                if (totalCustomer(customers.get(j)) > totalCustomer(customers.get(i))) {

                    Customer temp = customers.get(i);
                    customers.set(i, customers.get(j));
                    customers.set(j, temp);

                }

            }

        }

        
        System.out.printf("%-10s %-20s %-25s %-15s %-15s\n",
                "ID", "Name", "Address", "Total", "VIP Level");

      //print
        for (Customer c : customers) {

            String vipLevel = "Normal";

            if (c instanceof VIPCustomer) {
                VIPCustomer vip = (VIPCustomer) c;
                vipLevel = vip.getVipLevel();
            }

            System.out.printf("%-10s %-20s %-25s %-15.2f %-15s\n",
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    totalCustomer(c),
                    vipLevel);
        }

    }

    public double totalCustomer(Customer c) {

        double total = 0;

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();

        for (SalesTransaction st : list) {

            if (st.getCustomer().getId().equalsIgnoreCase(c.getId())) {

                total += st.getTotalAmount();

            }

        }

        return total;
    }

    // top 5 san pham
    public int totalSold(Product p) {
        //tinh doanh thu
        int total = 0;

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();

        for (SalesTransaction st : list) {

            for (OderDetail od : st.getOrderDetails()) {

                if (od.getProduct().getId().equalsIgnoreCase(p.getId())) {
                    total += od.getQuantity();
                }

            }

        }

        return total;
    }

    public void top5Product() {

        ArrayList<SalesTransaction> list = SalesTransaction.getTransactions();

        ArrayList<Product> products = new ArrayList<>();

        // Lấy danh sách sản phẩm không trùng
        for (SalesTransaction st : list) {

            for (OderDetail od : st.getOrderDetails()) {

                Product p = od.getProduct();

                if (!products.contains(p)) {
                    products.add(p);
                }

            }

        }

        // Sort
        for (int i = 0; i < products.size() - 1; i++) {

            for (int j = i + 1; j < products.size(); j++) {

                if (totalSold(products.get(j)) > totalSold(products.get(i))) {

                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);

                }

            }

        }

        // print 
        System.out.printf("%-10s %-25s %-15s\n",
                "Product ID", "Product Name", "Quantity Sold");

        int limit = Math.min(5, products.size());

        for (int i = 0; i < limit; i++) {

            Product p = products.get(i);

            System.out.printf("%-10s %-25s %-15d\n",
                    p.getId(),
                    p.getName(),
                    totalSold(p));
        }
    }

    // menu
    public void menuReport() {

        int choice;

        do {

            System.out.println("===== REPORT =====");
            System.out.println("1. Revenue of last month");
            System.out.println("2. Bills by Customer");
            System.out.println("3. Customer Ranking");
            System.out.println("4. Top 5 Products");
            System.out.println("0. Exit");

            choice = Integer.parseInt(sc.nextLine());

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

                default:
                    break;
            }

        } while (choice != 0);

    }
}
