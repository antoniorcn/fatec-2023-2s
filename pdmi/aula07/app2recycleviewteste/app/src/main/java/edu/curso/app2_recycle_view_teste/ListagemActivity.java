package edu.curso.app2_recycle_view_teste;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_layout);

        RecyclerView recyclerView = findViewById(R.id.contatos_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MeuAdapter adapter = new MeuAdapter(this);
        recyclerView.setAdapter(adapter);

    }

}
