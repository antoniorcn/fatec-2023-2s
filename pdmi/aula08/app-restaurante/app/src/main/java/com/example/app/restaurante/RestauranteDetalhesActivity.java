package com.example.app.restaurante;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestauranteDetalhesActivity extends AppCompatActivity {

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

        btnSalvar.setOnClickListener( e -> {
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
            salvarPrefs();
            mostrarLista();
        });
        carregarPrefs();
    }

    private void pesquisar() {
        String nome = txtNome.getText().toString();

        for (Restaurante r : restaurantes) {
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
            Log.i("APP Restaurante", r.toString());
        }
    }

    private void salvarPrefs() {
        SharedPreferences shared
                = getSharedPreferences("RESTAURANTES", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = gson.toJson(restaurantes);
        shared.edit().putString("LISTA", strLista);
        shared.edit().commit();
    }

    private void carregarPrefs() {
        SharedPreferences shared
                = getSharedPreferences("RESTAURANTES", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String strLista = shared.getString("LISTA","");

        Log.i("APP Restaurante", "JSON Lido: " + strLista);
        Type listType = new TypeToken<ArrayList<Restaurante>>(){}.getType();
        ArrayList<Restaurante> list = gson.fromJson(strLista, listType);
        Log.i("APP Restaurante", "Restaurantes da lista lida no SharedPref");
        for (Restaurante r : list) {
            Log.i("APP Restaurante", r.toString());
        }
    }
}
