package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import tables.Manad;

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

	public ArrayList<Manad> adderaManader(ArrayList<Manad> manadList) {

		manadList.add(new Manad("Januari", 1));
		manadList.add(new Manad("Februari", 2));
		manadList.add(new Manad("Mars", 3));
		manadList.add(new Manad("April", 4));
		manadList.add(new Manad("Maj", 5));
		manadList.add(new Manad("Juni", 6));
		manadList.add(new Manad("Juli", 7));
		manadList.add(new Manad("Augusti", 8));
		manadList.add(new Manad("September", 9));
		manadList.add(new Manad("Oktober", 10));
		manadList.add(new Manad("November", 11));
		manadList.add(new Manad("December", 12));
		return manadList;

	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
