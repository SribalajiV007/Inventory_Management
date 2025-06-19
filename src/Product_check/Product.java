package Product_check;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int reorder;

    public Product(int id,String name, int quantity ,int reorder)
    {
        this.id =id;
        this.name = name;
        this.quantity = quantity;
        this.reorder = reorder;
    }

    // Constructor without ID (for new insertions)
    public Product(String name, int quantity, int reorder){
        this.name = name;
        this.quantity = quantity;
        this.reorder = reorder;
    }

    public int getId(){
        return id;
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
        return  "ID: " + id +
                " Product_name: " + name +
                " Quantity: "    + quantity +
                " Reorder Level: " + reorder;
    }
}

