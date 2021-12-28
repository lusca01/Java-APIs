package DesafioBackend;

import java.util.Arrays;

public class Starship {
    String [] pilots;

    public String getPilotos(int index) {
        return pilots[index];
    }

    @Override
    public String toString() {
        return "Starship{" +
                "pilotos=" + Arrays.toString(pilots) +
                '}';
    }
}
