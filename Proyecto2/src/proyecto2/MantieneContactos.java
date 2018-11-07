
package proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;


public class MantieneContactos {
    String nombreArchivo;
    
    public MantieneContactos(String nombreArchivo){
        this.nombreArchivo=nombreArchivo;
    }
    
    public void insertarContacto(String nombreContacto, String fechaNacimiento){
        File archivo= new File(nombreArchivo);
        
        try{
            
        FileOutputStream fos= new FileOutputStream(archivo, true);
        PrintStream ps = new  PrintStream(fos);
        ps.println(nombreContacto+";"+fechaNacimiento);
        }// Fin try
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "Problemas al escribir en el archivo");
        }//Fin catch
    }
}
