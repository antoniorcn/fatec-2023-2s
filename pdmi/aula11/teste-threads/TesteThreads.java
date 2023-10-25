public class TesteThreads {

    public static void main(String[] args) {
        CodigoA codA = new CodigoA();
        Thread thA = new Thread(codA);
        thA.start();

        CodigoB codB = new CodigoB();
        Thread thB = new Thread(codB);
        thB.start();
    }
}