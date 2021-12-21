package KanyeRest;


public class Principal {
    public static void main(String[] args) throws Exception {
        Filosofia filosofia = BuscaNota.buscaNota();
        System.out.println("Kenye Rest: " + filosofia.getQuote());
    }
}
