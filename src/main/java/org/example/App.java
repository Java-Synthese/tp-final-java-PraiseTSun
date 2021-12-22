package org.example;

public class App {
    public static void main( String[] args ) {
        String[] arg = {"--server", "-port", "8888", "--data", "data/", "--threads", "6"};
        if(arg[0].equals("--server")) {
            ServerHandler server = new ServerHandler();
            server.setUpServer(arg);
        }
        arg = new String[] {"java", "-jar", "votreApp.jar", "localhost:8888", "get-units", "Archer"};
        if (arg[0].equals("java")){
            ClientHandler client = new ClientHandler();
            client.setUpServer(arg);
        }
    }
}
