package edu.papprecursos.proyectofinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;

public class UsuarioDAO {
    private GestionBD gestionBD;
    Context context;
    View view;
    Usuario usuario;
    public UsuarioDAO(Context context, View view) {
        this.context = context;
        this.view = view;
        gestionBD = new GestionBD(this.context);
    }
    public int LogIn(String u, String p){
        SQLiteDatabase db = gestionBD.getReadableDatabase();
        int a = 0;
        String query = "SELECT * FROM usuarios";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                if (cursor.getString(1).equals(u)&& cursor.getString(2).equals(p)){
                    a++;
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return a;
    }
    public void insert(Usuario usuario){
        try{
            SQLiteDatabase db = gestionBD.getWritableDatabase();
            if(db != null){
                ContentValues values = new ContentValues();
                values.put("USU_DOCUMENTO", usuario.getDocumento());
                values.put("USU_USUARIO", usuario.getUsuario());
                values.put("USU_NOMBRES", usuario.getNombres());
                values.put("USU_APELLLIDOS", usuario.getApellidos());
                values.put("USU_CONTRA", usuario.getContra());
                long codigo = db.insert("usuarios", null,values);
                Snackbar.make(this.view,"Se ha registrado el usuario ", Snackbar.LENGTH_LONG).show();
            }
        }catch (Exception sqlException){
            Log.i("ERROR",""+sqlException);
        }
    }

    public ArrayList<Usuario> getUsuario(){
        SQLiteDatabase db = gestionBD.getReadableDatabase();
        String query = "select * from usuarios";
        ArrayList<Usuario> usuarioArrayList = new ArrayList<Usuario>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                usuario = new Usuario();
                usuario.setDocumento(cursor.getInt(0));
                usuario.setUsuario(cursor.getString(1));
                usuario.setNombres(cursor.getString(2));
                usuario.setApellidos(cursor.getString(3));
                usuario.setContra(cursor.getString(4));
                usuarioArrayList.add(usuario);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return usuarioArrayList;
    }
}
