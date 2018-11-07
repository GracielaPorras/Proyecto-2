
package proyecto2;

import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class InterfazContactos {
     MantieneContactos mC=new MantieneContactos("Agenda.txt");
    
    public VBox getInsertarInterfaz(){
        VBox vB_insertar = new VBox();
        Label lB_nombre = new Label("Nombre");
        Label lB_FechaNacimiento= new Label("Sellecione su fecha de nacimiento");
        
        TextField tF_nombre = new TextField();
        
        DatePicker dP_Fecha= new DatePicker();
        
        Button btn_insertar= new Button(" ", new ImageView(new Image("add-circular-button.png")));
        btn_insertar.setOnAction((event)->{
            String nombreInsertado = tF_nombre.getText();
            LocalDate fechaSeleccionada = dP_Fecha.getValue();
            tF_nombre.setText(" ");
            dP_Fecha.getEditor().clear();
            
            mC.insertarContacto(nombreInsertado, ""+fechaSeleccionada);
        });
        
        vB_insertar.getChildren().addAll(lB_nombre, tF_nombre,lB_FechaNacimiento, dP_Fecha, btn_insertar);
        
        return vB_insertar;
    }
}
