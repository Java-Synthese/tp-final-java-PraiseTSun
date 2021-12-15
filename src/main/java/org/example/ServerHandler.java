package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerHandler {
    private enum infoNeeded{
        buildings,
        civs,
        units
    }

    private int serverPort;
    private Path dataFolder;

    public void initServer(String[] arguments){
        argumentsHandler(arguments);
        readFiles();
    }

    private void argumentsHandler(String[] arguments){
        if(arguments.length < 7)
            throw new RuntimeException("There are some missing arguments");

        serverPort = Integer.parseInt(arguments[2]);

        if(!Files.isDirectory(Paths.get(arguments[4])))
            throw new RuntimeException(arguments[4] + " is not the data folder path.");
        dataFolder = Paths.get(arguments[4]);
    }

    private void readFiles(){
        File folder = new File(dataFolder.toString());
        File[] listOfFiles = folder.listFiles();

        for ( File file : listOfFiles) {
            if(file.isFile())
                System.out.println(file.getName());
        }
    }

    private void readData(){

    }
}
