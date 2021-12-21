package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Info.*;

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
            switch(args[7]){
                case "get-buildings":
                    System.out.print(getBuildings());
                    break;
                case "get-civs":
                    System.out.println(getCivs());
                    break;
                case "get-units":
                    System.out.println(getUnits());
                    break;
                case "get-buildings-by-ages":
                    System.out.println();
                    break;
            }
        } catch (Exception e) {}
    }

    private void deleteUnit(String name) throws Exception{
        getInfo(urlServer, "DELETE", "/units/unit_name=" + name);
    }

    private BuildingsSection getBuildings() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String info = getInfo(urlServer, "GET", "/buildings");
        return mapper.readValue(info, BuildingsSection.class);
    }

    private CivsSection getCivs() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String info = getInfo(urlServer, "GET", "/civs");
        return mapper.readValue(info, CivsSection.class);
    }

    private UnitsSection getUnits() throws  Exception{
        ObjectMapper mapper = new ObjectMapper();
        String info = getInfo(urlServer, "GET", "/units");
        return mapper.readValue(info, UnitsSection.class);
    }

    private AgesSection getAgesSection(String data) throws  Exception{
        ObjectMapper mapper = new ObjectMapper();
        AgesSection ages = mapper.readValue(data, AgesSection.class);
        return ages;
    }

    private String getBuildingsByAges(String target) throws  Exception{
        String data =  getInfo(urlServer, "GET", "/ages/:age/buildings");
        return getAgesSection(data).toString(target);
    }

    private String getUnitsByAges(String target) throws  Exception{
        String data = getInfo(urlServer, "GET", "/ages/:age/units");
        return getAgesSection(data).toString(target);
    }

    private Unit getUnit (String target) throws  Exception{
        ObjectMapper mapper = new ObjectMapper();
        String info = getInfo(urlServer, "GET", "/units/:unit_name=" + target);
        return mapper.readValue(info, Unit.class);
    }

    private String getInfo(String urlLink, String method, String extention, String request) throws Exception {
        return null;
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
