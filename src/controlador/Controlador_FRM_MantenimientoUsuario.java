/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosUsuario;
import vista.FRM_MantenimientoUsuario;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author Jaki
 */
public class Controlador_FRM_MantenimientoUsuario implements ActionListener
{
    FRM_MantenimientoUsuario frm_usuario;
    MetodosUsuario metodosUsuario;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    
    public Controlador_FRM_MantenimientoUsuario(FRM_MantenimientoUsuario frm_usuario, FRM_VentanaPrincipal frm_VentanaPrincipal) 
    {
        this.frm_usuario=frm_usuario;
        metodosUsuario = new  MetodosUsuario();
        this.frm_VentanaPrincipal = frm_VentanaPrincipal;
    }
    
    public void actionPerformed (ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            String arreglo[] = frm_usuario.devolverInformacion();
            
            if(arreglo[3].equals(arreglo[4]))
            {
                metodosUsuario.agregarEstudiante(frm_usuario.devolverInformacion());
                frm_usuario.mostrarMensaje("El Usuario fue registrado de forma correcta");
                frm_usuario.resetearGUI();
                metodosUsuario.guardarEnArchivo();
                frm_usuario.setVisible(false);
                frm_VentanaPrincipal.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            }
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            metodosUsuario.modificarUsuario(frm_usuario.devolverInformacion());
            frm_usuario.mostrarMensaje("El Usuario fue modificado de forma correcta.");
            frm_usuario.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodosUsuario.eliminarEstudiante(frm_usuario.devolverInformacion());
            frm_usuario.mostrarMensaje("El Usuario fue eliminado de forma correcta.");
            frm_usuario.resetearGUI();
        }
    }
    public void buscar()
    {
        if(metodosUsuario.consultarEstudiante(frm_usuario.devolverCedula()))
            {
                frm_usuario.mostrarInformacion(metodosUsuario.getArregloInformacion());
                frm_usuario.habilitarEdicion();
            }
            else
            {
                frm_usuario.mostrarMensaje("La cédula buscada no se encuentra.");
                frm_usuario.habilitarAgregar();
            }
        
    }
    
    
        
     public void guardarEnArchivo()
    {
        metodosUsuario.guardarEnArchivo();
    }
        
    
    
}
