package edu.papprecursos.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText etDocumento;
    private EditText etUsuario;
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etContra;
    private ListView listaUsuarios;
    int documento;
    String usuario;
    String nombres;
    String apellidos;
    String contra;
    Button volver;

    private GestionBD gestionBD;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        volver();
        inicializador();
    }
    public void accionRegistrar(View view){
        asignarDatos();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this,view);
        Usuario usuario = new Usuario();
        usuario.setNombres(this.nombres);
        usuario.setApellidos(this.apellidos);
        usuario.setContra(this.contra);
        usuario.setDocumento(this.documento);
        usuario.setUsuario(this.usuario);
        usuarioDAO.insert(usuario);
    }

    public void volver(){
        volver = (Button)findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gastos = new Intent(Register.this, MainActivity.class);
                startActivity(gastos);
            }
        });
    }

    private void inicializador(){
        etDocumento = findViewById(R.id.ET_documento);
        etUsuario = findViewById(R.id.ET_Usuario);
        etNombres = findViewById(R.id.ET_Nombres);
        etApellidos = findViewById(R.id.ET_apellidos);
        etContra = findViewById(R.id.ET_CONTRA);
        listaUsuarios = (ListView) findViewById(R.id.LV_lista);
    }
    private void asignarDatos(){
        documento = Integer.parseInt(etDocumento.getText().toString());
        usuario = etUsuario.getText().toString();
        nombres = etNombres.getText().toString();
        apellidos = etApellidos.getText().toString();
        contra = etContra.getText().toString();
    }
}
