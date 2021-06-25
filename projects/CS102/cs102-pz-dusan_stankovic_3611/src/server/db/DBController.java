package server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {
	private static Connection con = null;
	private static final String urlWithoutDB = "jdbc:mysql://localhost:3306";
	private static final String url = "jdbc:mysql://localhost:3306/cs102";
	private static final String username = "root";
	private static final String password = "";

	public static void initDatabase() {
		try {
			con = DriverManager.getConnection(urlWithoutDB, username, password);
			Statement stmt = con.createStatement();
			stmt.execute("CREATE DATABASE IF NOT EXISTS cs102;");
			stmt.execute("USE cs102;");
			stmt.execute("CREATE TABLE IF NOT EXISTS task("
					+ "task_id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "task_text TEXT NOT NULL,"
					+ "deadline VARCHAR (32) NOT NULL,"
					+ "category VARCHAR (32) NOT NULL,"
					+ "isdone boolean default false);");
			con.close();
			con = null;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
