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
                    5.Exit.
                    
                    Choose: """);
            int ch = s.nextInt();
            s.nextLine();

            switch (ch) {
                case 1 -> addProduct();
                case 2 -> showProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> {
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



    private static void updateProduct(){
        System.out.print("Product name to update: ");
        String name = s.nextLine();

        System.out.print("New Quantity :  "); int qty = s.nextInt();
        System.out.print("New Reorder Level  :  "); int rl = s.nextInt(); s.nextLine();

        boolean ok = dao.updateProduct(name,qty,rl);
        System.out.println(ok ? "Updated Succesfully." : "Product not found");
    }

    private static void deleteProduct(){
        System.out.println("Product name to delete: ");
        String name = s.nextLine();
        boolean ok = dao.deleteProduct(name);
        System.out.println(ok ? "→ Deleted." : "Product not found.");
    }
}
