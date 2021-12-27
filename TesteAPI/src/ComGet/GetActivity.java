package ComGet;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetActivity {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://www.boredapi.com/api/activity");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);

            Gson gson = new Gson();
            String output, jsons = "";
            while ((output = br.readLine()) != null) {
                jsons += output;
            }
            Activity activity = gson.fromJson(jsons, Activity.class);
            System.out.println("Atividade: " + activity.getActivity() +"\n" +
                               "Tipo: " + activity.getType() +"\n" +
                            "Participantes: " + activity.getParticipants() +"\n" +
                            "Preço: " + activity.getPrice() + "\n" +
                            "Link: " + activity.getLink() + "\n" +
                            "Chave: " + activity.getKey() + "\n" +
                            "Acessibilidade: " + activity.getAccessibility()
                            );
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}