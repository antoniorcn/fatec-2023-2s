package com.example.app.restaurante;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Teste {
    public static final String APP_RESTAURANTE = "APP Restaurante";
    public static void main(String[] args) {
        Restaurante r = new Restaurante();
        r.setNome("Mc Donalds");
        r.setEndereco("Av. Aguia de Haia");
        r.setTipo("Fast food");
        r.setClasse( 4 );
        r.setLatitude( 0);
        r.setLongitude( 0);
        r.setDescricao( "Hamburgueria Fast Food");

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
            Gson gson = new Gson();
            con.connect();
            try (OutputStream out = con.getOutputStream()) {
                String strRestaurante = gson.toJson(r);
                byte bytes[] = strRestaurante.getBytes("UTF-8");
                out.write(bytes, 0, bytes.length);
            } catch (Exception e) {
                System.out.println("Erro ao mandar o POST");
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
