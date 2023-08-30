package com.example.testeobserver;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class Teste implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Log.i("TesteObserver", "Ola Mundo");
    }
}

public class TesteObserverActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste_layout);

        Button btn = findViewById(R.id.button);
        Teste t = new Teste();
        // btn.setOnClickListener( t );
        btn.setOnClickListener( e -> {
            Log.i("TesteObserver", "Ola mundo ...");
        });


    }
}
