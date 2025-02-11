import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        }
    }

    public void display() {
        System.out.println(name + " - $" + price + " (Stock: " + quantity + ")");
    }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public void display() {
        System.out.println(product.getName() + " x " + quantity + " = $" + getTotalPrice());
    }
}

class ShoppingCart {
    private List<CartItem> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            cartItems.add(new CartItem(product, quantity));
            product.reduceQuantity(quantity);
            System.out.println(quantity + " " + product.getName() + " added to cart.");
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            System.out.println("Your Cart:");
            for (CartItem item : cartItems) {
                item.display();
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty! Nothing to checkout.");
        } else {
            displayCart();
            System.out.println("Total Amount: $" + calculateTotal());
            cartItems.clear();
            System.out.println("Checkout successful! Thank you for shopping.");
        }
    }
}

class Store {
    private List<Product> products;
    private ShoppingCart cart;

    public Store() {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product("Laptop", 1000, 5));
        products.add(new Product("Phone", 500, 10));
        products.add(new Product("Headphones", 100, 15));
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).display();
        }
    }

    public void shop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. View Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayProducts();
                    System.out.print("Enter product number to add to cart: ");
                    int productIndex = scanner.nextInt() - 1;
                    if (productIndex >= 0 && productIndex < products.size()) {
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        cart.addItem(products.get(productIndex), qty);
                    } else {
                        System.out.println("Invalid product selection.");
                    }
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                case 5:
                    System.out.println("Exiting store. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.shop();
    }
}
