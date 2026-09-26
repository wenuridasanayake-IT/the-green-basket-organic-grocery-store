package model;

public class Sale {

    private int id;
    private String productName;
    private int quantity;
    private double total;

    public Sale(int id, String productName, int quantity, double total) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
    }

    public int getId() { return id; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }
}
