public class Teste {
    
    public static void main(String[] args) {
        Pneu p1 = new Pneu("Firestone", 14);
        // p1.iniciar("Firestone", 14);

        Carro c1 = new Carro("Fiat", p1);
        Carro c2 = new Carro();

        c1.p = null;
    }
}
