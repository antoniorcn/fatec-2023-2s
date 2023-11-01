package com.example.apprestaurante2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestauranteDetalhesActivity extends AppCompatActivity {
    private static final String URL ="https://fatec-2023-2s-pdmi-default-rtdb.firebaseio.com/restaurantes.json";
    public static final MediaType JSON = MediaType.get("application/json");
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

    private Button btnListar;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.restaurante_detalhes_layout);

        txtNome = findViewById(R.id.txtNome);
        txtEndereco = findViewById(R.id.txtEndereco);
        txtTipo = findViewById(R.id.txtTipo);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        txtLatitude = findViewById(R.id.txtLatitude);
        txtLongitude = findViewById(R.id.txtLongitude);
        txtDescricao = findViewById(R.id.txtDescricao);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnListar = findViewById(R.id.btnListar);

        btnListar.setOnClickListener(
                e -> {
                    Bundle b = new Bundle();
                    b.putSerializable("RESTAURANTES", (Serializable)restaurantes);
                    Intent it = new Intent( this,
                            RestauranteListaActivity.class );
                    it.putExtras( b );
                    startActivity(it);

                }
        );

        btnSalvar.setOnClickListener( e -> salvar() );
        carregarFirebase();
    }

    public void salvarFirebase( Restaurante r ) {
        String jsonRestaurante = gson.toJson(r);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(jsonRestaurante, JSON);
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                Log.e(APP_RESTAURANTE, "Resposta: " + response.body().string());
            } catch (IOException e) {
                Log.e(APP_RESTAURANTE, "Erro: ", e);
                throw new RuntimeException(e);
            }

            handler.post(() -> {

            });
        });
    }

    private Restaurante gerarEntidade() {
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
        return r;
    }

    private void salvar() {
        Restaurante r = gerarEntidade();
        restaurantes.add( r );
        salvarFirebase(r);
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

    private void carregarFirebase() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            restaurantes.clear();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(URL)
                    .get()
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String resposta = response.body().string();
                JsonObject convertedObject =
                        gson.fromJson(resposta, JsonObject.class);
                for (String chave : convertedObject.keySet()) {
                    JsonObject obj = convertedObject.getAsJsonObject(chave);
                    Restaurante r = gson.fromJson(obj, Restaurante.class);
                    r.setChave(chave);
                    restaurantes.add(r);
                }
                Log.e(APP_RESTAURANTE, "Resposta: " + resposta);
            } catch (IOException e) {
                Log.e(APP_RESTAURANTE, "Erro: ", e);
                throw new RuntimeException(e);
            }
        });
    }

}
