
package com.mycompany.session09taska;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item.getAvailableCopies() > 0) {
            items.add(item);
            System.out.println(item.getName() + " added to cart.");
        } else {
            System.out.println("Cannot add " + item.getName() + " — Out of Stock!");
        }
    }

    public void removeItem(Item item) {
        if (items.remove(item)) {
            System.out.println(item.getName() + " removed from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
            return;
        }

        System.out.println("\n--- Processing Checkout ---");
        for (Item item : items) {
            item.sell();
            System.out.println("Purchased: " + item.getName() + " [" + item.getCategory() + "] - $" + item.getPrice());
        }
        System.out.printf("Total Amount Paid: $%.2f\n", calculateTotal());
        items.clear();
        System.out.println("Checkout completed successfully. Cart cleared.");
    }

    public List<Item> getItems() {
        return items;
    }
}