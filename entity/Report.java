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

        System.out.println("===== SALES REPORT =====");
        System.out.println("Report Type: " + reportType);
        System.out.println("Report Date: " + reportDate);
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Total Products Sold: " + totalProductsSold);
        System.out.println("Total Revenue: " + totalRevenue);
    }

    // lấy 3 sản phẩm chạy nhất nha - sắp xếp từ cao đếm thấp
    public void bestSellingProducts(ArrayList<SalesTransaction> transactions) {

        String[] productId = new String[transactions.size()];
        int[] totalSold = new int[transactions.size()];

        int count = 0;

        for (int i = 0; i < transactions.size(); i++) {

            String id = transactions.get(i).getProductId();
            boolean found = false;

            for (int j = 0; j < count; j++) {

                if (productId[j].equals(id)) {

                    totalSold[j] += transactions.get(i).getQuantity();
                    found = true;
                    break;
                }
            }

            if (!found) {

                productId[count] = id;
                totalSold[count] = transactions.get(i).getQuantity();
                count++;
            }
        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (totalSold[j] > totalSold[i]) {

                    int tempSold = totalSold[i];
                    totalSold[i] = totalSold[j];
                    totalSold[j] = tempSold;

                    String tempId = productId[i];
                    productId[i] = productId[j];
                    productId[j] = tempId;
                }
            }
        }

        System.out.println("===== TOP 3 BEST-SELLING PRODUCTS =====");

        int top = count;

        if (top > 3) {
            top = 3;
        }

        for (int i = 0; i < top; i++) {

            System.out.println(
                    (i + 1)
                    + ". Product ID: "
                    + productId[i]
                    + " | Total Sold: "
                    + totalSold[i]);
        }
    }

    // lấy 3 thằng mua nhiều nhất từ trên xuống dưới
    public void highestPurchaseCustomer(ArrayList<SalesTransaction> transactions) {

        String[] customerId = new String[transactions.size()];
        double[] totalPurchase = new double[transactions.size()];

        int count = 0;

        for (int i = 0; i < transactions.size(); i++) {

            String id = transactions.get(i).getCustomerId();
            boolean found = false;

            for (int j = 0; j < count; j++) {

                if (customerId[j].equals(id)) {

                    totalPurchase[j] += transactions.get(i).getTotalAmount();
                    found = true;
                    break;
                }
            }

            if (!found) {

                customerId[count] = id;
                totalPurchase[count] = transactions.get(i).getTotalAmount();
                count++;
            }
        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (totalPurchase[j] > totalPurchase[i]) {

                    double tempPurchase = totalPurchase[i];
                    totalPurchase[i] = totalPurchase[j];
                    totalPurchase[j] = tempPurchase;

                    String tempId = customerId[i];
                    customerId[i] = customerId[j];
                    customerId[j] = tempId;
                }
            }
        }

        System.out.println("===== TOP 3 CUSTOMERS WITH HIGHEST PURCHASE VALUE =====");

        int top = count;

        if (top > 3) {
            top = 3;
        }

        for (int i = 0; i < top; i++) {

            System.out.println(
                    (i + 1)
                    + ". Customer ID: "
                    + customerId[i]
                    + " | Total Purchase Value: "
                    + totalPurchase[i]);
        }
    }
}
