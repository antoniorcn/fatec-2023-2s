package com.example.apprestaurante2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestauranteRecycleViewAdapter extends RecyclerView.Adapter<RestauranteRecycleViewAdapter.ViewHolder> {
    public static final String APP_RESTAURANTE = "APP Restaurante";
    private List<Restaurante> mData;
    private RestauranteListaActivity activity;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    RestauranteRecycleViewAdapter(Context context, List<Restaurante> data,
                                  RestauranteListaActivity activity) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.restaurante_row, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtRowNome;
        TextView txtRowTipo;
        TextView txtRowClassificacao;

        Button btnApagar;
        Button btnEditar;

        ViewHolder(View itemView) {
            super(itemView);
            txtRowNome = itemView.findViewById(R.id.txtRowNome);
            txtRowTipo = itemView.findViewById(R.id.txtRowTipo);
            txtRowClassificacao = itemView.findViewById(R.id.txtRowClassificacao);
            btnApagar = itemView.findViewById(R.id.btnApagar);
            btnApagar.setOnClickListener( e-> {
                Log.i(APP_RESTAURANTE, "Botão Apagar clicado : " + getAdapterPosition());

                Restaurante r = getItem(getAdapterPosition());

                ExecutorService executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());
                executor.execute(() -> {
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("https://fatec-2023-2s-pdmi-default-rtdb.firebaseio.com" +
                                    "/restaurantes/" + r.getChave() + ".json")
                            .delete()
                            .build();
                    try (Response response = client.newCall(request).execute()) {
                        Log.e(APP_RESTAURANTE, "Resposta: " + response.body().string());
                        activity.removeSingleItem(getAdapterPosition());
                    } catch (IOException err) {
                        Log.e(APP_RESTAURANTE, "Erro: ", err);
                        throw new RuntimeException(err);
                    }
                });
            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.i("Restaurantes", "Linha clicada :" + getAdapterPosition());
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = mData.get(position);
        holder.txtRowNome.setText(r.getNome());
        holder.txtRowTipo.setText(r.getTipo());
        holder.txtRowClassificacao.setText(String.valueOf(r.getClasse()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    Restaurante getItem(int id) {
        return mData.get(id);
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
