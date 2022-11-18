/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Blob;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Jan
 */
public class Usuario {

    private int ID_Usuario;
    private String Nombre;
    private String ApePaterno;
    private String ApeMaterno;
    private String FecNacimiento;
    private String Email;
    private String UserName;
    private String Contrasena;
    private String UserImagen;
    private int Activo;
    private String FechaDeCreacion;
    private String FechaDeCambio;

    public Usuario(int ID_Usuario, String Nombre, String ApePaterno, String ApeMaterno, String FecNacimiento, String Email, String UserName, String Contrasena, String UserImagen, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.ID_Usuario = ID_Usuario;
        this.Nombre = Nombre;
        this.ApePaterno = ApePaterno;
        this.ApeMaterno = ApeMaterno;
        this.FecNacimiento = FecNacimiento;
        this.Email = Email;
        this.UserName = UserName;
        this.Contrasena = Contrasena;
        this.UserImagen = UserImagen;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public Usuario(String Nombre, String ApePaterno, String ApeMaterno, String FecNacimiento, String Email, String UserName, String Contrasena, String UserImagen, int Activo, String FechaDeCreacion, String FechaDeCambio) {
        this.Nombre = Nombre;
        this.ApePaterno = ApePaterno;
        this.ApeMaterno = ApeMaterno;
        this.FecNacimiento = FecNacimiento;
        this.Email = Email;
        this.UserName = UserName;
        this.Contrasena = Contrasena;
        this.UserImagen = UserImagen;
        this.Activo = Activo;
        this.FechaDeCreacion = FechaDeCreacion;
        this.FechaDeCambio = FechaDeCambio;
    }

    public Usuario(int ID_Usuario, String Nombre, String userName, String Contrasena) {
        this.ID_Usuario = ID_Usuario;
        this.Nombre = Nombre;
        this.UserName = userName;
        this.Contrasena = Contrasena;
    }

    public Usuario(String userName, String Contrasena) {
        this.UserName = userName;
        this.Contrasena = Contrasena;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String ApePaterno) {
        this.ApePaterno = ApePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String ApeMaterno) {
        this.ApeMaterno = ApeMaterno;
    }

    public String getFecNacimiento() {
        return FecNacimiento;
    }

    public void setFecNacimiento(String FecNacimiento) {
        this.FecNacimiento = FecNacimiento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getUserImagen() {
        return UserImagen;
    }

    public void setUserImagen(String UserImagen) {
        this.UserImagen = UserImagen;
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
