
package com.mycompany.session09taska;

public class Socks extends Clothing {
    private int pairsInPack;

    public Socks(String name, double price, int availableCopies, String size, String color, int pairsInPack) {
        super(name, price, availableCopies, size, color);
        this.pairsInPack = pairsInPack;
    }

    public int getPairsInPack() { return pairsInPack; }
    public void setPairsInPack(int pairsInPack) { this.pairsInPack = pairsInPack; }

    @Override
    public String getCategory() {
        return "Clothing - Socks";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Pairs/Pack: %d", pairsInPack);
    }
}