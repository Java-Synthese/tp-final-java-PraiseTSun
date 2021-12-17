package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.FilenameUtils;
import org.example.Info.Building;
import org.example.Info.Civilisation;
import org.example.Info.Unit;

public class ServerHandler {
    private final String EXT = "tab";

    private int serverPort;
    private Path dataFolder;

    private List<Unit> unitsList = new ArrayList<>();
    private List<Civilisation> civilisationList = new ArrayList<>();
    private List<Building> buildingList = new ArrayList<>();

    public void setUpServer(String[] arguments){
        argumentsHandler(arguments);
        readFiles();
        try {initServer();} catch (Exception e) {}
    }

    private void initServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 4);

        server.createContext("/test", exchange -> { exchangeTest(exchange);});
        server.createContext("/ages", exchange -> { exchangeAges(exchange);});

        server.start();
    }

    private void exchangeAges(HttpExchange exchange){
        String[] elements = exchange.getRequestURI().getPath().substring(1).split("/");

        try{
            if(elements.length == 1){
                exchange.sendResponseHeaders(202,0);
                writeBuffer("Retourne l’ensemble des informations sur les âges.",exchange);
            }
            else if(elements.length == 3){
                if(elements[1].equals(":age")){
                    if(elements[2].equals("units")){
                        exchange.sendResponseHeaders(202, 0);
                        writeBuffer("Retourne les informations sur les unités disponible pendant l’âge « :age »", exchange);
                    }
                    else if(elements[2].equals("buildings")){
                        exchange.sendResponseHeaders(202, 0);
                        writeBuffer("Retourne les informations sur les bâtiments disponible pendant l’âge « :age »", exchange);
                    }
                    else{
                        exchange.sendResponseHeaders(404, 0);
                        writeBuffer(elements[2] + " isn't allow.", exchange);
                    }
                }
                else{
                    exchange.sendResponseHeaders(404, 0);
                    writeBuffer(elements[1] + " isn't allow.", exchange);
                }
            }
            else{
                exchange.sendResponseHeaders(404, 0);
                writeBuffer("Numbers of arguments do not match the acceted commands.", exchange);
            }
        } catch (IOException e) {}
        finally{ exchange.close(); }
    }

    private void exchangeTest(HttpExchange exchange){
        try {
            exchange.sendResponseHeaders(200, 0);
            writeBuffer("test\ntest", exchange);
        } catch (IOException e) {}
        finally {
            exchange.close();
        }
    }

    private void writeBuffer(String content, HttpExchange exchange){
        try{
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(exchange.getResponseBody()));
            w.write(content);
            w.flush();
        } catch (IOException e) {}
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
            if(acceptedFile(file))
                collectData(file);
        }
    }

    private void collectData(File file){
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()))){
            String line;
            String fileName = file.getName();
            String[] lineElements;
            while((line = reader.readLine()) != null){
                lineElements = line.split("\t");
                switch (fileName){
                    case "civs.tab":
                        civilisationList.add(new Civilisation(lineElements[0], lineElements[1], lineElements[2], lineElements[3], lineElements[4]));
                        break;
                    case "buildings.tab":
                        buildingList.add(new Building(lineElements[0], lineElements[1].split(" "), lineElements[2], lineElements[3].split(" "), lineElements[4], Integer.parseInt(lineElements[5]), Integer.parseInt(lineElements[6]), lineElements[7].split(" ")));
                        break;
                    case "units.tab":
                        unitsList.add(new Unit(lineElements[0], lineElements[1].split(" "), lineElements[2], lineElements[3].split(" "), lineElements[4], Integer.parseInt(lineElements[5]), Integer.parseInt(lineElements[6]), lineElements[7].split(" ")));
                        break;
                }
            }
        } catch (IOException e) {}
    }

    private boolean acceptedFile(File file){
        return file.isFile() && FilenameUtils.getExtension(file.getName()).equals(EXT);
    }

}
