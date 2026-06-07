package entity;

import java.util.ArrayList;
import java.util.Date;

public class Report extends Customer {

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

   
    public void saleReport(ArrayList<SalesTransaction> transactions) {

        double totalRevenue = 0;
        int totalProductsSold = 0;

        for (int i = 0; i < transactions.size(); i++) {
            totalRevenue += transactions.get(i).getTotalAmount();
            totalProductsSold += transactions.get(i).getQuantity();
        }

        System.out.println("\n========== SALES REPORT ==========");
        System.out.println("Report Type       : " + reportType);
        System.out.println("Report Date       : " + reportDate);
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Products Sold     : " + totalProductsSold);
        System.out.println("Total Revenue     : " + totalRevenue);
        System.out.println("==================================\n");
    }

    
    public void bestSellingProducts(ArrayList<SalesTransaction> transactions) {

    String[] productNames = new String[transactions.size()];
    int[] quantities = new int[transactions.size()];

    int count = 0;

    for (int i = 0; i < transactions.size(); i++) {

        String name = transactions.get(i).getProductId();
        boolean found = false;

        for (int j = 0; j < count; j++) {

            if (productNames[j].equals(name)) {

                quantities[j] += transactions.get(i).getQuantity();
                found = true;
                break;
            }
        }

        if (!found) {

            productNames[count] = name;
            quantities[count] = transactions.get(i).getQuantity();
            count++;
        }
    }

    for (int i = 0; i < count - 1; i++) {

        for (int j = i + 1; j < count; j++) {

            if (quantities[j] > quantities[i]) {

                int tempQuantity = quantities[i];
                quantities[i] = quantities[j];
                quantities[j] = tempQuantity;

                String tempName = productNames[i];
                productNames[i] = productNames[j];
                productNames[j] = tempName;
            }
        }
    }

    System.out.println("===== BEST SELLING PRODUCTS =====");

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

public void highestPurchaseCustomer(ArrayList<SalesTransaction> transactions) {

    String[] customerNames = new String[transactions.size()];
    double[] purchases = new double[transactions.size()];

    int count = 0;

    for (int i = 0; i < transactions.size(); i++) {

        String name = transactions.get(i).getCustomerId();
        boolean found = false;

        for (int j = 0; j < count; j++) {

            if (customerNames[j].equals(name)) {

                purchases[j] += transactions.get(i).getTotalAmount();
                found = true;
                break;
            }
        }

        if (!found) {

            customerNames[count] = name;
            purchases[count] = transactions.get(i).getTotalAmount();
            count++;
        }
    }

    for (int i = 0; i < count - 1; i++) {

        for (int j = i + 1; j < count; j++) {

            if (purchases[j] > purchases[i]) {

                double tempPurchase = purchases[i];
                purchases[i] = purchases[j];
                purchases[j] = tempPurchase;

                String tempName = customerNames[i];
                customerNames[i] = customerNames[j];
                customerNames[j] = tempName;
            }
        }
    }

    System.out.println("===== Best Customer =====");

    for (int i = 0; i < count; i++) {

        System.out.println(
                (i + 1)
                + ". "
                + customerNames[i]
                + " | "
                + purchases[i] + "VND");
    }
}
}