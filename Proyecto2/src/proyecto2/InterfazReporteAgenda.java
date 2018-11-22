
package proyecto2;


import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * 
 * @author Alsov
 */
public class InterfazReporteAgenda {

    MantieneContactos mc = new MantieneContactos("Agenda.txt");
    
    // CREACION DEL TABLE VIEW
    public VBox getInterfazAgenda(){
        
        VBox vB_Agenda = new VBox();
        
        Label lB_Agenda = new Label  ("Agenda telefonica");
        lB_Agenda.setFont(new Font ("Broadway", 20));
        
        TableView<Contactos>tV_Contactos = new TableView<>();  // se construye un tableView de contactos
        
        // crear columna Nombre
        
        TableColumn tC_Nombre = new TableColumn ("Nombre contacto"); 
        tC_Nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        
        //crear columna fecha nacimiento
        
        TableColumn tC_FechaNacimiento = new TableColumn("Fecha Nacimento");
        tC_FechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        
        // crear columna edad
        
        TableColumn tC_Edad = new TableColumn("Edad");
        tC_Edad.setCellValueFactory(new PropertyValueFactory("edad"));
        
        // crear columna Apellidos
        
        TableColumn tC_Apellidos = new TableColumn("Apellidos");
        tC_Apellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        
        // crear columna telefono
        
        TableColumn tC_Telefono = new TableColumn("Telefono");
        tC_Telefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        
        // crear columna direccion
        
        TableColumn tC_Direccion = new TableColumn("Direccion");
        tC_Direccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        
        // crear columna correo
        
        TableColumn tC_Correo = new TableColumn("Correo");
        tC_Correo.setCellValueFactory(new PropertyValueFactory("correo"));
        
       ObservableList<Contactos> datos = getListaContactos();
       
       tV_Contactos.setItems(datos);
        
        tV_Contactos.getColumns().addAll(tC_Nombre,tC_Apellidos,tC_FechaNacimiento, tC_Edad, tC_Telefono,tC_Direccion,tC_Correo);
        
        vB_Agenda.getChildren().addAll(lB_Agenda,tV_Contactos);
        
        return vB_Agenda;
    }
    
    public ObservableList<Contactos> getListaContactos (){    // permite crear un arreglo de tipo contactos y poder mostrarlo
        
        ArrayList array = new ArrayList();
        
        Contactos arrayContact [] = mc.leerContactosArchivo();
        
        for (int j=0; j<arrayContact.length;j++){
             
             array.add(arrayContact[j]);
             System.out.println(arrayContact[j].toString());
      
    }
         ObservableList<Contactos> oL_ListadoContactos = FXCollections.observableArrayList(array);
         
     return oL_ListadoContactos;
    }
}