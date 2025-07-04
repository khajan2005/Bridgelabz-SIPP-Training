import java.util.*;
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private static final double TAX_RATE = 0.15;

    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics tax rate: " + (TAX_RATE * 100) + "%";
    }
}

class Clothing extends Product implements Taxable {
    private static final double TAX_RATE = 0.05;

    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: " + (TAX_RATE * 100) + "%";
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommerceDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics("E001", "Smartphone", 699.99));
        products.add(new Clothing("C001", "Jeans", 49.99));
        products.add(new Groceries("G001", "Milk", 2.99));

        for (Product product : products) {
            double price = product.getPrice();
            double discount = product.calculateDiscount();
            double tax = 0.0;
            String taxDetails = "No tax applicable";

            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                taxDetails = taxableProduct.getTaxDetails();
            }

            double finalPrice = price + tax - discount;

            System.out.println("Product: " + product.getName());
            System.out.println("Price: $" + String.format("%.2f", price));
            System.out.println(taxDetails);
            System.out.println("Discount: $" + String.format("%.2f", discount));
            System.out.println("Final Price: $" + String.format("%.2f", finalPrice));
            System.out.println("-----------------------------");
        }
    }
}
