package com.example.apprestaurante2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestauranteListaActivity extends AppCompatActivity implements RestauranteRecycleViewAdapter.ItemClickListener {
    RestauranteRecycleViewAdapter adapter;

    private Button btnCadastrar;

    private List<Restaurante> restaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_listar_layout);

        Bundle b = getIntent().getExtras();
        restaurantes = (List<Restaurante>) b.getSerializable("RESTAURANTES");

        btnCadastrar = findViewById(R.id.btnVoltarCadastro);
        btnCadastrar.setOnClickListener( e -> {
            Intent it = new Intent(this, RestauranteDetalhesActivity.class);
            startActivity(it);
        });

        RecyclerView recyclerView = findViewById(R.id.restauranteListaRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RestauranteRecycleViewAdapter(this, restaurantes, this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void removeSingleItem(int removeIndex) {
        restaurantes.remove(removeIndex);
        adapter.notifyItemRemoved(removeIndex);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(view.getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
