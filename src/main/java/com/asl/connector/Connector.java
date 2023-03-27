package com.asl.connector;

import java.io.FileInputStream;
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
		String fileName = "src/main/java/com/asl/resources/config.properties";
		//try {
	//	Properties p=new Properties();
		
//		ClassLoader classLoader = getClass().getClassLoader();
	//	InputStream in=new FileInputStream(fileName);
//		InputStream in= classLoader.getResourceAsStream(fileName);
//		if (in == null) {
//            throw new IllegalArgumentException("file not found! " );
//        } 
	//	p.load(in);
		//url=(String)p.getProperty("url");
	//	username=(String)p.getProperty("username");
	//	password=(String)p.getProperty("password");
		
//	    }
		//catch(Exception e)
	   // {
	//	e.printStackTrace();
		
	 //   }
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
//			 con=DriverManager.getConnection(url,username,password);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "roy", "sauryadeep");
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return con;
		
		
	}
}