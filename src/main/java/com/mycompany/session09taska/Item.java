
package com.mycompany.session09taska;

public abstract class Item {
    private String name;
    private double price;
    private int availableCopies;

    public Item(String name, double price, int availableCopies) {
        this.name = name;
        this.price = price;
        this.availableCopies = availableCopies;
    }

    public void sell() {
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("Error: " + name + " is out of stock!");
        }
    }

    public void returnItem() {
        availableCopies++;
        System.out.println("Returned 1 unit of " + name + ". Updated stock: " + availableCopies);
    }

    public abstract String getCategory();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }

    @Override
    public String toString() {
        return String.format("[%s] %s - $%.2f (In Stock: %d)", getCategory(), name, price, availableCopies);
    }
}