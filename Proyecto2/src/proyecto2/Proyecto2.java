package proyecto2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;

import javafx.stage.Stage;

public class Proyecto2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        InterfazMenuAgenda ima = new InterfazMenuAgenda();

        primaryStage.setTitle("Agenda");
        primaryStage.setScene(ima.getEscenaMenu());
        primaryStage.show();
    }

    public static void main(String[] args) throws ParseException {
        launch(args);
//        Date d = new Date();
//        DateFormat dateMaquina = new SimpleDateFormat("yyyy-MM-dd");
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        Date fechaInicial = dateFormat.parse("1998-03-14");
//
//        Date fechaFinal = dateFormat.parse(dateMaquina.format(d));
//
//        int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
//
//        System.out.println("Hay " + dias + " dias de diferencia");
//        int annos= dias/365;
//        System.out.println(annos);
    }

}
