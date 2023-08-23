package edu.curso.agendadecontatos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_contato_layout);
        Button btn = findViewById(R.id.button);
        EditText txtNome = findViewById(R.id.editTextNome);
        EditText txtEmail = findViewById(R.id.editTextEmail);
        EditText txtPhone = findViewById(R.id.editTextPhone);

        btn.setOnClickListener( e -> {
            Log.i("AgendaContato", "Nome Completo: " + txtNome.getText());
            Log.i("AgendaContato", "Email: " + txtEmail.getText());
            Log.i("AgendaContato", "Teleofne: " + txtPhone.getText());

        });
    }
}
