package Ventanas;

import BaseDeDatos.bdChaza;
import BaseDeDatos.bdCliente;
import BaseDeDatos.bdComentario;
import BaseDeDatos.bdFactura;
import BaseDeDatos.bdOrden;
import BaseDeDatos.bdProducto;
import BaseDeDatos.bdVendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static bdVendedor bdVen = new bdVendedor();
    public static bdCliente bdCli = new bdCliente();
    public static bdChaza bdCha = new bdChaza();
    public static bdProducto bdPro = new bdProducto();
    public static bdOrden bdOrd = new bdOrden();
    public static bdFactura bdFac = new bdFactura();
    public static bdComentario bdComen = new bdComentario();
    

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("FacturaOrdenesCliente"), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Find Ur Chaza");
        stage.getIcons().add(new Image("/Imagenes/michianvorguesa.png"));
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}