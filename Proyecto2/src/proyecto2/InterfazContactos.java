package proyecto2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

public class InterfazContactos {

    MantieneContactos mC = new MantieneContactos("Agenda.txt");

    public GridPane getAgregarInterfaz() {
        GridPane gP_agregar = new GridPane();

        gP_agregar.setMinSize(800, 700);
        gP_agregar.setStyle("-fx-background-color: F4F4F4");

        // determina el espacio entre columnas (vertical y horizontal)
        gP_agregar.setVgap(10);
        gP_agregar.setHgap(10);

        // determina la alineacion del GridPane
        gP_agregar.setAlignment(Pos.CENTER);

        Label lB_nombre = new Label("Nombre");
        gP_agregar.add(lB_nombre, 0, 0);

        TextField tF_nombre = new TextField(); //agregar nombre del contacto
        gP_agregar.add(tF_nombre, 1, 0);

        Label lB_apellidos = new Label("Apellidos");
        gP_agregar.add(lB_apellidos, 0, 1);

        TextField tF_apellido = new TextField(); //agregar apellidos del contacto
        gP_agregar.add(tF_apellido, 1, 1);

        Label lB_FechaNacimiento = new Label("Selecione su fecha de nacimiento");
        gP_agregar.add(lB_FechaNacimiento, 0, 2);

        DatePicker dP_Fecha = new DatePicker();//Seleccionar fecha de nacimiento
        gP_agregar.add(dP_Fecha, 1, 2);

        Label lB_teléfono = new Label("Teléfono");
        gP_agregar.add(lB_teléfono, 0, 3);

        Label lb_MensajeError = new Label();
        gP_agregar.add(lb_MensajeError, 2, 9);
        lb_MensajeError.setVisible(false);

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

        ImageView imagenContacto = new ImageView(new Image("Contacto.png"));
        gP_agregar.add(imagenContacto, 4, 0);

        Label lB_Insertado = new Label("Contacto insertado con exito", new ImageView(new Image("guardar.png")));

        Button btn_agregar = new Button(" ", new ImageView(new Image("insertar.png")));
        gP_agregar.add(btn_agregar, 0, 8);
        btn_agregar.setOnAction((event) -> {
            if (tF_nombre.getText().equalsIgnoreCase("") || tF_apellido.getText().equals("") || dP_Fecha.getValue() == null || tF_telefono.getText().equals("")
                    || tF_dirección.getText().equals("") || tF_correo.getText().equals("")) {
                lb_MensajeError.setText("Error al ingresar los datos");
                lb_MensajeError.setVisible(true);
            } else {
                if (!mC.verificaCorreo(tF_correo.getText())) {
                    lb_MensajeError.setText("El correo ingresado es incorrecto");
                    lb_MensajeError.setVisible(true);
                    tF_correo.setText(" ");
                } else {
                    try {
                        String nombreInsertado = tF_nombre.getText();
                        String apellidosInsertados = tF_apellido.getText();
                        LocalDate fechaSeleccionada = dP_Fecha.getValue();


                        String telefonoInsertado = tF_telefono.getText();
                        String direcciónIngresada = tF_dirección.getText();
                        String correoIngresado = tF_correo.getText();

                        Date d = new Date();
                        DateFormat dateMaquina = new SimpleDateFormat("yyyy-MM-dd");
                        String dateI = ""+dateMaquina;
                        String dateF = ""+fechaSeleccionada;
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date fechaInicial = dateFormat.parse(dateF);

                        Date fechaFinal = dateFormat.parse(dateMaquina.format(d));

                        int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
                        int annos = dias / 365;
                        System.out.println(annos);
                        String edadGenerada = ""+annos;
                        gP_agregar.add(lB_Insertado, 0, 10);
                        tF_nombre.setText(" ");
                        tF_apellido.setText(" ");
                        tF_telefono.setText(" ");
                        tF_dirección.setText(" ");
                        tF_correo.setText(" ");
                        lb_MensajeError.setVisible(false);
                        dP_Fecha.getEditor().clear();

                        Contactos contac = new Contactos(nombreInsertado, apellidosInsertados, "" + fechaSeleccionada, "" + edadGenerada, "" + telefonoInsertado, "" + direcciónIngresada, "" + correoIngresado);
                        mC.insertarContacto(contac);
                    } catch (ParseException ex) {
                        Logger.getLogger(InterfazContactos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        Button bTN_Cerrar = new Button("Cerrar");
        gP_agregar.add(bTN_Cerrar, 0, 9);
        bTN_Cerrar.setOnAction((event) -> {

            gP_agregar.getChildren().clear();

        });

        return gP_agregar;
    }
}
