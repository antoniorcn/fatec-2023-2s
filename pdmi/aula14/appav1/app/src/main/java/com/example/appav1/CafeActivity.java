package com.example.appav1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CafeActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://aula14-backend.antoniocarval11.repl.co";
    private static final String APP_CAFE = "APP_CAFE";
    List<Cafe> lista = new ArrayList<>();

    EditText txtNome; // variavel de instancia
    EditText txtBase;
    EditText txtPreco;

    Button btnSalvar;
    Button btnPesquisar;
    Button btnCreditos;

    private AppSingleton contexto = AppSingleton.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_activity_layout);

        txtNome = findViewById(R.id.txtNome);
        txtBase = findViewById(R.id.txtBase);
        txtPreco = findViewById(R.id.txtPreco);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
        btnCreditos = findViewById(R.id.btnCreditos);

        btnSalvar.setOnClickListener( e -> salvar());
        btnPesquisar.setOnClickListener( e -> procurar());
        btnCreditos.setOnClickListener( e-> {
            Log.i("AppCafe", "Antonio Rodrigues Carvalho Neto");
        });

        Log.i(APP_CAFE, "TOKEN PELA CAFE ACTIVITY: " + (String) contexto.getAttribute("TOKEN"));
    }

    private void salvar() {
        Cafe c = new Cafe();
        c.setNome( txtNome.getText().toString() );
        c.setBase( txtBase.getText().toString() );
        double d = Double.parseDouble( txtPreco.getText().toString() );
        c.setPreco( d );
        lista.add(c);
        salvarAPI(c);
    }

    private void mostrarCafe( Cafe c ) {
        txtNome.setText(c.getNome());
        txtBase.setText(c.getBase());
        String d = String.valueOf(c.getPreco());
        txtPreco.setText(d);
    }

    private void procurar() {
        for(int i = 0; i < lista.size(); i++ ) {
            Cafe c = lista.get(i);
            if (c.getNome().contains(txtNome.getText())) {
                mostrarCafe( c );
            }
        }
    }

    public void salvarAPI(Cafe c) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            Log.i(APP_CAFE, "Excutando request");
            OkHttpClient client = new OkHttpClient();
            Gson gson = new Gson();
            String cafeJson = gson.toJson(c);
            Log.i(APP_CAFE, "JSON Body: " + cafeJson);
            RequestBody body = RequestBody.create(cafeJson,
                    MediaType.get("application/json"));
            Request request = new Request.Builder()
                    .post(body)
                    .header("Bearer ", "")
                    .url(BASE_URL + "/cafe")
                    .build();
            Call call = client.newCall(request);
            Log.i(APP_CAFE, "Resquest feito no servidor");
            try {
                Response response = call.execute();
            } catch (IOException e) {
                Log.e(APP_CAFE, "Erro", e);
                throw new RuntimeException(e);
            }
        });

    }
}
