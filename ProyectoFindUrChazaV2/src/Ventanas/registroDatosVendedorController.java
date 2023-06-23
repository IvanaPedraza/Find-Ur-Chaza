package Ventanas;

import EstructurasDeDatos.HashVendedor;
import Logica.*;
import Modelo.Vendedor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.*;
import javafx.scene.control.*;


public class registroDatosVendedorController {

    private Connection conexion = BaseDeDatos.Conexion.conectar();
    private ControladorVendedor controladorVendedor = InicioSesionController.getControladorVendedor();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashVendedor hashVendedor = controladorVendedor.getHashVendedor();
    public static Vendedor vendedorActual = new Vendedor();
    public Mensaje mensaje = new Mensaje();
    private PreparedStatement pst;

    @FXML
    private Button nuevoVendedor;

    @FXML
    private Button nuevoCliente;

    @FXML
    private PasswordField passwordFieldContraseña;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private void registrarVendedor() throws IOException {

        String correo = textFieldCorreo.getText().trim();
        String nombre = textFieldNombre.getText().trim();
        String apellido = textFieldApellido.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String contrasena = passwordFieldContraseña.getText().trim();
        if (!correo.equals("") || !nombre.equals("") || !apellido.equals("") || !telefono.equals("") || !contrasena.equals("")) {
            vendedorActual = new Vendedor(correo, nombre, apellido, telefono, contrasena);
            //arregloVendedor.pushBack(vendedorActual);
            hashVendedor.insert(correo, vendedorActual);
            //arregloVendedor.imprimir();
            hashVendedor.printHashTable();
            
            try{
                pst = conexion.prepareStatement("insert into vendedor values(?,?,?,?,?)");
                pst.setString(1, correo);
                pst.setString(2, nombre);
                pst.setString(3, apellido);
                pst.setString(4, telefono);
                pst.setString(5, contrasena);
                int n = pst.executeUpdate();
                if(n > 0)
                    System.out.println("Se inserto en la bd");
            }catch(SQLException e){
                System.out.println("Error en el insertado de la BD");
            }
            
            mensaje.mensajeInformacion("Se ha insertado correctamente " + vendedorActual.getNombre() + " "+ vendedorActual.getApellido());
            App.setRoot("RegistroChaza");

        } else {
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");

        }

    }

    @FXML
    private Button Volver;

    @FXML
    private void switchToIniciarSesion() throws IOException {
        App.setRoot("InicioSesion");
    }

    @FXML
    private void primerEstilo() {
        nuevoVendedor.getStylesheets().clear();
        nuevoVendedor.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        nuevoCliente.getStylesheets().clear();
        nuevoCliente.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
        
 }   

