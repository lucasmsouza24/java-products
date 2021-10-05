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
        String str = "[%s]    %-15s %-15s %-15s";

        // listing all products
        for (Product p : inv.getProducts()) {
            System.out.println(String.format(
                str,
                p.getId(),
                p.getProdName(),
                "R$ " + String.format("%.2f", p.getPrice()),
                p.getAmount()));
        }
    }

}
