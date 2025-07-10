package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    // Write your code here!

    @Override
    public Connection createConnection(){
        try(InputStream input = H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties")){
            Properties props = new Properties();
            props.load(input);
            Class.forName(props.getProperty("jdbc_driver"));
            String url = props.getProperty("db_url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            return DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}

