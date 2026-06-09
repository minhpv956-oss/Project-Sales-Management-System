package entity;
import java.util.Scanner;

public class OderDetail {
    private Product product;
    private ProductList productList;
    private int quantity;
    private double price;
    private Scanner sc = new Scanner(System.in);

   public OderDetail(ProductList productList) {
    this.productList = productList; 
   }
    public OderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
       
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void newOder() {
        System.out.println("Enter product name: ");
        String productName = sc.nextLine().trim();
        int flag=0;
        for (Product p : productList.getProductList()) {
            if (p != null && productName.equalsIgnoreCase(p.getName())) {
                flag=1;
                System.out.println("Enter quantity to buy: ");
                this.quantity = Integer.parseInt(sc.nextLine());
                this.product = p;
                this.price = p.getPrice();
                if(quantity <= p.getStockQuantity()){
                    p.setStockQuantity(p.getStockQuantity() - quantity);
                    System.out.println("Purchase successful! Remaining stock for " + product.getName() + ": " + product.getStockQuantity());
                    System.out.println("Product added to transaction.");
                } else {
                    System.out.println("Not enough stock for product: " + product.getName());
                }
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Product not found with name: " + productName);
        }
    }
    public double getTotalPrice() {
        return price * quantity;
    }
}

