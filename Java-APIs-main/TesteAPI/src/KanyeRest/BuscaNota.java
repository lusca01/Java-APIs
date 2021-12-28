package KanyeRest;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscaNota {
    static String web = "https://api.kanye.rest";
    static int sucess = 200;

    public static Filosofia buscaNota() throws Exception{
        try {
            URL url = new URL(web);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != sucess)
                throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String convert = Convert.converter(resposta);

            Gson gson = new Gson();
            Filosofia filosofia = gson.fromJson(convert, Filosofia.class);

            return filosofia;
        } catch (Exception e){
            throw new Exception("error: " + e);
        }
    }
}
