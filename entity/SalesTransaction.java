package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class SalesTransaction {
private String transactionId;
    private String customerId;  
    private String productId; 
    private int quantity; 
    private Customer customer;
    private Customerlist customerList;
    private ProductList productList;
    private double totalAmount;
    private Date transactionDate;
    private ArrayList<OderDetail> orderDetails;
    private Scanner sc= new Scanner(System.in);
    
    private static ArrayList<SalesTransaction> transactions
        = new ArrayList<>();

    public static ArrayList<SalesTransaction> getTransactions() { /// them cho report
     return transactions;}
    
    public SalesTransaction( Customerlist customerList, ProductList productList) {
        this.customerList = customerList;
        this.productList = productList;
        this.orderDetails = new ArrayList<>();
        this.totalAmount = 0;
        this.transactionDate = new Date();
    }

    public String getTransactionId() {
         return transactionId; }
    public String getCustomerId() {
         return customerId; }
    public String getProductId() { 
        return productId; }
    public int getQuantity() {
         return quantity; }
    public Customer getCustomer() {
         return customer; }
    public double getTotalAmount() {
         return totalAmount; }
    public Date getTransactionDate() {
         return transactionDate; }
    public ArrayList<OderDetail> getOrderDetails() {
         return orderDetails; }

    
    public void checkCustomer() {
        while (true) {
            System.out.print("Enter customer ID: ");
            String id = sc.nextLine();
            for (Customer c : customerList.getCustomerList()) {
                if (c.getId().equalsIgnoreCase(id)) {
                    this.customer = c;
                    this.customerId = c.getId();
                    System.out.println("Customer found: " + c.getName());
                    return;
                }
            }
            System.out.println("Customer with ID " + id + " not found! Please enter again.");
        }
    }

    public void addOrderDetail() {
        OderDetail orderDetail = new OderDetail(productList);
        orderDetail.newOder();
        orderDetails.add(orderDetail);
        totalAmount += orderDetail.getTotalPrice();
        if (orderDetail.getProduct() != null) {
            this.productId = orderDetail.getProduct().getId();
            this.quantity = orderDetail.getQuantity();
        }
    }

    public void calculateTotal() {
        if (customer instanceof VIPCustomer) {
            VIPCustomer vip = (VIPCustomer) customer;
            totalAmount = totalAmount * (1 - vip.getDiscountRate());
        }
        else totalAmount= totalAmount*1;
    }

    public void showTransaction() {
        System.out.print("Transaction ID: ");
        this.transactionId = sc.nextLine();
        checkCustomer();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Date: " + formatter.format(transactionDate));

        while (true) {
            addOrderDetail();
            System.out.print("Add another product? (y/n): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")) break;
        }

        calculateTotal();

        System.out.println("----------- BILL SUMMARY -----------");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Product", "Qty", "Price", "Total");
        for (OderDetail od : orderDetails) {
            System.out.printf("%-20s %-10d %-10f %-10f%n",od.getProduct().getName(),od.getQuantity(),od.getPrice(),od.getTotalPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Total Amount: " + totalAmount + " VND");
    }
}