package inventory_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wrehouse_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Product%d – Enter name, quantity, reorderlevel:%n", i);
            String name = sc.next();        // assumes one‑word names; use nextLine() if you need spaces
            int qty      = sc.nextInt();
            int reorder  = sc.nextInt();
            products.add(new Product(name, qty, reorder));
        }

        System.out.println("\nProducts with sufficient stock:");
        boolean found = false;
        for (Product p : products) {
            if (p.isStockSufficient()) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("All items are at or below their reorder levels.");
        }

        sc.close();
    }
}