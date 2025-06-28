import java.util.*;

class Product {
    String name;
    double quantity;
    double pricePerUnit;

    Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}

class Customer {
    String name;
    List<Product> purchasedProducts = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addProduct(Product p) {
        purchasedProducts.add(p);
    }

    List<Product> getProducts() {
        return purchasedProducts;
    }
}

class BillGenerator {
    double generateBill(Customer customer) {
        double total = 0;
        for (Product p : customer.getProducts()) {
            total += p.getTotalPrice();
        }
        return total;
    }
}

public class GroceryStoreBillingSystem {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice");
        alice.addProduct(new Product("Apples", 2, 3)); 
        alice.addProduct(new Product("Milk", 1, 2));  

        BillGenerator bg = new BillGenerator();
        double total = bg.generateBill(alice);

        System.out.println("Customer: " + alice.name);
        for (Product p : alice.getProducts()) {
            System.out.println(p.name + ": " + p.quantity + " units @ $" + p.pricePerUnit + " = $" + p.getTotalPrice());
        }
        System.out.println("Total Bill: $" + total);
    }
}
