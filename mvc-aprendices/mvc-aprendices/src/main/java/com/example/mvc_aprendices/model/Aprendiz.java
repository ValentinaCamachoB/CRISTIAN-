package com.example.mvc_aprendices.model;

public class Aprendiz {
 
    private int id;
    private String nombre;
    private String correo;
    private String ficha;
    private String programa;
    private String estado; // ACTIVO o INACTIVO
 
    // Constructor vacío  para formularios
    public Aprendiz() {}
 
    public Aprendiz(int id, String nombre, String correo, String ficha,
                    String programa, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ficha = ficha;
        this.programa = programa;
        this.estado = estado;
    }
 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
 
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
 
    public String getFicha() { return ficha; }
    public void setFicha(String ficha) { this.ficha = ficha; }
 
    public String getPrograma() { return programa; }
    public void setPrograma(String programa) { this.programa = programa; }
 
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
 
    /**
     * Regla del negocio: valida si el aprendiz está activo.
     * Esta lógica vive en el MODELO, no en el controlador ni en la vista.
     */
    public boolean estaActivo() {
        return "ACTIVO".equalsIgnoreCase(this.estado);
    }
 
    @Override
    public String toString() {
        return "Aprendiz{id=" + id + ", nombre=" + nombre + ", ficha=" + ficha + "}";
    }
}
