package com.sai.advanceapplication.registration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {

	public static Connection createConnection() {

	Properties properties=new Properties();
	Connection connection=null;
	try {
		properties.load(new FileInputStream("D:\\FULL STACK JAVA\\Advance Java Project\\AdvanceJavaApplication\\src\\main\\webapp\\connection-info.properties"));
		Class.forName(properties.getProperty("driver"));
		connection =DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
	} catch (IOException | ClassNotFoundException | SQLException e) {

		e.printStackTrace();
	}
		return connection;
	}
}