package SaleSystem;

import java.util.Scanner;

import entity.Customerlist;
import entity.Product;
public class SystemInterface {

    public static void main(String[] args) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        // Customerlist customerlist = new Customerlist();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("========================");
                    System.out.println("SALES MANAGEMENT SYSTEM");
                    // System.out.println("Current Time: " + LocalDateTime.now().format(formatter));
                    System.out.println("========================");
                    System.out.println("1. Manage Products");
                    System.out.println("2. Manage Customers");
                    System.out.println("3. Manage Sales Transactions");
                    System.out.println("4. Reports");
                    System.out.println("5. Exit");
                    System.out.println("----------------------------");

                    System.out.print("Choose an option: ");

                    int n = sc.nextInt();

                    switch (n) {
                       
 case 1:

    while(true){

        System.out.println("===== PRODUCT MENU =====");
        System.out.println("1. Add Product");
        System.out.println("2. View All");
        System.out.println("3. Search");
        System.out.println("4. Delete");
        System.out.println("5. Back");

        int choice = Integer.parseInt(sc.nextLine());
        Product manager = new Product(
    "",
    0,
    0,
    0,
    "",
    "",
    "",
    null
);

        switch(choice){

            case 1:

               
                Product p = new Product("bread", 10.0, 10.0, 10, "Bakery", "Fresh bread","empty", java.sql.Date.valueOf("2024-05-09"));

                p.addProduct();

                break;

            case 2:
                
                

                manager.viewAll();    

                break;
case 3:
                System.out.print("Enter keyword to search: ");
                String keyword = sc.nextLine();
                manager.searchByNameOrCategory(keyword);
                break;
            case 4: 
                System.out.print("Enter product ID to delete: ");
                double id = Double.parseDouble(sc.nextLine());
                manager.removeProduct(id);
                break;
                
            case 5:
                break;
        }

        if(choice == 5){
            break;
        }
    }

    break;
                           
                        case 2:
                            System.out.println("Manage Customers");
                                Customerlist customerlist = new Customerlist();
                            customerlist.chooseService();
                             break;
                        case 3:
                            System.out.println("Manage Sales Transactions");
                            break;
                        case 4:
                            System.out.println("Reports");
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
}