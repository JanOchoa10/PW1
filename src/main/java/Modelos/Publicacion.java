/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Jan
 */
public class Publicacion {
    
    private int ID_Publicacion;
    private String Texto;
    private String Imagen;
    private int Spoiler;
    private int ID_Usuario;
    private int Activo;
    private String FechaDeCreacion;
    private String FechaDeCambio;

    public Publicacion(int ID_Publicacion, String Texto, String Imagen, int Spoiler, int ID_Usuario, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.ID_Publicacion = ID_Publicacion;
        this.Texto = Texto;
        this.Imagen = Imagen;
        this.Spoiler = Spoiler;
        this.ID_Usuario = ID_Usuario;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public Publicacion(String Texto, String Imagen, int Spoiler, int ID_Usuario, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.Texto = Texto;
        this.Imagen = Imagen;
        this.Spoiler = Spoiler;
        this.ID_Usuario = ID_Usuario;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public int getID_Publicacion() {
        return ID_Publicacion;
    }

    public void setID_Publicacion(int ID_Publicacion) {
        this.ID_Publicacion = ID_Publicacion;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
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