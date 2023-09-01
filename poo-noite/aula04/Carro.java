public class Carro {
    String marca;
    Pneu p;
    private Motor motor;
  
    public Carro(String m, Pneu pneu) { 
        this.marca = m;
        this.p = pneu;
        this.motor = new Motor();
    }
    

    public Carro() { 
        this.marca = "Chevrolet";
        this.p = new Pneu();
        this.motor = new Motor();
    }


    // public Motor getMotor() { 
    //     return this.motor;
    // }
}
