
package proyecto2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Proyecto2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        InterfazMenuAgenda ima= new InterfazMenuAgenda();
        
        primaryStage.setTitle("Agenda");
        primaryStage.setScene(ima.getEscenaMenu());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
