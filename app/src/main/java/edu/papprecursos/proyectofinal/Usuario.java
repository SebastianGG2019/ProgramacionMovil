package edu.papprecursos.proyectofinal;

import androidx.annotation.NonNull;

public class Usuario {
    private int documento;
    private String usuario;
    private String nombres;
    private String apellidos;
    private String contra;

    public Usuario(int documento, String usuario, String nombres, String apellidos, String contra) {
        this.documento = documento;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contra = contra;
    }
    public Usuario(){

    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @NonNull
    @Override
    public String toString() {
        return "Ducumento"+this.getDocumento() + " NOMBRE: "+this.getNombres();
    }
}
