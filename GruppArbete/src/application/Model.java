package application;

import java.sql.*;

public enum Model {
	MODEL;
	Main main = new Main();
	public static Connection connection;

	public static Connection getConnection() {
		try {
			// connection =
			// DriverManager.getConnection("auktion.clgxeckvrykx.eu-central-1.rds.amazonaws.com:3306",
			// "root", "rootroot");
			String url = "jdbc:mysql://localhost:auktion:3306/";
			String userName = "root";
			String password = "";
			String dbName = "auktion";
			String driver = "com.mysql.jdbc.Driver";
			connection = DriverManager.getConnection(url + dbName, userName, password);
			if (connection != null) {
				System.out.println("Connected");
				return connection;
			} else {
				return null;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("not connected");
		}
		return null;
	}
}
