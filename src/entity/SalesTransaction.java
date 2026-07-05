package entity;

import java.time.LocalDate;
import java.util.*;

public class SalesTransaction {
    private Customerlist customerlist;
    private Inventory inventory;
    private Scanner sc = new Scanner(System.in);

    private static ArrayList<Sale> transactions = new ArrayList<>();
    private static ArrayList<SaleItem> saleItemDetails = new ArrayList<>();

    private static final String SALES_FILE = "sales.txt";
    private static final String ITEMS_FILE = "sale_items.txt";
    
    
    public SalesTransaction(Customerlist customerlist, Inventory inventory) {
        this.customerlist = customerlist;
        this.inventory = inventory;
        inventory.loadData(); 
        loadData();
    }

    private void loadData() {
        transactions.clear();
        saleItemDetails.clear();
        for (String line : FileHelper.readLines(SALES_FILE)) transactions.add(Sale.fromFileString(line));
        for (String line : FileHelper.readLines(ITEMS_FILE)) saleItemDetails.add(SaleItem.fromFileString(line));
    }

    public static ArrayList<Sale> getTransactions() {
         return transactions; }
    public static ArrayList<SaleItem> getSaleItems() {
         return saleItemDetails; }

    private String generateSaleId() {
        return String.format("HD%03d", transactions.size() + 1);
    }

    public void createSale() {
    System.out.print("Input Customer Id: ");
    String customerId = sc.nextLine().trim();
    Customer customer = customerlist.findById(customerId);
    if (customer == null) {
        System.out.println("Can not find Customer by Id" + customerId);
        return;
    }

    List<SaleItem> itemsInThisSale = new ArrayList<>();
    double subtotalSum = 0;

    while (true) {
        System.out.print("Input Products Id to buy (input 'finish' if done): ");
        String productId = sc.nextLine().trim();
        if (productId.equalsIgnoreCase("finish")) break;

        Product product = inventory.findById(productId);
        if (product == null) {
            System.out.println("Can't find Products by Id " + productId);
            continue;
        }

        System.out.print(" Enter purchase quantity: ");
        int quantity = Integer.parseInt(sc.nextLine().trim());

        double unitPrice = product.getPrice();
        boolean success = inventory.reduceStock(productId, quantity);
        if (!success) continue;

        double itemSubtotal = unitPrice * quantity;
        itemsInThisSale.add(new SaleItem("", productId, product.getName(), quantity, unitPrice, itemSubtotal));
        subtotalSum += itemSubtotal;
    }

    if (itemsInThisSale.isEmpty()) {
        System.out.println("Empty transaction; invoice creation cancelled.");
        return;
    }

    double discountRate = customer.getDiscountRate();
    double totalAmount = subtotalSum * (1 - discountRate);

    String saleId = generateSaleId();
    String date = LocalDate.now().toString();

    Sale newSale = new Sale(saleId, customerId, date, totalAmount);
    transactions.add(newSale);

    List<SaleItem> finalItems = new ArrayList<>();
    for (SaleItem item : itemsInThisSale) {
        SaleItem finalItem = new SaleItem(saleId, item.getProductId(), item.getProductName(),
                item.getQuantity(), item.getUnitPrice(), item.getSubtotal());
        saleItemDetails.add(finalItem);
        finalItems.add(finalItem);
    }

    saveTransactions();
    saveSaleItems();

    customer.addPurchase(subtotalSum);
    customerlist.saveToFile();

    printBill(newSale, customer, finalItems, subtotalSum, discountRate, totalAmount);
}

//PRINT BILL
private void printBill(Sale sale, Customer customer, List<SaleItem> items,
                        double subtotalSum, double discountRate, double totalAmount) {
    System.out.println("==========================================");
    System.out.println("               BILL            ");
    System.out.println("==========================================");
    System.out.println("Sale ID : " + sale.getSaleId());
    System.out.println("Date    : " + sale.getDate());
    System.out.println("Customer : " + customer.getName() + " (ID: " + customer.getId() + ")");
    System.out.println("Vip level     : " + customer.getTier());
    System.out.println("------------------------------------------");
    System.out.printf("%-8s %-25s %-5s %-12s %-12s%n", "ProductId", "Product name", "Quantity", "Unit price", "Total Amount");
    System.out.println("------------------------------------------");

    for (SaleItem item : items) {
        System.out.printf("%-8s  %-27s   %-15d %.0f  %-10.0f%n",
                item.getProductId(), item.getProductName(),
                item.getQuantity(), item.getUnitPrice(), item.getSubtotal());
    }

    System.out.println("------------------------------------------");
    System.out.printf("Total Sum      : %,.0f đ%n", subtotalSum);
    System.out.printf("Discount (%s)      : %.0f%%%n", customer.getTier(), discountRate * 100);
    System.out.printf("Total Amount          : %,.0f đ%n", totalAmount);
    System.out.println("==========================================");
}



    private void saveTransactions() {
        List<String> lines = new ArrayList<>();
        for (Sale s : transactions) lines.add(s.toFileString());
        FileHelper.writeLines(SALES_FILE, lines);
    }

    private void saveSaleItems() {
        List<String> lines = new ArrayList<>();
        for (SaleItem it : saleItemDetails) lines.add(it.toFileString());
        FileHelper.writeLines(ITEMS_FILE, lines);
    }
}