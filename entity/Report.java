package entity;

import java.util.ArrayList;
import java.util.Date;

public class Report {

    private String reportType;
    private Date reportDate;

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

    // Generate Daily / Monthly Sales Report
    public void salesReport(ArrayList<SalesTransaction> transactions) {

        double totalRevenue = 0;
        int totalOrders = transactions.size();

        for (SalesTransaction st : transactions) {
            totalRevenue += st.getTotalAmount();
        }

        System.out.println("\n===== SALES REPORT =====");
        System.out.println("Report Type : " + reportType);
        System.out.println("Report Date : " + reportDate);
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Revenue     : " + totalRevenue + " VND");
    }

    // Best-selling Products
    public void bestSellingProducts(ArrayList<SalesTransaction> transactions) {

        String[] productNames = new String[100];
        int[] quantities = new int[100];

        int count = 0;

        for (SalesTransaction st : transactions) {

            for (OderDetail od : st.getOrderDetails()) {

                String productName = od.getProduct().getName();
                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (productNames[i].equalsIgnoreCase(productName)) {

                        quantities[i] += od.getQuantity();
                        found = true;
                        break;
                    }
                }

                if (!found) {

                    productNames[count] = productName;
                    quantities[count] = od.getQuantity();
                    count++;
                }
            }
        }

        System.out.println("\n===== BEST SELLING PRODUCTS =====");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + productNames[i]
                    + " | "
                    + quantities[i]
                    + " units sold");
        }
    }

    // Customers with highest purchase value
    public void highestPurchaseCustomer(ArrayList<SalesTransaction> transactions) {

        String[] customerNames = new String[100];
        double[] purchases = new double[100];

        int count = 0;

        for (SalesTransaction st : transactions) {

            String customerName = st.getCustomer().getName();
            boolean found = false;

            for (int i = 0; i < count; i++) {

                if (customerNames[i].equalsIgnoreCase(customerName)) {

                    purchases[i] += st.getTotalAmount();
                    found = true;
                    break;
                }
            }

            if (!found) {

                customerNames[count] = customerName;
                purchases[count] = st.getTotalAmount();
                count++;
            }
        }

        System.out.println("\n===== TOP CUSTOMERS =====");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + customerNames[i]
                    + " | "
                    + purchases[i]
                    + " VND");
        }
    }
}