/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Alsov
 */
public class InterfazCreditosYAcercaDe {

    public VBox getInterfazCreditos (){
        
        VBox vB_Creditos = new VBox();
        
        TextArea tA_Creditos = new TextArea();
        tA_Creditos.setEditable(false);
        tA_Creditos.setText("Realizado por: Allen Solano \nEjemplo uso de menu \nVersion 1.0");
        
        vB_Creditos.getChildren().addAll(tA_Creditos);
        
        return vB_Creditos;
    }
    
    public VBox getInterfazAcercaDe (){
        
        VBox vB_AcercaDe = new VBox();
        
        TextArea tA_AcercaDe = new TextArea();
        tA_AcercaDe.setEditable(false);
        tA_AcercaDe.setText("App Contacts \nDesarrollado en: Netbeans 8.2 \nLenguaje: Java \n2018");
        
        vB_AcercaDe.getChildren().addAll(tA_AcercaDe);
        
        return vB_AcercaDe;
    }
    
}
