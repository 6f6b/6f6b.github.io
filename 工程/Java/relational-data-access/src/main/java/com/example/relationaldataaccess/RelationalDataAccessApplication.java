package com.example.relationaldataaccess;

import com.example.relationaldataaccess.model.Customer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RelationalDataAccessApplication implements CommandLineRunner {
    private static Logger log = LoggerFactory.getLogger(RelationalDataAccessApplication.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RelationalDataAccessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            log.info("CREATING TABLES ....");
            jdbcTemplate.execute("DROP TABLE customer IF EXISTS ");
            jdbcTemplate.execute("CREATE TABLE customer(id INT IDENTITY(1,1) PRIMARY KEY ,firstName VARCHAR(255),lastName VARCHAR (255))");
            List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                    .stream()
                    .map(name->name.split(" "))
                    .collect(Collectors.toList());
            splitUpNames.forEach(objects -> log.info(String.format("%s %s",objects[0],objects[1])));
            jdbcTemplate.batchUpdate("INSERT INTO customer (firstName,lastName) VALUES (?,?)",splitUpNames);
            log.info("Querying for customer records where first_name = 'Josh':");

            List<Customer> customers = jdbcTemplate.query("SELECT * FROM customer",
                    (rs, rowNum) -> new Customer(rs.getLong("id"),rs.getString("firstName"),rs.getString("lastName"))
            );
            log.info("查询结果------------->");
            customers.forEach(customer -> log.info(customer.toString()));
        }catch (DataAccessException e){
            log.info(e.getLocalizedMessage());
        }
    }
}
