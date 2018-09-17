package db;
import java.sql.*;

import java.sql.*;
public class DBConnection {
  public static Connection getConn(){ 
	//有关数据库的连接Connection
	Connection conn=null;
	
	String DRIVERNAME="com.mysql.jdbc.Driver";
	//连接mysql数据库哪个具体的数据库
	String DBURL="jdbc:mysql://localhost:3306/lau1yach";
	//指明连接的具体数据库lau1yach，建立连接
	try{
		//加载驱动
		Class.forName(DRIVERNAME);
		//获取连接
		conn=DriverManager.getConnection(DBURL,"root","root");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	return conn;
  }	
}