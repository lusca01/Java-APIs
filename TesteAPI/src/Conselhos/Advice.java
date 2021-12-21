package Conselhos;

public class Advice {
    String id;
    String advice;

    public String getConselhos() {
        return advice;
    }

    public String getId(){
        return id;
    }

    public String toString(){
        return "Conselhos.Conselho{" + "id=" + id + ", advice=" + advice + '}';
    }
}
