package edu.papprecursos.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TipsFinan extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finan_tips);
    }
    public void volver(View view) {
        Intent i = new Intent(TipsFinan.this, Home.class);
        startActivity(i);
    }
}
