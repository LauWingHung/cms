package db;
import java.sql.*;

import java.sql.*;
public class DBConnection {
  public static Connection getConn(){ 
	//�й����ݿ������Connection
	Connection conn=null;
	
	String DRIVERNAME="com.mysql.jdbc.Driver";
	//����mysql���ݿ��ĸ���������ݿ�
	String DBURL="jdbc:mysql://localhost:3306/lau1yach";
	//ָ�����ӵľ������ݿ�lau1yach����������
	try{
		//��������
		Class.forName(DRIVERNAME);
		//��ȡ����
		conn=DriverManager.getConnection(DBURL,"root","root");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	return conn;
  }	
}