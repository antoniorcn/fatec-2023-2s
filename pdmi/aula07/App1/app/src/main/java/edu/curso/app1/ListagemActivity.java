package edu.curso.app1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListagemActivity extends AppCompatActivity {

    MeuAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_layout);

        RecyclerView recyclerView = findViewById(R.id.recycleViewListagem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MeuAdapter(this);
        recyclerView.setAdapter(adapter);
    }

}
