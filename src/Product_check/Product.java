package Product_check;

public class Product {
    private String name;
    private int quantity;
    private int reorder;

    public Product(String name, int quantity ,int reorder){
        this.name = name;
        this.quantity = quantity;
        this.reorder = reorder;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getreorderLevel(){
        return reorder;
    }

    public boolean isStockAvailable(){
        return quantity>reorder;
    }

    @Override
    public String toString() {
        return "Product_name: " + name +
                " Quantity: "    + quantity +
                " Reorder Level: " + reorder;
    }
}

