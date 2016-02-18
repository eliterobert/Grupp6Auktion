package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum Model {
	MODEL;
	private Main main = new Main();
	public static Connection connection;

	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://auktion.clgxeckvrykx.eu-central-1.rds.amazonaws.com:3306/";
			String userName = "root";
			String password = "rootroot";
			String dbName = "auktion";
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

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
