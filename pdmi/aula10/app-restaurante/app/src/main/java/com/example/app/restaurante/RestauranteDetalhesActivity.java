package com.example.app.restaurante;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDetalhesActivity extends AppCompatActivity {

    public static final String APP_RESTAURANTE = "APP Restaurante";
    private List<Restaurante> restaurantes = new ArrayList<>();
    private EditText txtNome;
    private EditText txtEndereco;
    private EditText txtTipo;
    private EditText txtClassificacao;
    private EditText txtLatitude;
    private EditText txtLongitude;
    private EditText txtDescricao;

    private Button btnSalvar;

    private Button btnPesquisar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.restaurante_activity_layout);

        txtNome = findViewById(R.id.txtNome);
        txtEndereco = findViewById(R.id.txtEndereco);
        txtTipo = findViewById(R.id.txtTipo);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        txtLatitude = findViewById(R.id.txtLatitude);
        txtLongitude = findViewById(R.id.txtLongitude);
        txtDescricao = findViewById(R.id.txtDescricao);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener( e -> pesquisar() );

        btnSalvar.setOnClickListener( e -> salvar() );
        carregarPrefs();
    }

    private void salvar() {
        Restaurante r = new Restaurante();
        r.setNome(txtNome.getText().toString());
        r.setEndereco(txtEndereco.getText().toString());
        r.setTipo(txtTipo.getText().toString());
        r.setClasse( Integer.parseInt(
                txtClassificacao.getText().toString()) );
        r.setLatitude( Double.parseDouble(
                txtLatitude.getText().toString()) );
        r.setLongitude( Double.parseDouble(
                txtLongitude.getText().toString()) );
        r.setDescricao( txtDescricao.getText().toString() );

        restaurantes.add( r );


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
                Log.e(APP_RESTAURANTE, "Erro ao mandar o POST", e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        mostrarLista();
    }

    private void pesquisar() {
        String nome = txtNome.getText().toString();
        Log.d(APP_RESTAURANTE, "Pesquisando restaurante: (" + nome + ")");
        for (Restaurante r : restaurantes) {
            Log.d(APP_RESTAURANTE, "Restaurante: (" + r.getNome() + ") contém " +
                    r.getNome().contains( nome ) );
            if (r.getNome().contains( nome )) {
                txtNome.setText( r.getNome() );
                txtEndereco.setText( r.getEndereco() );
                txtTipo.setText( r.getTipo() );
                txtClassificacao.setText( String.valueOf(r.getClasse()) );
                txtLatitude.setText( String.valueOf(r.getLatitude()) );
                txtLongitude.setText( String.valueOf(r.getLongitude()) );
                txtDescricao.setText( r.getDescricao() );
            }
        }
    }

    private void mostrarLista () {
        for (Restaurante r : restaurantes) {
            Log.d(APP_RESTAURANTE, r.toString());
        }
    }

    private void salvarPrefs() {
        Log.d(APP_RESTAURANTE, "Salvar Prefs acionado");
        SharedPreferences sharedPref
                = getSharedPreferences("RESTAURANTES", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = gson.toJson(restaurantes);
        Log.d(APP_RESTAURANTE, "Restaurantes da lista a ser salvo no SharedPref");
        Log.d(APP_RESTAURANTE, strLista);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("LISTA", strLista);
        editor.apply();
    }

    private void carregarPrefs() {
        SharedPreferences shared
                = getSharedPreferences("RESTAURANTES", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = shared.getString("LISTA","[]");
        Log.d(APP_RESTAURANTE, "JSON Lido: " + strLista);
        Type listType = new TypeToken<ArrayList<Restaurante>>(){}.getType();
        ArrayList<Restaurante> list = gson.fromJson(strLista, listType);
        if (list != null) {
            restaurantes.clear();
            restaurantes.addAll(list);
        }
        Log.d(APP_RESTAURANTE, "Restaurantes da lista lida no SharedPref");
        if (restaurantes != null) {
            for (Restaurante r : restaurantes) {
                Log.d(APP_RESTAURANTE, r.toString());
            }
        }
    }
}
