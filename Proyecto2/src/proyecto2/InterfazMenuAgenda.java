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
      
        Scene MenuAgenda = new Scene(new VBox(), 300, 250);
        
        
        MenuBar mB_Menu= new MenuBar(); //Barra del menú
        
        VBox vB_Ventanas = new VBox();  // gestor de ventanas
       
        
        // Menu Sistema
        Menu m_Sistema = new Menu("Sistema");
        
        // SubMenu del Sistema
    
        MenuItem mi_AcercaDE = new MenuItem("Acerca de");
        mi_AcercaDE.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));  // teclas de acceso rapido
        mi_AcercaDE.setOnAction((event)->{ 
            
            vB_Ventanas.getChildren().clear();
       //     vB_Ventanas.getChildren().addAll(ic.getInterfazAcercaDe());
            
        }); // fin AcercaDe
      
        MenuItem mi_Creditos = new MenuItem("Creditos");
        mi_Creditos.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));   // teclas de acceso rapido
        mi_Creditos.setOnAction((event)-> {
          
        vB_Ventanas.getChildren().clear();   // quita las ventanas
       // vB_Ventanas.getChildren().addAll(ic.getInterfazCreditos());
        
        }); // fin Creditos
        
        MenuItem mi_salir = new MenuItem("Salir", new ImageView( new Image ("salida.png"))); // imagen a salida
        mi_salir.setAccelerator(KeyCombination.keyCombination("Alt+S"));
        mi_salir.setOnAction((event)->Platform.exit());
        
        m_Sistema.getItems().addAll(mi_AcercaDE,mi_Creditos,mi_salir);
        
        // Fin Menu Sistema
        
        // Menu Contactos
        Menu m_Contactos = new Menu("Contactos");
        
        // Submenu de Contactos
        
        MenuItem mI_InsertarContactos = new MenuItem("Insertar", new ImageView( new Image("insertar.png")));
          mI_InsertarContactos.setOnAction((event)->{
            vB_Ventanas.getChildren().clear();
            vB_Ventanas.getChildren().addAll(iCon.getInsertarInterfaz());
            
        }); // fin insertar contactos
        
        
        // Submenu de contactos, se eliminan los contactos del archivo
        MenuItem mI_EliminarContactos = new MenuItem("Eliminar Contactos", new ImageView( new Image ("eliminar.png")));  
        
        
        
        
        // submenu de contactos, se modifican la informacion de los contactos del archivo
        MenuItem ml_ModificarContactos = new MenuItem("Modificar Contactos", new ImageView( new Image ("editar.png")));
        
        
        
        
        // submenu de contactos, aqui se buscan los contactos del archivo
        MenuItem ml_BuscarContactos = new MenuItem("Buscar Contactos", new ImageView( new Image ("buscar.png")));
        
        
        
        
        
        // se agregan todos los submenu al menu contactos
        m_Contactos.getItems().addAll(mI_InsertarContactos,mI_EliminarContactos,ml_ModificarContactos,ml_BuscarContactos);

        
        // fin menu Contactos
        
        // Se crea el Menu Mantenimiento
        Menu m_Mantenimiento = new Menu ("Mantenimiento");
        
        // Submenu del menu mantenimiento, se vacia la agenda
        MenuItem mI_VaciarAgenda = new MenuItem("Vaciar Agenda", new ImageView( new Image ("vaciar.png")));
        
        // se agregan los submenu al menu mantenimiento
        m_Mantenimiento.getItems().addAll(mI_VaciarAgenda);
        
        
        // fin menu Mantenimiento
        
        
        // se crea el menu reportes 
        Menu m_Reportes = new Menu("Reportes");
        
        // SubMenu del menu Reportes, se puede observar toda la agenda de contactos
        MenuItem mI_VerAgenda = new MenuItem("Ver Agenda", new ImageView( new Image ("ver.png")));
        
        
        
        
        // SubMenu del Menu Reportes, se obtiene un listado de contactos por mes de nacimiento 
        MenuItem mI_ListadoMesNacimiento = new MenuItem("Listado de contactos por mes de nacimiento");
        
        
        m_Reportes.getItems().addAll(mI_VerAgenda,mI_ListadoMesNacimiento);
        
        // se agregan todos los menu al MenuBar
        mb_Menu.getMenus().addAll(m_Sistema,m_Contactos,m_Mantenimiento, m_Reportes); 
        ((VBox)MenuAgenda.getRoot()).getChildren().addAll(mB_Menu, vB_ventanas);
        
        return MenuAgenda;
    }
}    

