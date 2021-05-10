package edu.papprecursos.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Home  extends AppCompatActivity {

    Button gastos;
    Button calendario;
    Button tipsfinan;
    Button ingresos;

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

        calendario = (Button)findViewById(R.id.btnCalendario);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendario = new Intent(Home.this, CalendarioActivity.class);
                startActivity(calendario);
            }
        });

         tipsfinan = (Button) findViewById(R.id.btnTipsFinan);
         tipsfinan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent tipsfinan =  new Intent(Home.this, TipsFinan.class);
                 startActivity(tipsfinan);
             }
         });
        ingresos = (Button) findViewById(R.id.btnIngresos);
        ingresos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tipsfinan =  new Intent(Home.this, ingresos.class);
                startActivity(tipsfinan);
            }
        });
    }


}
