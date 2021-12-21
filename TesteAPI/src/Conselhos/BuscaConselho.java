package Conselhos;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscaConselho {
    static String web = "https://api.adviceslip.com/advice";
    static int codigoSucesso = 200;

    public static Slip pegaConselhos() throws Exception{
        try {
            URL url = new URL(web);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String converts = Conversor.Convert(resposta);

            Gson gson = new Gson();
            Slip slip = gson.fromJson(converts, Slip.class);

            return slip;
        } catch (Exception e){
            throw new Exception("ERROR: " + e);
        }
    }
}
