package Ventanas;

import BaseDeDatos.Conexion;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

public class InicioSesionController {

    @FXML
    private Button IniciarSesion;

    @FXML
    private Button botonUnir;
    
    @FXML
    private Button botonVendedor;

    @FXML
    private Button botonCliente;
    
    @FXML
    private void primerEstilo() {
        IniciarSesion.getStylesheets().clear();
        IniciarSesion.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonUnir.getStylesheets().clear();
        botonUnir.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonVendedor.getStylesheets().clear();
        botonVendedor.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonCliente.getStylesheets().clear();
        botonCliente.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    

    @FXML
    private PasswordField PasswordFieldContraseña;

    @FXML
    private ImageView Tazon;
    
    @FXML
    private ImageView arroz;
    
    @FXML
    private ImageView degradeFondoChazasRecorte;
    
    @FXML
    private ImageView MensajeInicioSesion;
    
    @FXML
    private ImageView Bienvenido;
    
    @FXML
    private ImageView BienvenidoCliente;
    
    @FXML
    private ImageView BienvenidoVendedor;
    
    @FXML
    private ImageView FindUrChaza;
    
    @FXML
    private ImageView MensajeVendedor;
    
    @FXML
    private ImageView MensajeCliente;
    
    @FXML
    private ImageView MensajeCliente2;
    
    @FXML
    private ImageView palillos;
    
    @FXML
    private ImageView palillos2;
    
    @FXML
    private TextField TextFieldCorreoE;
    
    @FXML
    private Text correoElectronico;
    
    @FXML
    private Text Contraseña;
    
    @FXML
    private Text Cuenta;
   

    @FXML
    private ImageView Wallpaper;
    
    @FXML
    private void switchToRegistroDatosUsuario() throws IOException {
        App.setRoot("registroDatosUsuario");
    }
    
    @FXML
    private AnchorPane Panel1;
    
    @FXML
    private AnchorPane Panel11;
    
    @FXML
    private AnchorPane Panel12;
    
   /* 
    // Conexion base de datos
    public static String user ="";
    String pass ="";
    
    // Acciones
     @FXML
    void enviarDatos() {
       user = TextFieldCorreoE.getText().trim(); //Realmente deberia ser el nombre de la persona, no el correo :3
       pass = PasswordFieldContraseña.getText().trim();
       
       if(!user.equals("") || !pass.equals("")){
           try {
               Connection cn = Conexion.conectar();
           } catch (Exception e) {
               System.err.print("Error en el botón Iniciar Sesion" + e);
               JOptionPane.showMessageDialog(null, "¡Error al iniciar sesión! :(");
           }
       
       
       } else {
           JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar! :)");
           
       }
       
    }*/
    

}
