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
}
