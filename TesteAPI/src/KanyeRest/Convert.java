package KanyeRest;

import java.io.BufferedReader;
import java.io.IOException;

public class Convert {
    public static String converter(BufferedReader buf) throws IOException {
        String resposta, convert = "";
        while ((resposta = buf.readLine()) != null){
            convert += resposta;
        }
        return convert;
    }
}
