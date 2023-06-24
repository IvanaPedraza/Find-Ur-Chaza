package Ventanas;

import Logica.ControladorCliente;
import Logica.ControladorVendedor;
import Modelo.Cliente;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class InicioSesionController implements Initializable {

    private static ControladorVendedor controladorVendedor = App.bdVen.getControladorVendedor();
    private static ControladorCliente controladorCliente = App.bdCli.getControladorCliente();
    private static Cliente clienteLog = new Cliente();
    private static Vendedor vendedorLog = new Vendedor();
    private Mensaje mensaje = new Mensaje();

    public static ControladorVendedor getControladorVendedor() {
        return controladorVendedor;
    }

    public static ControladorCliente getControladorCliente() {
        return controladorCliente;
    }

    public static Cliente getClienteLog() {
        return clienteLog;
    }

    public static Vendedor getVendedorLog() {
        return vendedorLog;
    }

    @FXML
    private Button IniciarSesion;

    @FXML
    private Button IniciarSesionC;

    @FXML
    private Button botonUnir;

    @FXML
    private Button botonUnirC;

    @FXML
    private Button botonVendedor;

    @FXML
    private Button botonCliente;

    @FXML
    private void primerEstilo() {
        IniciarSesion.getStylesheets().clear();
        IniciarSesion.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        IniciarSesionC.getStylesheets().clear();
        IniciarSesionC.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonUnir.getStylesheets().clear();
        botonUnir.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonUnirC.getStylesheets().clear();
        botonUnirC.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonVendedor.getStylesheets().clear();
        botonVendedor.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonCliente.getStylesheets().clear();
        botonCliente.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

    @FXML
    private PasswordField PasswordFieldContraseña;
    
    @FXML
    private PasswordField PasswordFieldContraseñaC;


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
    private TextField TextFieldCorreoEC;

    @FXML
    private Text correoElectronico;

    @FXML
    private Text Contraseña;

    @FXML
    private Text Cuenta;

    @FXML
    private AnchorPane Panel1;

    @FXML
    private AnchorPane Panel11;

    @FXML
    private AnchorPane Panel12;

    // Switch de ventanas
    @FXML
    private void switchToRegistroDatosCliente() throws IOException {
        App.setRoot("registroDatosCliente");
    }

    @FXML
    private void switchToRegistroDatosVendedor() throws IOException {
        App.setRoot("registroDatosVendedor");
    }

    //
    public static String email = "";
    String pass = "";
    public static String emailC = "";
    String passC = "";

    @FXML
    private void switchToInicioVendedor() throws IOException {
        Vendedor vendedorLogueado = new Vendedor();
        email = TextFieldCorreoE.getText().trim(); //Realmente deberia ser el nombre de la persona, no el correo :3
        pass = PasswordFieldContraseña.getText().trim();

        if (!email.equals("") || !pass.equals("")) {
            try {
                vendedorLogueado = controladorVendedor.iniciarSesionVendedor(email, pass);
                if(vendedorLogueado != null){
                    vendedorLog = vendedorLogueado;
                    App.setRoot("menuChazasVendedor");
                }else{
                    mensaje.mensajeAdvertencia("¡El vendedor ingresado no es válido, vuelva a intentar! :(");
                }
                
            } catch (Exception e) {
                mensaje.mensajeError("¡Error al iniciar sesión! :(");
                System.out.println("ola"+e);
            }
        } else {
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");
        }
    }

    @FXML
    private void switchToInicioCliente() throws IOException {
        Cliente clienteLogueado = new Cliente();
        emailC = TextFieldCorreoEC.getText().trim(); //Realmente deberia ser el nombre de la persona, no el correo :3
        passC = PasswordFieldContraseñaC.getText().trim();

        if (!emailC.equals("") || !passC.equals("")) {
            try {
                clienteLogueado = controladorCliente.iniciarSesionCliente(emailC, passC);
                if(clienteLogueado != null){
                    clienteLog = clienteLogueado;
                    App.setRoot("menuChazas");
                }else{
                    mensaje.mensajeAdvertencia("¡El cliente ingresado no es válido, vuelva a intentar!");
                }
                
            } catch (Exception e) {
                mensaje.mensajeError("¡Error al iniciar sesión! :(");
            }
            
        } else {
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");
        }

    }

// ------------------------- Animación ----------------------
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        degradeFondoChazasRecorte.setVisible(true);
        arroz.setVisible(true);
        palillos.setVisible(true);
        palillos2.setVisible(true);
        correoElectronico.setVisible(true);
        Contraseña.setVisible(true);
        TextFieldCorreoE.setVisible(false);
        TextFieldCorreoEC.setVisible(true);
        PasswordFieldContraseña.setVisible(false);
        PasswordFieldContraseñaC.setVisible(true);
        IniciarSesion.setVisible(false);
        Cuenta.setVisible(true);
        botonUnir.setVisible(false);
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
        botonUnirC.setVisible(true);
        IniciarSesionC.setVisible(true);

    }

    @FXML
    private void btnV(MouseEvent event
    ) {
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
        TextFieldCorreoE.setVisible(true); //debajo de esta linea tiene que aparecer TextFieldCorreoEC
        TextFieldCorreoEC.setVisible(false);
        PasswordFieldContraseña.setVisible(true);
        PasswordFieldContraseñaC.setVisible(false);
        botonUnirC.setVisible(false);
        IniciarSesionC.setVisible(false);

        slide.setOnFinished((e -> {

        }));
    }

    @FXML
    private void btnC(MouseEvent event
    ) {
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
        IniciarSesion.setVisible(false);
        palillos.setVisible(true);
        palillos2.setVisible(true);
        botonUnir.setVisible(false);
        Cuenta.setVisible(true);
        botonVendedor.setVisible(true);
        MensajeCliente2.setVisible(true);
        MensajeVendedor.setVisible(true);
        correoElectronico.setVisible(true);
        Contraseña.setVisible(true);
        TextFieldCorreoE.setVisible(false);
        PasswordFieldContraseña.setVisible(false);
        TextFieldCorreoEC.setVisible(true);
        PasswordFieldContraseñaC.setVisible(true);
        botonUnirC.setVisible(true);
        IniciarSesionC.setVisible(true);

        slide.setOnFinished((e -> {

        }));
    }

}
