package org.example;

public class App {
    public static void main( String[] args ) {
        String[] arg = {"--server", "-port", "12345", "--data", "data/", "--threads", "6"};
        ServerHandler server = new ServerHandler();
        server.setUpServer(arg);

        ClientHandler client = new ClientHandler();
        client.setUpServer(arg);
    }
}
