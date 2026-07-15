package entity;

public class Product {
    private String id;
    private String name;
    private double price;
    private String category;
    private int quantity;

    // Constructor rỗng
    public Product() {
    }

    // Constructor đầy đủ
    public Product(String id, String name, double price, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter và Setter
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        return "Product{" + "id: " + id + ", name: " + name + ", price: " + price +
                ", category: " + category + ", quantity: " + quantity + '}';
    }

    // Phương thức chuyển đối tượng thành chuỗi CSV (5 cột)
    public String toFileString() {
        return id + " , " + name + " , " + price + " , " + category + " , " + quantity;
    }

    // Phương thức tĩnh chuyển chuỗi từ file thành đối tượng Product
    public static Product fromFileString(String line) {
        String[] parts = line.split(",");
        // Đảm bảo dữ liệu phân tách bằng dấu phẩy
        String id = parts[0];
        String name = parts[1];
        double price = Double.parseDouble(parts[2]);
        String category = parts[3];
        int quantity = Integer.parseInt(parts[4]);

        return new Product(id, name, price, category, quantity);
    }
}