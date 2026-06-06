
package entity;

import java.util.Date;
import java.util.ArrayList;

public class Report extends Customer{
    
    private String reportType;
    private Date reportDate;
    
    public Report(String reportType,Date reportDate, String id, String name, String address, String phone){
  //     super(id, name, address, phone);
        this.reportDate = reportDate;
       this.reportType = reportType;
        
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
    
    
    public void saleReport(ArrayList<SalesTransaction> transactions)
    {
        double totalRevenue = 0;

        for(int i = 0; i < transactions.size(); i++)
        {
            totalRevenue += transactions.get(i).getTotalAmount();
        }

        System.out.println("---------SALES REPORT---------");
        System.out.println("Report Type: " + reportType);
        System.out.println("Report Date: " + reportDate);
        System.out.println("Total Transactions: " + transactions.size());
        System.out.println("Total Revenue: " + totalRevenue);
    }

    
    public void bestSellingProducts(ArrayList<SalesTransaction> transactions)
    {
        String bestProductId = "";
        int maxQuantity = 0;

        for(int i = 0; i < transactions.size(); i++)
        {
            if(transactions.get(i).getQuantity() > maxQuantity)
            {
                maxQuantity = transactions.get(i).getQuantity();
                bestProductId = transactions.get(i).getProductId();
            }
        }

        System.out.println("------------BEST SELLING PRODUCT------------");
        System.out.println("Product ID: " + bestProductId);
        System.out.println("Quantity Sold: " + maxQuantity);
    }

  
    public void topCustomers(ArrayList<SalesTransaction> transactions)
    {
        String bestCustomerId = "";
        double maxAmount = 0;
        int a = 0;

        for(int i = 0; i < transactions.size(); i++)
        {
            if(transactions.get(i).getTotalAmount() > maxAmount)
            {
                maxAmount = transactions.get(i).getTotalAmount();
                bestCustomerId = transactions.get(i).getCustomerId();
                a = i;
            }
        }

        System.out.println("------------TOP CUSTOMER------------");
        System.out.println("Customer ID: " + bestCustomerId);
        System.out.println("Purchase Value: " + maxAmount);
    }
}
