
package entity;

import java.util.Scanner;
public class Customer {
   // hêloe
   // hưng đập trai
   ///hello chó Minh
   
    private String id;
    private String name;
    private String address;
    private String phone;
    
    
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
    
    public void chooseService(){
    try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("========================");
                    System.out.println("chooseService");
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
                            break;
                        case 2:
                            System.out.println("Update customer information.");
                            break;
                        case 3:
                            System.out.println("Remove a customer.");
                            break;
                        case 4:
                            System.out.println("View all customers.");
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
    }}
}
