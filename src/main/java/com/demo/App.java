package com.demo;

import java.util.ArrayList;
import java.util.List;
import com.demo.entities.*;
// import java.util.List;
// import java.util.ArrayList;
// import com.demo.db.Config;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;


public class App  {

    public static void main( String[] args ) {
        
        // inventory 
        Inventory inv = new Inventory();

        // Product p1 = new Product("Garrafa", 25, 10);
        // inv.addProduct(p1);

        for (Product p : inv.getProducts()) {
            System.out.println(p);
        }

    }

}
