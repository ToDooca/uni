package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private static ServerSocket server = null;

    public static void initServer(int port) throws IOException {
        if (server == null) {
            Server.server = new ServerSocket(port);
            System.out.printf("Starting server on port %d\n", port);
            // start a loop that handles incoming connections
            handleRequests();
        }
    }

    private static void handleRequests() {
        while (true) {
            try {
                // since server.accept() is blocking whenever new connection
                // is received start a new thread that handles it
                new Thread(new HandlerThread(server.accept())).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connection received");
        }
    }
}
