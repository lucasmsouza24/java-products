package com.demo.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Config {
    
    public static BasicDataSource getBds() {

        // instancing and configuring basic data source
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/dbinventory");
        bds.setUsername("root");
        bds.setPassword("urubu100");

        return bds;
    }

    public static JdbcTemplate getTemplate() {
        return new JdbcTemplate(getBds());
    }
}
