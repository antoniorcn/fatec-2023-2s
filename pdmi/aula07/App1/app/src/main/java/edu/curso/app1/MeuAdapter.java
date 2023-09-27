package edu.curso.app1;

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
    private Context context;
    private LayoutInflater inflater;

    public MeuAdapter(Context context, List<Contato> contatos) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.lista = contatos;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contato_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contato c = lista.get(position);
        holder.txtNome.setText( c.nome );
        holder.txtTelefone.setText( c.telefone );
        holder.txtEmail.setText( c.email );
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
