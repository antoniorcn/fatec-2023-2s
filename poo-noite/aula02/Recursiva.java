public class Recursiva {
    static int contador = 0;
    public static void main(String[] args) {
        System.out.println(contador++);
        main(args);
    }
}
