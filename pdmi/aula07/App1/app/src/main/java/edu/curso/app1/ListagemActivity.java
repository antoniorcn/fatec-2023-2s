package edu.curso.app1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    MeuAdapter adapter;

    private List<Contato> contatos = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_layout);

        Contato c1 = new Contato();
        c1.nome = "Joao Silva";
        c1.telefone = "(11) 1111-1111";
        c1.email = "joao@teste.com";

        Contato c2 = new Contato();
        c2.nome = "Maria Silva";
        c2.telefone = "(11) 2222-2222";
        c2.email = "maria@teste.com";

        contatos.add(c1);
        contatos.add(c2);


        RecyclerView recyclerView = findViewById(R.id.recycleViewListagem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MeuAdapter(this, contatos);
        recyclerView.setAdapter(adapter);
    }

}
