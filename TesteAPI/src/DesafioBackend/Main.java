package DesafioBackend;

import java.util.List;

// Challenge
// Código em Java
// Você deve encontrar os personagens que mais aparecem nos filmes SW (você pode colocá-los em ordem se quiser); Check
// Verifique quantos pilotos o Millenium Falcon tinha e quem eram eles ?;
// Apresente os resultados da melhor maneira que puder
public class Main {

    public static void main(String[]args) throws Exception{
        Searchs searchs = new Searchs();
        //List<People> listParticipations = Searchs.searchParticipations();
        Starship ship = Searchs.searchPilotos();
        List<People> listPilots = Searchs.FalconPilots(ship);

//        for (People pilots: listPilots) {
//            System.out.println(pilots.getName());
//        }
//        for (People peoples: list) {
//            System.out.println("Nome: " + peoples.getName()+
//                    "\nParticipations: " + peoples.getFilms().length);
//        }

    }

}


// Fluxo ideal
// Encontre personagens e filmes por meio da API;
// Encontre o navio;
// Quantos pilotos o dirigiram;
// Seus respectivos nomes;
// Representar visualmente os dados obtidos
