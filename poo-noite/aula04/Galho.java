public class Galho extends Folha {
    Folha f1 = new Folha();
    Folha f2 = new Folha();

    public void balancarAoVento() { 
        super.balancarAoVento();
        f1.balancarAoVento();
        f2.balancarAoVento();
    }
}
