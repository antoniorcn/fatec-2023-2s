import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

class AssinanteA implements ChangeListener<String> {
    @Override
    public void changed(ObservableValue<? extends String> observable, 
                String valorAntigo, 
                String valorNovo) {
        System.out.println("Variavel alterada de " + 
        valorAntigo + " para " + valorNovo);
    } 
}


public class VariaveisEspeciais {

    public static void main(String[] args) {
        System.out.println("Iniciado");
        AssinanteA assinanteA = new AssinanteA();

        StringProperty outroNome = new SimpleStringProperty("");
        StringProperty nome = new SimpleStringProperty("");

        Bindings.bindBidirectional(nome, outroNome);

        nome.addListener(assinanteA);
        nome.set("João Silva");
        nome.set("João Santos");

        System.out.println("Outro Nome: " + outroNome.get());

        System.out.println("Finalizado");

    }
    
}
