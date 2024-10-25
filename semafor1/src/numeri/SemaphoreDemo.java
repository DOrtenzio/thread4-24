package numeri;


public class SemaphoreDemo {

    public static void main(String[] args){
        //Creazione estrattori
        Estrattore m1=new Estrattore("Estrattore 1",true);
        Estrattore m2=new Estrattore("Estrattore 2", false);

        //Avvio
        m1.start();
        m2.start();
    }
}