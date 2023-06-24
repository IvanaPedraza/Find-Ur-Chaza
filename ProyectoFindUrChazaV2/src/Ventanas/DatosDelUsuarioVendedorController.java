package Ventanas;

import EstructurasDeDatos.HashVendedor;
import Logica.*;
import Modelo.Chaza;
import Modelo.Producto;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DatosDelUsuarioVendedorController implements Initializable{

    private Connection conexion = BaseDeDatos.Conexion.conectar();
    private PreparedStatement pst;
    private ControladorVendedor controladorVendedor = InicioSesionController.getControladorVendedor();
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private ControladorProducto controladorProducto = App.bdPro.getControladorProducto();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashVendedor hashVendedor = controladorVendedor.getHashVendedor();
    public static Vendedor vendedorActual = InicioSesionController.getVendedorLog(); //CAMBIAR ESTOOOOOO
    private Mensaje mensaje = new Mensaje();

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button actualizarDatos;

    @FXML
    private Text apellido;

    @FXML
    private Button botonRetornoVen;

    @FXML
    private Text correoElectronico;

    @FXML
    private Button eliminarDatos;

    @FXML
    private Text nombre;

    @FXML
    private AnchorPane panel;

    @FXML
    private Text telefono;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;
    
    @FXML
    private Label labelDatosVendedor;
    
    @FXML
    private void retornarInicioVen() throws IOException {
        App.setRoot("menuChazasVendedor");
    }

    @FXML
    private void actualizarVendedor() {
        String correoActual = textFieldCorreo.getText().trim();
        String nombreActual = textFieldNombre.getText().trim();
        String apellidoActual = textFieldApellido.getText().trim();
        String telefonoActual = textFieldTelefono.getText().trim();

        if (!correoActual.equals("") || !nombreActual.equals("") || !apellidoActual.equals("") || !telefonoActual.equals("")) {
            try {
                controladorVendedor.actualizarVendedorCom(correoActual, nombreActual, apellidoActual, telefonoActual);
                
                try {
                    pst = conexion.prepareStatement("update vendedor set correoCliente = ?, nombreCliente = ?, apellidoCliente = ?, telefonoCliente = ? where correoCliente = " + "'"+vendedorActual.getCorreo()+"'");
                    pst.setString(1, correoActual);
                    pst.setString(2, nombreActual);
                    pst.setString(3, apellidoActual);
                    pst.setString(4, telefonoActual);
                    int n = pst.executeUpdate();
                    if(n > 0)
                        System.out.println("Se actualizo en la bd");
                } catch (SQLException e) {
                    System.out.println("Error en el insertado de la BD");
                }
                
                mensaje.mensajeInformacion("Haz actualizado tu usuario: " + nombreActual + " :D");
            } catch (Exception e) {
                mensaje.mensajeError("Ha sucedio un error, no fue posible actualizar :(");
            }
        } else {
            mensaje.mensajeAdvertencia("Debe llenar todos los campos requeridos");
        }
    }

    @FXML
    private void eliminarVendedor() {
        String correoAEliminar = textFieldCorreo.getText().trim();
        try {
            eliminarProdChazaVendedor();
            controladorVendedor.eliminarVendedor(correoAEliminar);
            
            try {
                pst = conexion.prepareStatement("delete from vendedor where correoVendedor = " + "'"+ vendedorActual.getCorreo()+"'");
                int n = pst.executeUpdate();
                if (n > 0) {
                    System.out.println("Se elimino en la bd");
                }
            } catch (SQLException e) {
                System.out.println("Error en el insertado de la BD");
            }
            
            mensaje.mensajeInformacion("Haz eliminado tu usuario ");
            App.setRoot("InicioSesion");
        } catch (Exception e) {
            mensaje.mensajeError("Ha sucedido un error, no fue posible eliminar :(");
        }
    }

    private void eliminarProdChazaVendedor() {
        try {
            Chaza[] chazasVendedor = controladorChaza.buscarChazasPorVendedor(vendedorActual);
            for (int i = 0; i < chazasVendedor.length; i++) {
                Producto[] productos = controladorProducto.buscarProductosPorChaza(chazasVendedor[i]);
                for (int j = 0; i < productos.length; i++) {
                    controladorProducto.eliminarProducto(productos[j].getCodigo());
                }
                controladorChaza.eliminarChaza(chazasVendedor[i].getNombreChaza());
            }
        }catch(Exception e){
            mensaje.mensajeError("Ha ocurrido un error " + e.toString());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panel.setVisible(true);
        Wallpaper.setVisible(true);
        labelDatosVendedor.setText("¡Bienvenido " + vendedorActual.getNombre()+ " " + vendedorActual.getApellido()+"!");
        actualizarDatos.setVisible(true);
        apellido.setVisible(true);
        botonRetornoVen.setVisible(true);
        correoElectronico.setVisible(true);
        eliminarDatos.setVisible(true);
        labelDatosVendedor.setVisible(true);
        nombre.setVisible(true);
        telefono.setVisible(true);
        textFieldApellido.setVisible(true);
        textFieldApellido.setText(vendedorActual.getApellido());
        textFieldCorreo.setVisible(true);
        textFieldCorreo.setText(vendedorActual.getCorreo());
        textFieldNombre.setVisible(true);
        textFieldNombre.setText(vendedorActual.getNombre());
        textFieldTelefono.setVisible(true);
        textFieldTelefono.setText(vendedorActual.getTelefono());
    }
    

}
