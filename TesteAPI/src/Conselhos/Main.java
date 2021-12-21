package Conselhos;

public class Main {
    public static void main(String[] args) throws Exception {
        Slip slip = BuscaConselho.pegaConselhos();
        System.out.println("ID: " + slip.slip.getId());
        System.out.println("Conselho: " + slip.slip.getConselhos());
    }
}
