package Sheets;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltrarArquivo {

    public void readFile(String path, String nome, String ano, String mes, String media) throws IOException {
        File arq = new File(/*path, nome*/"/home/lucas/Downloads/marketing_campaign.csv");
        if(arq.exists() && arq.isFile()) {
            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            linha = buffer.readLine();
            int contadorGeral = 1, contadorFiltro = 0;
            while(linha != null) {
                String[] vetor = linha.split("\t");
                if((Integer.parseInt(vetor[1]) >= 1957 && Integer.parseInt(vetor[1]) <= 1967) && vetor[2].contains("Master") && vetor[3].contains("Married")) {
                    System.out.println(vetor[1] + "\t" + vetor[2] + "\t" + vetor[3]);
                    contadorFiltro++;
                }
                contadorGeral++;
                linha = buffer.readLine();
            }
            System.out.println("Total geral: " + contadorGeral + "\nFiltrados: " + contadorFiltro);
            float difference = (contadorFiltro * 100) / contadorGeral;
            System.out.println("Consumer found in relation of total: " + difference);
            buffer.close();
            leitor.close();
            fluxo.close();
        }else {
            throw new IOException("Arquivo Inválido");
        }
    }
}
