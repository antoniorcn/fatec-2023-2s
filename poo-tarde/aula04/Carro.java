public class Carro {
    String marca;
    Pneu pneu;
    private Motor motor;

    public Carro(String marca, Pneu pneu) { 
        this.marca = marca;
        this.pneu = pneu;
        this.motor = new Motor("Nissan", 3.0f,
         "Gasolina");
    }

    public void acelerar() { 
        System.out.println("Potencia: " + motor.potencia);
    }
    
}
