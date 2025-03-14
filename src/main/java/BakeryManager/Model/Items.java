package BakeryManager.Model;

public class Items {
    private String name;
    private int quantity; 
    private double price;

    public Items(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity; 
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    } 

    public double getPrice() {
        return price;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean removeQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }
}
