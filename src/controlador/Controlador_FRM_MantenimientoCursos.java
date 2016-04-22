     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
    public MetodosCursos metodosCursos;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_mantenimientoCursos)
    {
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        metodosCursos=new MetodosCursos();
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            metodosCursos.agregarCurso(frm_mantenimientoCursos.devolverInformacion());
            frm_mantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_mantenimientoCursos.resetearGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            metodosCursos.modificarCurso(frm_mantenimientoCursos.devolverInformacion());
            frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();     
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            metodosCursos.eliminarCurso(frm_mantenimientoCursos.devolverInformacion());
            frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();
        }
    
    }
    public void buscar()
    {
        if(metodosCursos.consultarCurso(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_mantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_mantenimientoCursos.habilitarAgregar();
            }
    
    }
    
    public void guardarEnArchivo()
    {
        metodosCursos.guardarEnArchivo();
    }

    

    
}
