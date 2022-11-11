/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Jan
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private Date fecNacimiento;
    private String email;
    private String username;
    private String contrasena;
    private Blob userImage;
    private int activo;
    private Date fechaDeCreacion;
    private Date fechaDeCambio;

    public Usuario(int idUsuario, String nombre, String apePaterno, String apeMaterno, Date fecNacimiento, String email, String username, String contrasena, Blob userImage, int activo, Date fechaDeCreacion, Date fechaDeCambio) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fecNacimiento = fecNacimiento;
        this.email = email;
        this.username = username;
        this.contrasena = contrasena;
        this.userImage = userImage;
        this.activo = activo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeCambio = fechaDeCambio;
    }

    public Usuario(String nombre, String apePaterno, String apeMaterno, Date fecNacimiento, String email, String username, String contrasena, Blob userImage, int activo, Date fechaDeCreacion, Date fechaDeCambio) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fecNacimiento = fecNacimiento;
        this.email = email;
        this.username = username;
        this.contrasena = contrasena;
        this.userImage = userImage;
        this.activo = activo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeCambio = fechaDeCambio;
    }

    public Usuario(String nombre, String apePaterno, String apeMaterno, Date fecNacimiento, String email, String username, String contrasena, Date fechaDeCreacion) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fecNacimiento = fecNacimiento;
        this.email = email;
        this.username = username;
        this.contrasena = contrasena;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Blob getUserImage() {
        return userImage;
    }

    public void setUserImage(Blob userImage) {
        this.userImage = userImage;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Date getFechaDeCambio() {
        return fechaDeCambio;
    }

    public void setFechaDeCambio(Date fechaDeCambio) {
        this.fechaDeCambio = fechaDeCambio;
    }

}
