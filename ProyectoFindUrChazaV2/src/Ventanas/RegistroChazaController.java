package Ventanas;

import EstructurasDeDatos.AVLChaza;
import Logica.ControladorChaza;
import Modelo.Chaza;
import Modelo.Vendedor;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroChazaController implements Initializable{
    
    private Connection conexion = BaseDeDatos.Conexion.conectar();
    //private AVLChaza arbolChaza = new AVLChaza();
    private Vendedor vendedorChaza = registroDatosVendedorController.vendedorActual;
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Chaza chazaActual = new Chaza();
    public Mensaje mensaje = new Mensaje();
    private PreparedStatement pst;

    @FXML
    private AnchorPane Panel1;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button botonRegistroChaza;

    @FXML
    private Text descripcionChaza;

    @FXML
    private Text nombreChaza;

    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TextField textFieldNombreChaza;

    @FXML
    private TextField textFieldUbicacion;

    @FXML
    private Text ubicacionChaza;

    @FXML
    private Button volverInicioVendedor;
    
    @FXML
    void registrarChaza() throws IOException {
        String nombreChaza = textFieldNombreChaza.getText().trim();
        String ubicacionChaza = textFieldUbicacion.getText().trim();
        String descripcionChaza = textFieldDescripcion.getText().trim();
        
        
        if(!nombreChaza.equals("") || !ubicacionChaza.equals("") || !descripcionChaza.equals("")){
            chazaActual = controladorChaza.agregarNuevaChaza(nombreChaza, ubicacionChaza, descripcionChaza, vendedorChaza);
            
            try{
                pst = conexion.prepareStatement("insert into chaza (nombreChaza, ubicacionChaza, descripcionChaza, correoVendedor, estadoChaza) values(?,?,?,?,?)");
                pst.setString(1, nombreChaza);
                pst.setString(2, ubicacionChaza);
                pst.setString(3, descripcionChaza);
                pst.setString(4, vendedorChaza.getCorreo());
                pst.setString(5, "1");
                int n = pst.executeUpdate();
                if(n > 0)
                    mensaje.mensajeInformacion("Se ha ingresado correctamente \n" +
                    chazaActual.getNombreChaza());
            }catch(SQLException e){
                System.out.println("Error en el insertado de la BD");
            }
            
            
            App.setRoot("InicioSesion");
        }else{
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");
        }
    }
    
    @FXML
    void retornarInicioVendedor() throws IOException {
        App.setRoot("InicioVendedor");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Panel1.setVisible(true);
        Wallpaper.setVisible(true);
        botonRegistroChaza.setVisible(true);
        descripcionChaza.setVisible(true);
        nombreChaza.setVisible(true);
        textFieldDescripcion.setVisible(true);
        textFieldNombreChaza.setVisible(true);
        textFieldUbicacion.setVisible(true);
        ubicacionChaza.setVisible(true);
        volverInicioVendedor.setVisible(true);
    }

}
