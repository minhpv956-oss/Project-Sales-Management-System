package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class SalesTransaction {

    private String transactionId;
    private Customer customer;
    private Customerlist customerList;
    private double totalAmount;
    private Date transactionDate;
    private ArrayList<OderDetail> orderDetails;
    private Scanner sc = new Scanner(System.in);
    private Product product;
    private OderDetail oderDetail;
    public SalesTransaction(){

    }

    public SalesTransaction(String transactionId, Customer customer, double totalAmount) {
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
        this.totalAmount = totalAmount;
        this.transactionId = transactionId;
        this.transactionDate = new Date();
        this.customerList = new Customerlist();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public ArrayList<OderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void  checkCustomer() {
        System.out.println("Enter customer ID: ");
        String customerId = sc.nextLine();
        int found=0;
        for (Customer c : customerList.getCustomerList()) {
            if (c.getId().equalsIgnoreCase(customerId)) {
                this.customer = c;
                System.out.println("thaays r ne");
                found=1;
                break;
               
            }}
            if (found==0) {
                System.out.println("Customer with ID " + customerId + " not found! Please enter again.");
                
            }

    }

    public void addOrderDetail() {
        OderDetail orderDetail = new OderDetail();
        orderDetail.newOder();
        orderDetails.add(orderDetail);
        totalAmount += orderDetail.getTotalPrice();
    }

    public void caculatoTotal(Customer customer, ArrayList<OderDetail> orderDetails) {
        //instaceof để kiểm tra xem khách hàng có phải là VIP hay không, nếu có thì áp dụng giảm giá
        if (customer instanceof VIPCustomer) {
            VIPCustomer vipCustomer = (VIPCustomer) customer;
            double discount = vipCustomer.getDiscountRate();
            totalAmount = totalAmount * (1 - discount);
        } else {
            totalAmount = totalAmount;
        }
    }

    public void showTransaction(){
        System.out.println("Transaction ID:");
        this.transactionId = sc.nextLine();
        checkCustomer();
        caculatoTotal(this.customer, this.orderDetails);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Date: " + formatter.format(transactionDate));
        addOrderDetail();
        System.err.println("----------- BILL SUMMARY -----------");
        System.out.println("Product Qty Price Total");
        for (OderDetail od : orderDetails) { 
        System.out.println(
            od.getProduct().getName() + "    " + od.getQuantity() + "  " + od.getPrice() + "    " +  od.getTotalPrice());
    }
        System.out.println("Total Amount: "+totalAmount+" VND");

    }
     }       
