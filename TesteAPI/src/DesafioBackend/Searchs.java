package DesafioBackend;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Searchs {

    static String BaseURLChars = "https://swapi.dev/api/people/", json = "?format=json";
    static String BaseURL = "https://swapi.dev/api/";

    public static List<People> searchParticipations() throws Exception{
        int sucess = 200, c = 1;
        List<People> AllCharacters = new ArrayList<>();

        while(sucess == 200){
            String newUrl = BaseURLChars + String.valueOf(c) + json;
            try {
                URL url = new URL(newUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                if (connection.getResponseCode() != sucess){
                    sucess = connection.getResponseCode();
                    break;
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String jsonToString = Useful.convertJsonToString(reader);

                Gson gson = new Gson();
                People people = gson.fromJson(jsonToString, People.class);

                AllCharacters.add(people);
                c++;
                if(c == 17){
                    c++;
                }
            }catch (Exception e){
                throw new Exception("Erro: " + e);
            }
        }
        AllCharacters.sort(Comparator.comparingInt(People::getLenght).reversed());
        return AllCharacters;
    }

    public static Starship searchPilotos() throws Exception {
        String newURL = BaseURL + "/starships/10/" + json;
        try {
            URL url = new URL(newURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != 200)
                throw new RuntimeException("Http error code: " + connection.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonToString = Useful.convertJsonToString(reader);

            Gson gson = new Gson();
            Starship pilots = gson.fromJson(jsonToString, Starship.class);

            return pilots;
        } catch (Exception e){
            throw new Exception("ERRO: " + e);
        }
    }

    public static List<People> FalconPilots(Starship pilotos) throws Exception{
        List<People> people = new ArrayList<>();
        for (String pilots: pilotos.pilots) {
            String newURL = pilots;
            URL url = new URL(newURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != 200)
                throw new RuntimeException("Http error code: " + connection.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonToString = Useful.convertJsonToString(reader);

            Gson gson = new Gson();
            People Pilots = gson.fromJson(jsonToString, People.class);

            people.add(Pilots);
        }

        return people;
    }
}
