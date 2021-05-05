package edu.papprecursos.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Home  extends AppCompatActivity {

    Button gastos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gastos = (Button)findViewById(R.id.btnGastos);
        gastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gastos = new Intent(Home.this, Gastos.class);
                startActivity(gastos);
            }
        });
    }
}
