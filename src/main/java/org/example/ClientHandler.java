package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientHandler {
    private final int SERVER_PORT = 8888;

    private String urlServer = "http://localhost:";

    public void setUpServer(String[] args){
        argumentsHandler(args);
        try {
            System.out.println(getBuildings());
            System.out.println(getCivs());
            System.out.println(getUnits());
        } catch (Exception e) {}
    }

    private String getBuildings() throws Exception{
        return getInfo(urlServer, "GET", "/buildings");
    }

    private String getCivs() throws Exception{
        return getInfo(urlServer, "GET", "/civs");
    }

    private String getUnits() throws  Exception{
        return getInfo(urlServer, "GET", "/units");
    }

    private String getBuildingsByAges(String target) throws  Exception{
        return getInfo(urlServer, "GET", "/ages/:age/buildings");
    }

    private String getUnitsByAges(String target) throws  Exception{
        return getInfo(urlServer, "GET", "/ages/:age/units");
    }

    private String getInfo(String urlLink, String method, String extention) throws Exception{
        String content = "";
        URL url = new URL(urlLink + extention);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);

        try(BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
            String line;
            while((line = r.readLine()) != null){
                content += line;
            }
        }
        conn.disconnect();
        return content;
    }

    private void argumentsHandler(String[] arguments){
        urlServer += Integer.parseInt(arguments[2]);
    }
}
