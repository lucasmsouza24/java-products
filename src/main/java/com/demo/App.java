package com.demo;

import com.demo.entities.*;
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.List;

public class App  {

    public static void main( String[] args ) {

        // Scanner
        Scanner sc = new Scanner(System.in);
        
        // inventory 
        Inventory inv = new Inventory();

        // main flow
        String answer;
        do {
            // show main menu and read input option
            System.out.println(Menu.mainMenu);
            answer = sc.nextLine();

            // handling input 
            switch (answer) {

                // show all products
                case "1":
                    showAllProducts(inv);
                    break;

                // insert new product
                case "2":
                    insertNewProduct(inv);
                    break;
                
                // delete product
                case "3":
                    deleteProduct(inv);
                    break;

                // get out the program
                default:
                    break;
            }
        } while (!answer.equals("4"));

        System.out.println("Bye!");

        // closing Scanner 
        sc.close();

    }

    public static void showAllProducts(Inventory inv) {
        // columns format
        System.out.println(String.format("\n%-5s  %-15s %-15s %-15s\n" + "-".repeat(50), "ID", "Product Name", "Price", "Amount"));

        // product format
        String str = "%-6s %-15s %-15s %-15s";

        // listing all products
        for (Product p : inv.getProducts()) {
            System.out.println(String.format(
                str,
                "[" + p.getId() + "]",
                p.getProdName(),
                "R$ " + String.format("%.2f", p.getPrice()),
                p.getAmount()));
        }
    }

    public static void insertNewProduct(Inventory inv) {
        // instancing scanners
        Scanner scs = new Scanner(System.in);
        Scanner scd = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        // product name
        System.out.println("\nType product name: ");
        String prodName = scs.nextLine();

        // price
        System.out.println("\nType product price: ");
        Double price = scd.nextDouble();

        // amount
        System.out.println("\nType product amount: ");
        Integer amount = sci.nextInt();

        // instancing product and inserting into db
        Product product = new Product(prodName, price, amount);
        inv.addProduct(product);

        // success message
        System.out.println("\nNew product added!\n");

    }

    public static void deleteProduct(Inventory inv) {

        // instancing scanner
        Scanner sci = new Scanner(System.in);

        // input id
        System.out.println("\nType product id: (0 show list, -1 exit)");
        Integer id = sci.nextInt();

        if (id == 0) {
            // show all product ids
            showAllProducts(inv);
            deleteProduct(inv);
        } else if (id != -1) {
            // deleting product
            inv.deleteProdById(id);
            System.out.println(String.format("\ndeleted product [%d]", id));
        }
    }   
}
