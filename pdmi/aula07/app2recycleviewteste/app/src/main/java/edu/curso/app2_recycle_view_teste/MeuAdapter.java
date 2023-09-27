package edu.curso.app2_recycle_view_teste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MeuAdapter extends
        RecyclerView.Adapter<MeuAdapter.ViewHolder>{

    private List<Contato> lista = new ArrayList<>();
    private LayoutInflater mInflater;

    public MeuAdapter(Context context) {
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

        this.mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contato_item_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contato c = lista.get(position);
        holder.txtTelefone.setText(c.telefone);
        holder.txtEmail.setText(c.email);
        holder.txtNome.setText(c.nome);
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome;
        TextView txtEmail;
        TextView txtTelefone;
        public ViewHolder(View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtTelefone = itemView.findViewById(R.id.txtTelefone);
        }
    }

}
