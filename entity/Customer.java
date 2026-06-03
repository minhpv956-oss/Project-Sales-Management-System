
package entity;

import java.util.ArrayList;
import java.util.Scanner;
public class Customer {

    private String id;
    private String name;
    private String address;
    private String phone;
    ArrayList<Customer> customers;
    Scanner sc= new Scanner(System.in);
     
    
    
    public Customer(String id,String name,String address,String phone){
    
        this.address = address;
        this.id = id;
        this.name = name;
        this.phone = phone;

    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addCustomer(){
       System.out.println("Enter the number of customers you want to add: ");
       int n= sc.nextInt();
         sc.nextLine();
         for(int i=0;i<n;i++){
            System.out.println("Enter details for customer " + (i + 1) + ":");
          System.out.print("Enter customer ID: ");
          String id = sc.nextLine();
          System.out.print("Enter customer name: ");
          String name = sc.nextLine();
          System.out.print("Enter customer address: ");
          String address = sc.nextLine();
          System.out.print("Enter customer phone: ");
          String phone = sc.nextLine();
          Customer newCustomer = new Customer(id, name, address, phone);
          customers.add(newCustomer);
          System.out.println("Customer added successfully!");
    }
}
    public void updateCustomer(){  
     
          System.out.print("Enter customer ID to update: ");
          String newid = sc.nextLine().trim();
        if(newid.equalsIgnoreCase(id)){
            System.out.print("Enter new customer name: ");
            String newname = sc.nextLine();
            System.out.print("Enter new customer address: ");
            String newaddress = sc.nextLine();
            System.out.print("Enter new customer phone: ");
            String newphone = sc.nextLine();
            setName(newname);
            setAddress(newaddress);
            setPhone(newphone);
            Customer updatedCustomer = new Customer(newid, newname, newaddress, newphone);
            customers.add(updatedCustomer);
            } else {
                System.out.println("Customer with ID " + newid + " not found!");
                return;
        }
          System.out.println("Customer with ID " + id + " updated successfully!");
    
}
    public void removeCustomer(){
        System.out.print("Enter customer ID to remove: ");
        try (Scanner sc = new Scanner(System.in)) {
            String removeId = sc.nextLine().trim();
            if(removeId.equalsIgnoreCase(id)){
                customers.removeIf(customer -> customer.getId().equalsIgnoreCase(removeId));
                System.out.println("Customer with ID " + removeId + " removed successfully!");
            } else {
                System.out.println("Customer with ID " + removeId + " not found!");
            }
        }
    }
    public void viewAllCustomers(){
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("==========Customer List==========");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getId());
                System.out.println("Name: " + customer.getName());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("Phone: " + customer.getPhone());
                System.out.println("------------------------");
            }
        }
    }
    public void chooseService(){
            while (true) {
                try {
                    System.out.println("========================");
                    System.out.println("ChooseService");
                    System.out.println("========================");
                    System.out.println("1. Add new customer");
                    System.out.println("2. Update customer information.");
                    System.out.println("3. Remove a customer.");
                    System.out.println("4. View all customers.");
                    System.out.println("5. Exit");
                    System.out.println("----------------------------");

                    System.out.print("Choose an option: ");

                    int n = sc.nextInt();

                    switch (n) {
                        case 1:
                            System.out.println("Add new customer");
                            addCustomer();
                            break;
                        case 2:
                            System.out.println("Update customer information.");
                            updateCustomer();
                            break;
                        case 3:
                            System.out.println("Remove a customer.");
                            removeCustomer();
                            break;
                        case 4:
                            System.out.println("View all customers.");
                            viewAllCustomers();
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
