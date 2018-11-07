
package proyecto2;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;

public class InterfazMenuAgenda {
    
//    InterfazCréditosAcercaDe ic= new InterfazCréditosAcercaDe();
    InterfazContactos iCon= new InterfazContactos();
    public Scene getEscenaMenu (){
        Scene MenuAgenda = new Scene(new VBox(), 500, 500);
        VBox vB_ventanas= new VBox();
        
        MenuBar mB_Menu= new MenuBar(); //Barra del menú
        
        //Menú de Sistema
        Menu m_Sistema= new Menu("Sistema");
        
        //SubMenu de Sistema
        MenuItem mI_acercaDe= new MenuItem("Acerca de");
        mI_acercaDe.setOnAction((event)->{
            vB_ventanas.getChildren().clear(); //limpiar ventana
//            vB_ventanas.getChildren().addAll(ic.getInterfazAcercaDe());
        });
        
        
        MenuItem mI_creditos = new MenuItem("Créditos");
        mI_creditos.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        mI_creditos.setOnAction((event)->{
            vB_ventanas.getChildren().clear(); //limpiar ventana
//            vB_ventanas.getChildren().addAll(ic.getInterfazCréditos());
        });
        
        MenuItem mI_salir=new MenuItem("Salir", new ImageView(new Image ("exit (1).png")));
        mI_salir.setAccelerator(KeyCombination.keyCombination("Alt+S"));
        mI_salir.setOnAction((event)->Platform.exit());
        
         m_Sistema.getItems().addAll(mI_acercaDe, mI_creditos, mI_salir);
         
        //Menú contactos
        Menu mI_Contactos= new Menu("Contactos");
        //SubMenú de contactos
        MenuItem mI_insertarContactos = new MenuItem("Insertar",new ImageView(new Image("insertar.png")));
        mI_Contactos.setOnAction((event)->{
            vB_ventanas.getChildren().clear();
            vB_ventanas.getChildren().addAll(iCon.getAgregarInterfaz());
        });
        
        mI_Contactos.getItems().addAll(mI_insertarContactos);
        
       
        mB_Menu.getMenus().addAll(m_Sistema, mI_Contactos);//Agregar componentes de la Barra Menú
        
        ((VBox)MenuAgenda.getRoot()).getChildren().addAll(mB_Menu, vB_ventanas);
        
        return MenuAgenda;
        
    }
}
