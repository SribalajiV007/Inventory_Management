package Product_check;

import Database.DBUtil;
import java.sql.*;
import java.util.*;

public class ProductStockCheck {
    private static final Scanner s = new Scanner(System.in);
    private static final ProductDAO dao = new ProductDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                    
                    ===Smart WareHouse ====
                    1.Add product.
                    2.View all Products.
                    3.Update Product.
                    4.Delete Product.
                    5.Total Count of products in Warehouse.
                    6.Exit.
                    
                    Choose: """);
            int ch = s.nextInt();
            s.nextLine();

            switch (ch) {
                case 1 -> addProduct();
                case 2 -> showProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> showProductCount();
                case 6 ->{
                    s.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Name : ");
        String name = s.nextLine();

        System.out.print("Qty  : ");
        int q = s.nextInt();

        System.out.print("ReLvl: ");
        int r = s.nextInt();
        s.nextLine();

        dao.insertProduct(new Product(name, q, r));
        System.out.println("Product Added Succesfully");
    }

    private static void showProducts() {
        List<Product> all = dao.getAllProducts();

        System.out.println("\n--- Available Products ---");
        for (Product p : all) {
            if (p.isStockAvailable()) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Out of Stock or Below Reorder Level ---");
        for (Product p : all) {
            if (!p.isStockAvailable()) {
                System.out.println("Product_name: " + p.getName() + " is below reorder level (OUT OF STOCK)");
            }
        }
    }

    private static void updateProduct(){
        System.out.print("Enter Product_Id to update: ");
        int pid = s.nextInt();

        System.out.print("New Product Name: ");
        String newName = s.nextLine();

        System.out.print("New Quantity :  "); int qty = s.nextInt();
        System.out.print("New Reorder Level  :  "); int rl = s.nextInt(); s.nextLine();

        boolean ok = dao.updateProduct(pid,newName,qty,rl);
        System.out.println(ok ? "Updated Succesfully." : "Product not found");
    }

    private static void deleteProduct(){
        System.out.println("Product Id to delete: ");
        int pid = s.nextInt();
        boolean ok = dao.deleteProduct(pid);
        System.out.println(ok ? "→ Deleted." : "Product not found.");
    }

    private static void showProductCount() {
        int count = dao.getProductCount();
        System.out.println("📦 Total Products in Warehouse: " + count);
    }

}
