public class Funcionario { 

    double salario;
    double pagamento;

    // public void calcularPagamento(float vr) { 
    //     pagamento = salario + vr;
    //     System.out.println("Pagamento : " + pagamento);
    // }

    // public void calcularPagamento(float vr, float bonus) { 
    //     pagamento = salario + vr + bonus;
    //     System.out.println("Pagamento: " + pagamento);
    // }

    // public void calcularPagamento(float [] beneficios) { 
    //     pagamento = salario;
    //     for (int i = 0; i < beneficios.length; i++) { 
    //         pagamento = pagamento + beneficios[i];
    //     }
    //     System.out.println("Pagamento: " + pagamento);
    // }

    public void calcularPagamento(float ... beneficios) { 
        pagamento = salario;
        for (int i = 0; i < beneficios.length; i++) { 
            pagamento = pagamento + beneficios[i];
        }
        System.out.println("Pagamento: " + pagamento);
    }

    public static void main(String args[]) { 
        Funcionario f1 = new Funcionario();
        f1.salario = 7000.0;
        // f1.calcularPagamento(new float[]{550.0f, 100.0f});
        f1.calcularPagamento(550.0f, 100.0f);

        Funcionario f2 = new Funcionario();
        f2.salario = 5000.0;
        // f2.calcularPagamento(new float[]{550.0f, 1500.0f, 350.0f});
        f2.calcularPagamento(550.0f, 1500.0f, 350.0f);
    }

}