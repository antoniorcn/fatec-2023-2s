import java.util.Random;

public class CodigoB implements Runnable {
    private Random rnd = new Random();
    public void run() { 
        int tempo = rnd.nextInt(5);
        System.out.println("Iniciado");
        for (long i = 0; i < 100; i++) { 
            try { 
                Thread.sleep(tempo);
            } catch (Exception e) { 
                e.printStackTrace();
            }
            System.out.println("B: " + i);
        }
        System.out.println("Finalizado");
    }
    
}
