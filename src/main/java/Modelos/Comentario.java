/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Jan
 */
public class Comentario {
    
    private int ID_Comentario;
    private String Texto;
    private int Spoiler;
    private int ID_Usuario;
    private int ID_Publicacion;
    private int Activo;
    private String FechaDeCreacion;
    private String FechaDeCambio;

    public Comentario(int ID_Comentario, String Texto, int Spoiler, int ID_Usuario, int ID_Publicacion, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.ID_Comentario = ID_Comentario;
        this.Texto = Texto;
        this.Spoiler = Spoiler;
        this.ID_Usuario = ID_Usuario;
        this.ID_Publicacion = ID_Publicacion;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public Comentario(String Texto, int Spoiler, int ID_Usuario, int ID_Publicacion, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.Texto = Texto;
        this.Spoiler = Spoiler;
        this.ID_Usuario = ID_Usuario;
        this.ID_Publicacion = ID_Publicacion;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public int getID_Comentario() {
        return ID_Comentario;
    }

    public void setID_Comentario(int ID_Comentario) {
        this.ID_Comentario = ID_Comentario;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public int getSpoiler() {
        return Spoiler;
    }

    public void setSpoiler(int Spoiler) {
        this.Spoiler = Spoiler;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public int getID_Publicacion() {
        return ID_Publicacion;
    }

    public void setID_Publicacion(int ID_Publicacion) {
        this.ID_Publicacion = ID_Publicacion;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public String getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public void setFechaDeCreacion(String FechaDeCreacion) {
        this.FechaDeCreacion = FechaDeCreacion;
    }

    public String getFechaDeCambio() {
        return FechaDeCambio;
    }

    public void setFechaDeCambio(String FechaDeCambio) {
        this.FechaDeCambio = FechaDeCambio;
    }
    
    
    
}
