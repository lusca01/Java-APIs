package DesafioBackend;

import java.util.List;

// Challenge
// Código em Java
// Você deve encontrar os personagens que mais aparecem nos filmes SW (você pode colocá-los em ordem se quiser); Check
// Verifique quantos pilotos o Millenium Falcon tinha e quem eram eles ; Check
// Apresente os resultados da melhor maneira que puder
public class Main {

    public static void main(String[]args) throws Exception{
        Searchs searchs = new Searchs();
        List<Character> listParticipations = Searchs.searchParticipations();
        Starship ship = Searchs.searchPilotos();
        List<Character> listPilots = Searchs.FalconPilots(ship);

        System.out.println("Lista de Participantes e suas participações: ");
        for (Character peoples: listParticipations) {
            System.out.println("Nome: " + peoples.getName()+
                    "\nParticipations: " + peoples.getFilms().length);
        }

        System.out.println("\nQuantidade de pilotos que dirigiram a Millenium Falcon: "+ listPilots.size()
        + "\n\nE os pilotos foram:");
        for (Character pilots: listPilots) {
            System.out.println(pilots.getName());
        }
    }

}


// Fluxo ideal
// Encontre personagens e filmes por meio da API; Check
// Encontre o navio; Check
// Quantos pilotos o dirigiram; Check
// Seus respectivos nomes; Check
// Representar visualmente os dados obtidos; Vish
