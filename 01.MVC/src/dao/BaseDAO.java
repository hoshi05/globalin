package dao;

import java.sql.Statement;
import java.util.List;

import model.Memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER = "madang";
    public static final String PASSWORD = "madang";

    public Connection getConnection() {
    	Connection connection = null;
    	try {
    		Class.forName(DRIVER);
    		connection = DriverManager.getConnection(URL, USER, PASSWORD);
    	}catch(SQLException ex01) {
    		ex01.printStackTrace();
    	}catch(ClassNotFoundException ex02) {
    		ex02.printStackTrace();
    	}
		return connection;	
    }
    public void closeDBObjects(ResultSet resultset, Statement statement, Connection connection) {
    	if(resultset != null) {
    		try {
    			resultset.close();		
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if(statement !=null) {
    		try { 
    			statement.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if(connection != null) {
    		try {
    			connection.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }


}

