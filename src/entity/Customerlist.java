package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customerlist extends Customer {

    private ArrayList<Customer> customers;

    private Scanner sc = new Scanner(System.in);

    private static final String FILE_NAME = "customers.txt";

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    private Customer parseCustomerLine(String line) {
        String[] p = line.split(",");
        // p[0]=id, p[1]=name, p[2]=address, p[3]=phone,
        // p[4]=type (VIP/Normal), p[5]=totalSpent, p[6]=tier, p[7]=discount

        String id = p[0];
        String name = p[1];
        String address = p[2];
        String phone = p[3];
        String type = p[4];

        if (type.equalsIgnoreCase("VIP")) {
            String tier = p[6];                          // Diamond/Gold/Silver
            double discountRate = Double.parseDouble(p[7]);
            double loyaltyPoints = Double.parseDouble(p[5]); // dùng tạm totalSpent làm loyaltyPoints ban đầu

            // Lưu ý thứ tự tham số constructor của VIPCustomer:
            // VIPCustomer(id, name, address, phone, vipLevel, discountRate, loyaltyPoints)
            return new VIPCustomer(id, name, address, phone, tier, discountRate, loyaltyPoints);
        } else {
            return new Customer(id, name, address, phone);
        }
    }

    public Customerlist() {
        this.customers = new ArrayList<>();
        loadFromFile(); // tự nạp dữ liệu cũ khi khởi tạo
    }

    public void loadFromFile() {
        List<String> lines = FileHelper.readLines(FILE_NAME);
        customers.clear();
        for (String line : lines) {
            customers.add(parseCustomerLine(line));
        }
    }

    public void saveToFile() {
        List<String> lines = new ArrayList<>();
        for (Customer c : customers) {
            lines.add(c.toFileString());
        }
        FileHelper.writeLines(FILE_NAME, lines);
    }

    public Customer findById(String id) {
        for (Customer c : customers) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public void addCustomer() {
        System.out.println("Enter the number of customers you want to add: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for customer " + (i + 1) + ":");
            System.out.print("Enter customer ID: ");
            String customerid = sc.nextLine();
            System.out.print("Enter customer name: ");
            String customername = sc.nextLine();
            System.out.print("Enter customer address: ");
            String customeraddress = sc.nextLine();
            System.out.print("Enter customer phone: ");
            String customerphone = sc.nextLine();
            Customer newCustomer = new Customer(customerid, customername, customeraddress, customerphone);
            customers.add(newCustomer);
            saveToFile();
            System.out.println("Customer added successfully!");
        }
    }

    public void updateCustomer() {
        System.out.print("Enter customer ID to update: ");
        String newid = sc.nextLine();
        int found = 0;
        for (Customer customer : customers) {
            if (newid.equalsIgnoreCase(customer.getId())) {
                System.out.print("Enter new customer name: ");
                String newname = sc.nextLine();
                System.out.print("Enter new customer address: ");
                String newaddress = sc.nextLine();
                System.out.print("Enter new customer phone: ");
                String newphone = sc.nextLine();
                customer.setName(newname);
                customer.setAddress(newaddress);
                customer.setPhone(newphone);
                found = 1;
                saveToFile();
                break;
            }
        }
        if (found == 1) {

            System.out.println("Customer with ID " + newid + " updated successfully!");
        } else {
            System.out.println("Customer with ID " + newid + " not found!");
        }
    }

    public void removeCustomer() {
        System.out.print("Enter customer ID to remove: ");
        String removeId = sc.nextLine().trim();
        int found = 0;
        for (Customer customer : customers) {
            if (removeId.equalsIgnoreCase(customer.getId())) {
                customers.removeIf(c -> c.getId().equalsIgnoreCase(removeId));
                found = 1;
                saveToFile();
                break;
            }
        }
        if (found == 1) {

            System.out.println("Customer with ID " + removeId + " removed successfully!");
        } else {
            System.out.println("Customer with ID " + removeId + " not found!");
        }
    }

    @Override
    public void showCustomerInfo() {
        System.out.println("=========== Customers Info ==========");
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Phone: " + customer.getPhone());
            System.out.println("Tier: " + customer.getTier());
            System.out.println("");
        }
    }

    public void chooseService() {
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

                int n = Integer.parseInt(sc.nextLine());

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
                        showCustomerInfo();
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

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
