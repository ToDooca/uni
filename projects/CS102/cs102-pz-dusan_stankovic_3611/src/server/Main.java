package server;

import server.db.DBController;

import java.io.IOException;

public class Main {
	private static final int port = 8080;

	public static void main(String[] args) {

		// initialize database tables
		DBController.initDatabase();
		try {
			Server.initServer(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
