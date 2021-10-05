package com.demo.entities;

import java.util.ArrayList;
import java.util.List;
import com.demo.db.Config;
import com.demo.entities.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Inventory {

    // Product List
    private List<Product> products = new ArrayList<>();

    // update requirements
    private BeanPropertyRowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
    private JdbcTemplate template = Config.getTemplate();

    // constructors

    public Inventory () {
        this.updateList();
    }

    /**
     * insert @param p into product table
     */
    public void addProduct(Product p) {
        // insert product into db
        String sql = "INSERT INTO product VALUES " +
        "(%d, '%s', %s, %d)";
        sql = String.format(sql, p.getId(), p.getProdName(), p.getPrice(), p.getAmount());
        this.template.execute(sql);

        // update list
        this.updateList();
    }


    /**
     * delete product by @param id
     */
    public void deleteProdById(Integer id) {
        // delete sql
        String sql = "DELETE FROM product WHERE id = %s";
        sql = String.format(sql, id);

        // querying
        this.template.execute(sql);

        // update list
        this.updateList();
    }

    /**
     * @return actual product list
     */
    public List<Product> getProducts() {
        return this.products;
    }

    /**
     * update product List
     */
    public void updateList() {
        // querying actual products
        String sqlGetProducts = "SELECT * FROM product";
        List<Product> remoteProducts = this.template.query(sqlGetProducts, rowMapper);
        
        // cleaning actual product array
        this.products.clear();
        
        // adding query response products to the array
        for (Product p : remoteProducts) {
            this.products.add(p);
        }
    }
}
