import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Teste {
    public static final String APP_RESTAURANTE = "APP Restaurante";
    public static void main(String[] args) {
        String r = """
        {
            \"nome:\", \"Mc Donalds\",
            \"endereco\": \"Av. Aguia de Haia\",
            \"tipo\": \"Fast food\",
            \"classe\": 4,
            \"latitude\": 0,
            \"longitude\": 0,
            \"descricao\": \"Hamburgueria Fast Food\"
        }
        """;

        try {
            URL url =
                    new URL("https://fatec-2023-2s-pdmi-default-rtdb.firebaseio.com/restaurantes.json");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);
            con.setDoOutput(true);
            con.setDoInput(false);
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("accept", "application/json");
            con.connect();
            System.out.println("Conectado");
            try (OutputStream out = con.getOutputStream()) {
                byte bytes[] = r.getBytes("UTF-8");
                out.write(bytes, 0, bytes.length);
                out.flush();
            } catch (Exception e) {
                System.out.println("Erro ao mandar o POST");
                e.printStackTrace();
            }
            con.disconnect();
            System.out.println("Enviado");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
