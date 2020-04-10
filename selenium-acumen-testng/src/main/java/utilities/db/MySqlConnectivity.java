package utilities.db;

import java.sql.*;

import utilities.common.ReadWritePropertiesFile;

public class MySqlConnectivity {
	
	public static Connection connectDataBase() {
		Connection con = null;
		try {
			String username =  ReadWritePropertiesFile.getPropertySQL("username");
			String password = ReadWritePropertiesFile.getPropertySQL("password");
			String serverIP = ReadWritePropertiesFile.getPropertySQL("ip");		
			String dbPort = ReadWritePropertiesFile.getPropertySQL("port");
			String dbName = ReadWritePropertiesFile.getPropertySQL("dbname");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + serverIP + ":" + dbPort + "/"+ dbName ;
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
