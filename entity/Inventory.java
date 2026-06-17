package entity;

import java.sql.Date;
import java.util.Scanner;
public class Inventory extends Product {
    
    private Scanner sc = new Scanner(System.in);

    public Inventory(String name, String id, double price, int stockQuantity, String category, String unit,
            String imageUrl, Date createdAt) {

        super(name, id, price, stockQuantity,
              category, unit, imageUrl, createdAt);
            }


    public boolean checkStock(int quantity) {
        return quantity > 0 && stockQuantity >= quantity;
    }

    public boolean reduceStock(int quantity) {

        if (quantity <= 0) {
            return false;
        }

        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            return true;
        }

        return false;
    }

    public void addStock(int quantity) {

        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }

    public void updateStock(int newStock) {

        if (newStock >= 0) {
            stockQuantity = newStock;
        }
    }
    public void inventoryMenu(){
        while (true) {

            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("Managing Product: " + name);
            System.out.println("Current Stock: " + stockQuantity);

            System.out.println("1. Check Stock");
            System.out.println("2. Reduce Stock");
            System.out.println("3. Add Stock");
            System.out.println("4. Update Stock");
            System.out.println("0. Back");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Enter quantity: ");
                    int qtyCheck =
                            Integer.parseInt(sc.nextLine());

                    if (checkStock(qtyCheck)) {
                        System.out.println("Enough stock.");
                    } else {
                        System.out.println("Not enough stock.");
                    }

                    break;

                case 2:

                    System.out.print("Quantity to sell: ");
                    int qtySell =
                            Integer.parseInt(sc.nextLine());

                    if (reduceStock(qtySell)) {
                        System.out.println("Sale successful.");
                    } else {
                        System.out.println("Sale failed.");
                    }

                    break;

                case 3:

                    System.out.print("Quantity to add: ");
                    int qtyAdd =
                            Integer.parseInt(sc.nextLine());

                    addStock(qtyAdd);

                    System.out.println("Stock added.");
                    break;

                case 4:

                    System.out.print("New stock quantity: ");

                    int newStock =
                            Integer.parseInt(sc.nextLine());

                    updateStock(newStock);

                    System.out.println("Stock updated.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    

    }

    @Override
    public String toString() {
        return String.format("ID: " + id + ", Name: " + name + ", Stock: " + stockQuantity);
    }
}