public class Circulo { 

    public static final float PI =3.1415f;
      
    public float raio;
    public float x;
    public float y;

    public double calcularArea() { 
        return this.raio * this.raio * Circulo.PI;
    }

}