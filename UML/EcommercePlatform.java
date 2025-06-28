import java.util.*;

class Product {
    String productName;

    Product(String name) {
        this.productName = name;
    }
}

class Order {
    int orderId;
    List<Product> products = new ArrayList<>();

    Order(int id) {
        this.orderId = id;
    }

    void addProduct(Product p) {
        products.add(p);
    }

    void showOrderDetails() {
        System.out.println("Order #" + orderId);
        for (Product p : products) {
            System.out.println("- " + p.productName);
        }
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        orders.add(o);
    }

    void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Customer john = new Customer("John");

        Product laptop = new Product("Laptop");
        Product phone = new Product("Smartphone");

        Order order1 = new Order(1001);
        order1.addProduct(laptop);
        order1.addProduct(phone);

        john.placeOrder(order1);
        john.showOrders();
    }
}
