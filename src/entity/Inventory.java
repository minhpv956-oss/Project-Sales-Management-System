package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Product> stockList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private final String FILE_PATH = "product.txt"; // dung chung 1 file voi ProductList

    // ================= LOAD =================
    public void loadData() {

        stockList.clear();

        List<String> lines = FileHelper.readLines(FILE_PATH); 

        for (String line : lines) {

            String[] parts = line.split(",");

            if (parts.length == 5) {

                Product p = new Product(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        parts[3],
                        Integer.parseInt(parts[4])
                );

                stockList.add(p);
            }
        }
    }

    // ================= SAVE =================
    public void saveData() {

        List<String> lines = new ArrayList<>();

        for (Product p : stockList) {

            lines.add(
                    p.getId() + "," +
                    p.getName() + "," +
                    p.getPrice() + "," +
                    p.getCategory() + "," +
                    p.getQuantity()          
            );
        }

        FileHelper.writeLines(FILE_PATH, lines);
    }

    // ================= FIND =================
    public Product findById(String id) {

        for (Product p : stockList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // ================= ADD PRODUCT =================
    public void addProduct(Product p) {

        stockList.add(p);
        saveData();
        System.out.println("Add success");
    }

    // ================= REMOVE =================
    public void removeProduct(String id) {

        Product p = findById(id);

        if (p != null) {
            stockList.remove(p);
            saveData();
            System.out.println("Remove success");
        } else {
            System.out.println("Not found");
        }
    }

    // ================= UPDATE =================
    public void updateProduct(String id, String name, double price, int quantity) {

        Product p = findById(id);

        if (p != null) {

            p.setName(name);
            p.setPrice(price);
            p.setQuantity(quantity);          

            saveData();
            System.out.println("Update success");
        } else {
            System.out.println("Not found");
        }
    }

    // ================= STOCK =================
    public int checkStock(String id) {

        Product p = findById(id);

        if (p != null) return p.getQuantity(); // 

        return -1;
    }

    // ================= ADD STOCK =================
    public void addStock(String id, int qty) {

        Product p = findById(id);

        if (p != null) {

            p.setQuantity(p.getQuantity() + qty); // 
            saveData();

            System.out.println("Stock added");
        } else {
            System.out.println("Not found");
        }
    }

    // ================= REDUCE STOCK =================
    public boolean reduceStock(String id, int qty) {

        Product p = findById(id);

        if (p == null) {
            System.out.println("Not found");
            return false;
        }

        if (p.getQuantity() < qty) {          
            System.out.println("Not enough stock");
            return false;
        }

        p.setQuantity(p.getQuantity() - qty); // 
        saveData();

        return true;
    }

    // ================= DISPLAY ALL =================
    public void displayAll() {

        System.out.println("===== INVENTORY =====");

        for (Product p : stockList) {
            System.out.println(p);
        }
    }

    // ================= DISPLAY CATEGORY =================
    public void displayByCategory(String category) {

        for (Product p : stockList) {

            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
            }
        }
    }

    // ================= MENU =================
    public void inventoryMenu() {

        loadData();

        while (true) {

            System.out.println("\n===== INVENTORY MENU =====");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Update product");
            System.out.println("4. Check stock");
            System.out.println("5. Add stock");
            System.out.println("6. Reduce stock");
            System.out.println("7. Display all");
            System.out.println("8. Display by category");
            System.out.println("0. Back");

            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(sc.nextLine());

                    addProduct(new Product(id, name, price, category, stock));
                    break;

                case 2:
                    System.out.print("ID: ");
                    removeProduct(sc.nextLine());
                    break;

                case 3:
                    System.out.print("ID: ");
                    String uid = sc.nextLine();

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Price: ");
                    double pr = Double.parseDouble(sc.nextLine());

                    System.out.print("Stock: ");
                    int st = Integer.parseInt(sc.nextLine());

                    updateProduct(uid, n, pr, st);
                    break;

                case 4:
                    System.out.print("ID: ");
                    String cid = sc.nextLine();

                    int result = checkStock(cid);

                    if (result == -1)
                        System.out.println("Not found");
                    else
                        System.out.println("Stock: " + result);
                    break;

                case 5:
                    System.out.print("ID: ");
                    String aid = sc.nextLine();

                    System.out.print("Qty: ");
                    int aq = Integer.parseInt(sc.nextLine());

                    addStock(aid, aq);
                    break;

                case 6:
                    System.out.print("ID: ");
                    String rid = sc.nextLine();

                    System.out.print("Qty: ");
                    int rq = Integer.parseInt(sc.nextLine());

                    reduceStock(rid, rq);
                    break;

                case 7:
                    displayAll();
                    break;

                case 8:
                    System.out.print("Category: ");
                    displayByCategory(sc.nextLine());
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}