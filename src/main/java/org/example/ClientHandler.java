package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientHandler {
    private final int SERVER_PORT = 8888;

    private String url = "localhost:";

    public void initClient(String[] args){
        argumentsHandler(args);
    }

    private void argumentsHandler(String[] arguments){
        url += Integer.parseInt(arguments[2]);
    }
}
