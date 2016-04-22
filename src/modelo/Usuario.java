/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Jaki
 */
public class Usuario implements Serializable{
     private String cedula;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contreseña;
    private String tipo;

   

    public Usuario(String cedula, String nombreCompleto, String nombreUsuario, String contreseña,String tipo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contreseña = contreseña;
        this.tipo= tipo;
    }
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContreseña() {
        return contreseña;
    }

    public void setContreseña(String contreseña) {
        this.contreseña = contreseña;
    }
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getInformacion()
    {
        return "La cedula es"+cedula+"El Nombre Completo es"+nombreCompleto+"EL nombre de usuario "+nombreUsuario+"La contraceña es "+contreseña+"El tipo es "+tipo;
    }
    
}
