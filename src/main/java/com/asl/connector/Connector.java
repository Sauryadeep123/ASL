package com.asl.connector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connector {

	private static Connection con = null;

	public static Connection getConnection()
	{
		
		String url="";
		String username="";
		String password="";
		
		Properties p=new Properties();
		

		
		TestClass ob= new TestClass();
		try {
			p.load(ob.getFileFromResourceAsStream("com/asl/resources/config.properties"));
			url=(String)p.getProperty("url");
			username=(String)p.getProperty("username");
			password=(String)p.getProperty("password");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 con=DriverManager.getConnection(url,username,password);
			 System.out.println("connection created");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "asl", "fruit1");
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return con;
		
		
	}
}