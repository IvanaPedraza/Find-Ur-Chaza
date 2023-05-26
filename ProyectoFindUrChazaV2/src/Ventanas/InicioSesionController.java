package Ventanas;

import BaseDeDatos.Conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import java.net.Proxy;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;



public class InicioSesionController implements Initializable {

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
    /*
    @FXML
    private void switchToRegistroDatosUsuario() throws IOException {
        App.setRoot("registroDatosUsuario");
    }*/
    
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

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        degradeFondoChazasRecorte.setVisible(true);
        arroz.setVisible(true);
        palillos.setVisible(true);
        palillos2.setVisible(true);
        correoElectronico.setVisible(true);
        Contraseña.setVisible(true);
        TextFieldCorreoE.setVisible(true);
        PasswordFieldContraseña.setVisible(true);
        IniciarSesion.setVisible(true);
        Cuenta.setVisible(true);
        botonUnir.setVisible(true);
        botonVendedor.setVisible(true);
        MensajeCliente2.setVisible(true);
        Tazon.setVisible(true);
        FindUrChaza.setVisible(true);
        BienvenidoCliente.setVisible(true);
        Bienvenido.setVisible(true);
        MensajeInicioSesion.setVisible(true);
        MensajeVendedor.setVisible(true);
        BienvenidoVendedor.setVisible(false);
        botonCliente.setVisible(false);
        MensajeCliente.setVisible(false);
    
    }
    
    
    @FXML
   private void btnV(MouseEvent event){
       TranslateTransition slide = new TranslateTransition();
       slide.setDuration(Duration.seconds(0.7));
       slide.setNode(Panel12);
       
       slide.setToX(-680);
       slide.play();
       
       Panel11.setTranslateX(600);
       BienvenidoVendedor.setVisible(true);
       botonCliente.setVisible(true);
       MensajeCliente.setVisible(true);
       Bienvenido.setVisible(true);
       BienvenidoCliente.setVisible(false);
       Tazon.setVisible(true);
       FindUrChaza.setVisible(true);
       MensajeInicioSesion.setVisible(true);
       arroz.setVisible(true);
       degradeFondoChazasRecorte.setVisible(true);
       IniciarSesion.setVisible(true);
       palillos.setVisible(true);
       palillos2.setVisible(true);
       botonUnir.setVisible(true);
       Cuenta.setVisible(true);
       botonVendedor.setVisible(false);
       MensajeCliente2.setVisible(true);
       MensajeVendedor.setVisible(false);
       correoElectronico.setVisible(true);
       Contraseña.setVisible(true);
       TextFieldCorreoE.setVisible(true);
       PasswordFieldContraseña.setVisible(true);
   
       slide.setOnFinished((e->{
           
       }));
   }
   
   @FXML
   private void btnC(MouseEvent event){
       TranslateTransition slide = new TranslateTransition();
       slide.setDuration(Duration.seconds(0.7));
       slide.setNode(Panel12);
       
       slide.setToX(0);
       slide.play();
       
       Panel11.setTranslateX(0);
       BienvenidoVendedor.setVisible(false);
       botonCliente.setVisible(false);
       MensajeCliente.setVisible(false);
       Bienvenido.setVisible(true);
       BienvenidoCliente.setVisible(true);
       Tazon.setVisible(true);
       FindUrChaza.setVisible(true);
       MensajeInicioSesion.setVisible(true);
       arroz.setVisible(true);
       degradeFondoChazasRecorte.setVisible(true);
       IniciarSesion.setVisible(true);
       palillos.setVisible(true);
       palillos2.setVisible(true);
       botonUnir.setVisible(true);
       Cuenta.setVisible(true);
       botonVendedor.setVisible(true);
       MensajeCliente2.setVisible(true);
       MensajeVendedor.setVisible(true);
       correoElectronico.setVisible(true);
       Contraseña.setVisible(true);
       TextFieldCorreoE.setVisible(true);
       PasswordFieldContraseña.setVisible(true);
   
       slide.setOnFinished((e->{
           
       }));
   }
    

}
