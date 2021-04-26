package edu.papprecursos.proyectofinal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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
    private GestionBD gestionBD;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

    public void listaUsuario(View view){
        UsuarioDAO  usuarioDAO = new UsuarioDAO(this, listaUsuarios);
        ArrayList<Usuario> usuarioArrayList = usuarioDAO.getUsuario();
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,usuarioArrayList);
        listaUsuarios.setAdapter(adapter);
        Toast.makeText(this,""+usuarioArrayList.size(),Toast.LENGTH_SHORT).show();
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
