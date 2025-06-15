package Product_check;

import java.util.*;

public class ProductStockCheck {
   public static void main(String[]args){
       Scanner s = new Scanner(System.in);

       List<Product> ProductList = new ArrayList<>();

       System.out.print("Enter number of products: ");
       int n = s.nextInt();
       s.nextLine();                    // ➊ clear the newline AFTER reading n

       for (int i = 1; i <= n; i++) {
           System.out.printf("product %d - Enter name: ", i);
           String name = s.nextLine();  // ➋ read the full line ONCE

           System.out.printf("product %d - Enter Quantity(in Kg's): ", i);
           int quantity = s.nextInt();

           System.out.printf("product %d - Enter Reorder Level: ", i);
           int reorder = s.nextInt();
           s.nextLine();                // ➌ clear newline after the two ints

           ProductList.add(new Product(name, quantity, reorder));
       }

       System.out.println("\n--- Available Products ---");
       for (Product p : ProductList) {
           if (p.isStockAvailable()) {
               System.out.println(p);
           }
       }

       System.out.println("\n--- Out of Stock or Below Reorder Level ---");
       for (Product p : ProductList) {
           if (!p.isStockAvailable()) {
               System.out.println("Product_name: " +p.getName() + " is below reorder level (OUT OF STOCK)");
           }
       }
       s.close();
   }
}
