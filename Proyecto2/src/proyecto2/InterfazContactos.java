
package proyecto2;

import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class InterfazContactos {
     MantieneContactos mC=new MantieneContactos("Agenda.txt");
    
    public GridPane getAgregarInterfaz(){
        GridPane gP_agregar = new GridPane();
        gP_agregar.setVgap(10);
        gP_agregar.setHgap(5);
        
        Label lB_nombre = new Label("Nombre");
        gP_agregar.add(lB_nombre, 0, 0);
        
        TextField tF_nombre = new TextField(); //agregar nombre del contacto
        gP_agregar.add(tF_nombre, 1, 0);
        
        Label lB_apellidos = new Label("Apellidos");
        gP_agregar.add(lB_apellidos, 0, 1);
        
        TextField tF_apellido = new TextField(); //agregar apellidos del contacto
        gP_agregar.add(tF_apellido, 1, 1);
        
        Label lB_FechaNacimiento= new Label("Selecione su fecha de nacimiento");
        gP_agregar.add(lB_FechaNacimiento, 0, 2);
       
        DatePicker dP_Fecha= new DatePicker();//Seleccionar fecha de nacimiento
        gP_agregar.add(dP_Fecha, 1, 2);
        
        Label lB_teléfono = new Label("Teléfono");
        gP_agregar.add(lB_teléfono, 0, 3);
        
        TextField tF_telefono = new TextField(); //agregar teléfono del contacto
        gP_agregar.add(tF_telefono, 1, 3);
        
        Label lB_direccion = new Label("Dirección");
        gP_agregar.add(lB_direccion, 0, 4);
        
        TextField tF_dirección = new TextField(); //agregar dirección del contacto
        gP_agregar.add(tF_dirección, 1, 4);
        
        Label lB_correo = new Label("Correo electrónico");
        gP_agregar.add(lB_correo, 0, 5);
        
        TextField tF_correo = new TextField(); //agregar correo electrónico del contacto
        gP_agregar.add(tF_correo, 1, 5);
        
        
        Button btn_agregar= new Button(" ", new ImageView(new Image("add-circular-button.png")));
        gP_agregar.add(btn_agregar, 0, 8);
        btn_agregar.setOnAction((event)->{
            String nombreInsertado = tF_nombre.getText();
            String apellidosInsertados = tF_apellido.getText();
            LocalDate fechaSeleccionada = dP_Fecha.getValue();
            String telefonoInsertado= tF_telefono.getText();
            String direcciónIngresada=tF_dirección.getText();
            String correoIngresado=tF_correo.getText(); 
           
            tF_nombre.setText(" ");
            tF_apellido.setText(" ");
            tF_telefono.setText(" ");
            tF_dirección.setText(" ");
            tF_correo.setText(" ");
            dP_Fecha.getEditor().clear();
            
            mC.insertarContacto(nombreInsertado, apellidosInsertados, ""+fechaSeleccionada, ""+telefonoInsertado, ""+direcciónIngresada, ""+correoIngresado);
        });
        
        return gP_agregar;
    }
}
