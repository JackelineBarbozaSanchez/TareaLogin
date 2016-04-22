/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaki
 */
public class MetodosUsuario {
   
     private ArrayList <Usuario> arrayUsuario;
    
    String arregloInformacionConsultada[]=new String[5];
    ArchivoUsuario archivos;
    
    public MetodosUsuario()
    {
        arrayUsuario=new ArrayList <Usuario>();
        //agregarEstudiante(new String []{"123","jaki","la mencha"}); 
        archivos = new ArchivoUsuario();
       // existeArchivo();
       cargardatosArchivo();
    }
    public void cargardatosArchivo()
    {
        arrayUsuario = archivos.leerInfoCompleta(); 
    }
    
    public boolean existeArchivo()
    {
        return archivos.existeArchivo();
    }
    public void guardarEnArchivo()
    {
        archivos.crearArchivo();
        
        for (int contador=0; contador<arrayUsuario.size(); contador++)
        {
            
            archivos.escribirInformacionEnElAlcihvio(arrayUsuario.get(contador));
        }
        System.out.println("Se guardaron los datos en el Archivo");
    }
    public void agregarEstudiante(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0], informacion[1], informacion[2],informacion[3],informacion[5]);
        arrayUsuario.add(temporal);
        
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            System.out.println(arrayUsuario.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayUsuario.get(contador).getCedula();
                arregloInformacionConsultada[1]=arrayUsuario.get(contador).getNombreCompleto();
                arregloInformacionConsultada[2]=arrayUsuario.get(contador).getNombreUsuario();
                arregloInformacionConsultada[3]=arrayUsuario.get(contador).getContreseña();
                arregloInformacionConsultada[4]=arrayUsuario.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
    
    public boolean consultarlogin(String usuario, String contrasenia)      
    {
        boolean existe= false;
        for(int i=0;i<arrayUsuario.size();i++)
        {
            if(arrayUsuario.get(i).getNombreUsuario().equals(usuario)&& arrayUsuario.get(i).getContreseña().equals(contrasenia))
            {
                existe=true;
            }
        }
        return existe;
    }
    
    public void modificarUsuario(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayUsuario.get(contador).setCedula(arreglo[0]);
                arrayUsuario.get(contador).setNombreCompleto(arreglo[1]);
                arrayUsuario.get(contador).setNombreUsuario(arreglo[2]);
                arrayUsuario.get(contador).setContreseña(arreglo[3]);
                arrayUsuario.get(contador).setTipo(arreglo[4]);

            }
        }
    }
    public void eliminarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayUsuario.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    public boolean compararContraseña(String contraseña)
    {
        boolean estan= false; 
         for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getContreseña().equals(contraseña))
            {
                JOptionPane.showMessageDialog(null,"Las contraseñas coinciden ");
                estan= true;
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Las contraseñas  no coinciden ");
            }
        }
         return estan;
    }
    
    
}
