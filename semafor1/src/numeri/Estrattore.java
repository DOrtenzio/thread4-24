package numeri;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Estrattore extends Thread {
    //Attributo statici
    private static Semaphore semExample = new Semaphore(1);
    private static int contatore=0;
    private static int pariPrecedente=-2;
    private static int dispariPrecedente=-1;

    //Attributi dinamici
    private String nome;
    private boolean isPari;

    //Costruttore
    public Estrattore(String nome, boolean isPari){
        this.nome=nome;
        this.isPari=isPari;
    }

    //Metodo di stampa
    public void stampa(){
        if (isPari && (contatore-2)==pariPrecedente) {
            pariPrecedente=contatore;
            System.out.println(contatore + " " + this.nome);
            contatore++;
        }else if (!isPari && (contatore-2)==dispariPrecedente) {
            dispariPrecedente=contatore;
            System.out.println(contatore + " " + this.nome);
            contatore++;
        }
    }

    //Metodo run
    public void run()  {
        while (true){
            try { //Acquire
                semExample.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stampa(); //Stampo se posso
            semExample.release(); //Release
            try { //Tempo d'attesa
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
