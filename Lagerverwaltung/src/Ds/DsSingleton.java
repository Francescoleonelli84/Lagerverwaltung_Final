package Ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DsSingleton {

	private static Connection con = null;
	private static DsSingleton dss = null;

	static {

		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost: 3307/Lagerverwaltung", "root", "root");
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static DsSingleton getInstance() {
		if (dss == null)
			dss = new DsSingleton();
		return dss;
	}

	public static Connection getConnection() {
		return con;
	}

}
