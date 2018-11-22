package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class MantieneContactos {

    String nombreArchivo;

    public MantieneContactos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void insertarContacto(Contactos c) {
        File archivo = new File(nombreArchivo);

        File Archivo = new File(nombreArchivo);

        try {

            FileOutputStream fos = new FileOutputStream(Archivo, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(c.getNombre() + ";" + c.getApellidos() + ";" + c.getFechaNacimiento() + ";" + c.getEdad() + ";" + c.getTelefono() + ";" + c.getDireccion() + ";" + c.getCorreo() + ";");

        } // fin try
        catch (FileNotFoundException fne) {

            JOptionPane.showMessageDialog(null, "Problemas al escribir en el archivo");

        } // fin catch
    }

    public BufferedReader getBufferReader() {

        File archivo = new File(nombreArchivo);
        BufferedReader br = null;

        try {

            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

        } catch (FileNotFoundException fnfe) {

            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");

        }

        return br;
    }

    public int cuentaRegistrosContactos() {

        int contadorRegistros = 0;
        BufferedReader br = getBufferReader();

        try {

            String registroActual = br.readLine();

            while (registroActual != null) {

                if (registroActual != null) {
                    contadorRegistros++;
                }

                registroActual = br.readLine();

            }

        } // fin try
        catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo, cuentaRegistrosContactos");

        }

        return contadorRegistros;
    }

    public Contactos[] leerContactosArchivo() {

        Contactos arrayContact[] = new Contactos[cuentaRegistrosContactos()];

        int indiceArray = 0;

        BufferedReader br = getBufferReader();

        try {

            String registroActual = br.readLine();

            while (registroActual != null) {

                String nombreContac = "", apellidosContac = "", fechaContac = "", edadContac = "", telefonoContac = "", direccionContac = "", correoContac = "";

                StringTokenizer sT = new StringTokenizer(registroActual, ";");
                int controlaTokens = 1;

                while (sT.hasMoreTokens()) {

                    switch (controlaTokens) {
                        case 1:
                            nombreContac = sT.nextToken();
                            break;
                        case 2:
                            apellidosContac = sT.nextToken();
                            break;
                        case 3:
                            fechaContac = sT.nextToken();
                            break;
                        case 4:
                            edadContac = sT.nextToken();
                            break;
                        case 5:
                            telefonoContac = sT.nextToken();
                            break;
                        case 6:
                            direccionContac = sT.nextToken();
                            break;
                        case 7:
                            correoContac = sT.nextToken();
                            break;
                    }

                    controlaTokens++;
                }
                System.out.println(nombreContac+apellidosContac+fechaContac+ edadContac+ telefonoContac+ direccionContac+ correoContac);

                Contactos c = new Contactos(nombreContac, apellidosContac, fechaContac, edadContac, telefonoContac, direccionContac, correoContac);
                arrayContact[indiceArray] = c;
                indiceArray++;
                registroActual = br.readLine();

            }

        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo, leerContactosArchivo ");
        }

        return arrayContact;
    }

    public boolean verificaCorreo(String correo) {

        boolean arroba = false;

        for (int i = 0; i < correo.length(); i++) {
            if (correo.charAt(i) == '@') { // los datos de tipo Char van entre comillas simples
                arroba = true;
            }
        }

        return arroba;
    }

    public String buscarContacto(String nombreContac) {

        BufferedReader br = getBufferReader();

        try {

            String registroActual = br.readLine();

            String nombreBuscar = "";
            while (registroActual != null) {

                StringTokenizer sT = new StringTokenizer(registroActual, ";");
                int controlaTokens = 1;

                while (sT.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        nombreBuscar = sT.nextToken();
                    }

                }
                controlaTokens++;

                if (nombreBuscar.equalsIgnoreCase(nombreContac)) {
                    
                    
                    
                }

            }

        } // fin try
        catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo, cuentaRegistrosContactos");

        }

        return nombreContac;
    }

   
}
