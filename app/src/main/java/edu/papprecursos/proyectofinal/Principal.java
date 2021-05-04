package edu.papprecursos.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        taskBegin();
    }

    private void taskBegin(){
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Principal.this, MainActivity.class);
                startActivity(intent);
                finish();
                }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea,3000);
    }


}