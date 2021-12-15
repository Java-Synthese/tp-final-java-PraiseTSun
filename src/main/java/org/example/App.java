package org.example;

public class App {
    public static void main( String[] args ) {
        String[] arg = {"--server", "-port", "24", "--data", "data/", "--threads", "test"};
        ServerHandler server = new ServerHandler();
        server.initServer(arg);
    }
}
