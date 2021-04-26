package edu.papprecursos.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestionBD extends SQLiteOpenHelper {
    private static final String DBUSERS = "dbusuarios";
    private static final int VERSION = 1;
    private static final String TUSUARIOS = "usuarios";

    private static final String CREARTABLA = "CREATE TABLE " + TUSUARIOS +" (USU_DOCUMENTO INTEGER PRIMARY KEY, USU_USUARIO varchar(40) NOT NULL," +
            " USU_NOMBRES varchar(40) NOT NULL, USU_APELLLIDOS varchar(40) NOT NULL, USU_CONTRA varchar(25) NOT NULL )";

    private static final String ELIMINARTABLA = "DROP TABLE IF EXISTS "+ TUSUARIOS;

    public GestionBD(Context context) {
        super(context, DBUSERS, null,  VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREARTABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ELIMINARTABLA);
        onCreate(db);
    }
}
