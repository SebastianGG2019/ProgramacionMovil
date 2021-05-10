package edu.papprecursos.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Gastos extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

        String[] categorias = {"Elija la categoria:", "COMIDA", "TRANSPORTE", "HOBBIES", "RECIBOS", "OTROS"};
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);
        Spinner cat = (Spinner) findViewById(R.id.spinner);
        cat.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categorias);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat.setAdapter(aa);
        }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),categorias[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}