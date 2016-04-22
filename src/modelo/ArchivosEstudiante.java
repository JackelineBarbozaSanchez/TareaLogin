/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jaki
 */
public class ArchivosEstudiante {
         ObjectOutputStream archivoSalida;
    ObjectInputStream  archivoEntrada;
    
   
    public void crearArchivo()
    {
        try
        {
            archivoSalida= new ObjectOutputStream(new FileOutputStream("estudiante.dat "));
                        System.out.println("Archvo Creado");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
        }
    
    public void escribirInformacionEnElAlcihvio(Estudiante estudiante )
   {
       try
        {
            archivoSalida.writeObject(estudiante);
                        System.out.println("Se escribio la informacin de forma correta");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
   
       
      
       
   }//fin de lemar info
    
     
     
     public ArrayList<Estudiante> leerInfoCompleta()
     {
         ArrayList<Estudiante> arrayPersonas= new ArrayList <Estudiante>();
         
          try 
           {
               archivoEntrada = new ObjectInputStream(new FileInputStream("estudiante.dat "));
              while (true)
              {
               arrayPersonas.add((Estudiante)archivoEntrada.readObject());
              }//fin de while 
              
           }
           catch (Exception e)
           {
               System.out.println("Fin del Archvo"+e);
           }
            return arrayPersonas;
     }//fin de array  
     
     public boolean existeArchivo()
     {
         boolean existe= false;
                 
         try
         {
             archivoEntrada = new ObjectInputStream(new FileInputStream("estudiante.dat "));
             existe= true;
         }
         catch(Exception e)
         {
             System.out.println("No se encontro el archivo");
         }
         return existe;
     }
    
}
