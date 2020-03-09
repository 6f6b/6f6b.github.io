package com.example.jdbctest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class JdbcTestApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.print("获取连接之前==>datasource==>"+dataSource);
		try {
			Connection connection =  dataSource.getConnection();
			System.out.print("连接对象=>"+connection);
		}catch (SQLException e){
			System.out.print("SQL 异常");
		}
		System.out.print("获取连接之后==>datasource==>"+dataSource);
	}

}
