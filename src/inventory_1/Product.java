package inventory_1;

class Product {
    String name;
    int quantity;
    int reorderLevel;

    Product(String name, int quantity, int reorderLevel) {
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    boolean isStockSufficient() {
        return quantity > reorderLevel;
    }

    @Override
    public String toString() {
        return String.format("Product Name: %s, Quantity: %d, Re‑order Level: %d", name, quantity, reorderLevel);
    }
}
