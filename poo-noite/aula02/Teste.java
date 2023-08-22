public class Teste { 
    public static void main(String[] args) {
        String s1 = "Antonio";
        String s4 = "Antonio";
        s4 = s4 + "";
        System.out.printf("(%s)", s1);
        System.out.printf("(%s)", s4);
        if (s1.equals(s4)) { 
            System.out.println("iguais");
        } else { 
            System.out.println("diferentes");
        }
    }
}