package com.mycompany.session09taska;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();
        inventory.add(new Shirt("Oxford Dress Shirt", 39.99, 5, "L", "Blue", "100% Cotton"));
        inventory.add(new Socks("Athletic Crew Socks", 14.99, 8, "M", "White", 3));
        inventory.add(new Hat("Snapback Cap", 24.50, 3, "One Size", "Black", "Urban"));
        inventory.add(new Printer("LaserJet Pro", 189.99, 2, "HP", 12, false));
        inventory.add(new Laptop("ZenBook 14", 999.99, 4, "ASUS", 24, 16));
        inventory.add(new Projector("4K Cinema Projector", 450.00, 1, "Epson", 12, 3200));

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n================ E-COMMERCE SYSTEM ================");
            System.out.println("1. View Store Inventory");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Return Item");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- STORE INVENTORY ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i));
                    }
                    break;

                case 2:
                    System.out.println("\n--- ADD TO CART ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i).getName() + " - $" + inventory.get(i).getPrice());
                    }
                    System.out.print("Enter item number: ");
                    int addIdx = scanner.nextInt() - 1;
                    if (addIdx >= 0 && addIdx < inventory.size()) {
                        cart.addItem(inventory.get(addIdx));
                    } else {
                        System.out.println("Invalid item index.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- SHOPPING CART ---");
                    if (cart.getItems().isEmpty()) {
                        System.out.println("Cart is currently empty.");
                    } else {
                        for (Item item : cart.getItems()) {
                            System.out.println("- " + item);
                        }
                        System.out.printf("Total: $%.2f\n", cart.calculateTotal());
                    }
                    break;

                case 4:
                    cart.checkout();
                    break;

                case 5:
                    System.out.println("\n--- RETURN ITEM ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i).getName());
                    }
                    System.out.print("Select item to return to stock: ");
                    int returnIdx = scanner.nextInt() - 1;
                    if (returnIdx >= 0 && returnIdx < inventory.size()) {
                        inventory.get(returnIdx).returnItem();
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Please select a valid option between 1 and 6.");
            }
        }
        scanner.close();
    }
}