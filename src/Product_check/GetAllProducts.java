package Product_check;

import java.util.List;;

public class GetAllProducts {
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
}
