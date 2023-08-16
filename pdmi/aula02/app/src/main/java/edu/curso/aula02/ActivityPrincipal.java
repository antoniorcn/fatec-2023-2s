package edu.curso.aula02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//class Clique implements View.OnClickListener {
//
//    @Override
//    public void onClick(View view) {
//        Log.i("ActivityPrincipal", "Botão Clicado");
//    }
//}

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ActivityPrincipal", "onCreate executado");
        setContentView(R.layout.activity_principal);
        Log.v("ActivityPrincipal", "Tela Carregada");
        View v = findViewById(R.id.button);
        TextView tv = (TextView) findViewById(R.id.textView);

        if (v instanceof Button) {
            Button b = (Button) v;

//            new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d("ActivityPrincipal", "Botao Clicado - Classe Anonima");
//                }
//            }

//            b.setOnClickListener(
//                    (View view) -> {
//                        Log.d("ActivityPrincipal", "Botão Clicado - Arrow function");
//                    }
//            );

            b.setOnClickListener(
                    view -> {
                        Log.d("ActivityPrincipal",
                                "Botão Clicado - Arrow function simplificado");
                        tv.setText("Antonio Carvalho");
                    }
            );
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ActivityPrincipal", "On Start executado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ActivityPrincipal", "On Resume executado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ActivityPrincipal", "On Pause executado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ActivityPrincipal", "On Stop executado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ActivityPrincipal", "On Destroy executado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ActivityPrincipal", "On Restart executado");
    }
}
