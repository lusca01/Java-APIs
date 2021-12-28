package Conselhos;

import java.io.BufferedReader;
import java.io.IOException;

public class Conversor {
    public static String Convert (BufferedReader buf) throws IOException{
        String resposta, jsonEmString = "";
        while((resposta = buf.readLine()) != null){
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
