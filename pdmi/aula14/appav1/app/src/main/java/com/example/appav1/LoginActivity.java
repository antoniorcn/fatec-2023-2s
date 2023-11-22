package com.example.appav1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String APP_CAFE = "APP_CAFE";
    private static final String BASE_URL = "https://aula14-backend.antoniocarval11.repl.co";
    private Button btnLogin;

    private EditText txtUser;

    private EditText txtPass;

    private AppSingleton contexto = AppSingleton.getInstance();

    class Resposta {
        public String message;
        public String token;
    }

    class DadosLogin {
        public String username = "";
        public String password = "";

        public DadosLogin(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btnLogin = findViewById(R.id.btnLogin);
        txtUser = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtSenha);
        btnLogin.setOnClickListener(e -> {

            ExecutorService executor = Executors.newSingleThreadExecutor();
            // Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Log.i(APP_CAFE, "Excutando request login");
                DadosLogin user = new DadosLogin(txtUser.getText().toString(),
                        txtPass.getText().toString());
                OkHttpClient client = new OkHttpClient();
                Gson gson = new Gson();
                String loginJson = gson.toJson(user);
                Log.i(APP_CAFE, "JSON Body: " + loginJson);
                RequestBody body = RequestBody.create(loginJson,
                        MediaType.get("application/json"));
                Request request = new Request.Builder()
                        .post(body)
                        .url(BASE_URL + "/login")
                        .build();
                Call call = client.newCall(request);
                Log.i(APP_CAFE, "Resquest feito no servidor");
                try {
                    Response response = call.execute();
                    if (response.body() != null) {
                        String strResposta = response.body().string();
                        Log.i(APP_CAFE, "Resposta");
                        Log.i(APP_CAFE, strResposta);
                        Resposta resposta = gson.fromJson(strResposta, Resposta.class);
                        Log.i(APP_CAFE, resposta.message);
                        Log.i(APP_CAFE, resposta.token);
                        contexto.addAttribute("TOKEN", resposta.token);
                        Intent intent=new Intent(getApplicationContext(), CafeActivity.class);
                        startActivity(intent);
                    } else {
                        Log.i(APP_CAFE, "Reposta vazia");
                    }
                } catch (IOException err) {
                    Log.e(APP_CAFE, "Erro", err);
                    throw new RuntimeException(err);
                }
            });
        });
    }
}
