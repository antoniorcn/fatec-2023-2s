public class Teste { 

    public static void main (String[] args) { 
        Circulo c1 = new Circulo();
        c1.raio = 50.0f;
        double area = c1.calcularArea();
        System.out.println("Area: " + area );

        Circulo c2 = new Circulo();
        c2.raio = 25.0f;
        area = c2.calcularArea();
        System.out.println("Area: " + area );
        
       System.out.println("PI: " + Circulo.PI);
    }

}