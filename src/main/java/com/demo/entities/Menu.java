package com.demo.entities;

public class Menu {

    public static String mainMenu = "\n" + title("Select any option") + "\n[1] show all products\n" + 
        "[2] insert new product\n" +
        "[3] delete product\n" +
        "[4] get out\n";
    
    public Menu() {

    }

    public static String title(String title) {
        return "-".repeat(10) + title + "-".repeat(10);
    }

}
