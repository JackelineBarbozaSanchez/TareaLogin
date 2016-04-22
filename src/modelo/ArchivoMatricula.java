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
public class ArchivoMatricula {
    
         ObjectOutputStream archivoSalida;
    ObjectInputStream  archivoEntrada;
    
   
    public void crearArchivo()
    {
        try
        {
            archivoSalida= new ObjectOutputStream(new FileOutputStream("matricula.dat "));
                        System.out.println("Archvo Creado");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
        }
    
    public void escribirInformacionEnElAlcihvio(Matricula matricula )
   {
       try
        {
            archivoSalida.writeObject(matricula);
                        System.out.println("Se escribio la informacin de forma correta");

        }
        catch (Exception e)
        {
            System.out.println("Error al crear el  Archvo"+e);
        }
   
       
      
       
   }//fin de lemar info
    
     
     
     public ArrayList<Matricula> leerInfoCompleta()
     {
         ArrayList<Matricula> arrayPersonas= new ArrayList <Matricula>();
         
          try 
           {
               archivoEntrada = new ObjectInputStream(new FileInputStream("matricula.dat "));
              while (true)
              {
               arrayPersonas.add((Matricula)archivoEntrada.readObject());
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
             archivoEntrada = new ObjectInputStream(new FileInputStream("matricula.dat "));
             existe= true;
         }
         catch(Exception e)
         {
             System.out.println("No se encontro el archivo");
         }
         return existe;
     }
}
