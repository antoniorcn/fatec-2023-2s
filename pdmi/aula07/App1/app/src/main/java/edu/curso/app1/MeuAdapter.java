package edu.curso.app1;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MeuAdapter extends
        RecyclerView.Adapter<MeuAdapter.ViewHolder>{

    private List<Contato> lista = new ArrayList<>();

    public MeuAdapter() {
        Contato c1 = new Contato();
        c1.nome = "Joao Silva";
        c1.telefone = "(11) 1111-1111";
        c1.email = "joao@teste.com";

        Contato c2 = new Contato();
        c2.nome = "Maria Silva";
        c2.telefone = "(11) 2222-2222";
        c2.email = "maria@teste.com";

        lista.add(c1);
        lista.add(c2);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
