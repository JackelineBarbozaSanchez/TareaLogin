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
public class ArchivosCursos {
     ObjectOutputStream archivoSalida;
    ObjectInputStream  archivoEntrada;
    
   
    public void crearArchivo()
    {
        try
        {
            archivoSalida= new ObjectOutputStream(new FileOutputStream("cursos.dat "));
                        System.out.println("Archvo Creado");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
        }
    
    public void escribirInformacionEnElAlcihvio(Cursos curso )
   {
       try
        {
            archivoSalida.writeObject(curso);
                        System.out.println("Se escribio la informacin de forma correta");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
   
       
      
       
   }//fin de lemar info
    
     
     
     public ArrayList<Cursos> leerInfoCompleta()
     {
         ArrayList<Cursos> arrayPersonas= new ArrayList <Cursos>();
         
          try 
           {
               archivoEntrada = new ObjectInputStream(new FileInputStream("cursos.dat "));
              while (true)
              {
               arrayPersonas.add((Cursos)archivoEntrada.readObject());
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
             archivoEntrada = new ObjectInputStream(new FileInputStream("cursos.dat "));
             existe= true;
         }
         catch(Exception e)
         {
             System.out.println("No se encontro el archivo");
         }
         return existe;
     }
    
}
