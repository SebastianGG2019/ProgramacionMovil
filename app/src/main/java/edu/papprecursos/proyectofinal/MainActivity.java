package edu.papprecursos.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContra;

    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = (EditText) findViewById(R.id.ET_USUARIOLOGIN);
        etContra = (EditText) findViewById(R.id.ET_CONTRA);
    }
    public void LogIn(View view){
        String User= etUsuario.getText().toString();
        String Contra= etContra.getText().toString();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this,null);
        if (User.equals("") && Contra.equals("")){
            Toast.makeText(this, "CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
        }else if (usuarioDAO.LogIn(User,Contra) == 1){
            Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Usuario.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
    public void registrarButton(View view) {
        Intent i = new Intent(MainActivity.this, Register.class);
        startActivity(i);
    }
}