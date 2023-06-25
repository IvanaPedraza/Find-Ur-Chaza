/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author IVANA
 */
import Logica.*;
import Modelo.Chaza;
import Modelo.Producto;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class menuProductosVendedorController implements Initializable {

    private Connection conexion = BaseDeDatos.Conexion.conectar();
    private PreparedStatement pst;
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog();
    public static Chaza chazaEscogida = new Chaza();
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private ControladorProducto controladorProducto = App.bdPro.getControladorProducto();
    private ObservableList<Producto> cardListProducto = FXCollections.observableArrayList();
    public Mensaje mensaje = new Mensaje();
    String estados[] = {"Abierto", "Cerrado"};
    private long numProducto = 101;

    @FXML
    private AnchorPane Panel;

    @FXML
    private AnchorPane Panel2;

    @FXML
    private AnchorPane Panel3;

    @FXML
    private ImageView Fondo;

    @FXML
    private ImageView Tienda;

    @FXML
    private ImageView michiHamborgueso;

    @FXML
    private ImageView findUrChaza;

    @FXML
    private ImageView fotoPerfilV;

    @FXML
    private ImageView fotoPerfilV2;

    @FXML
    private Label nombreVendedor;

    @FXML
    private Label nombreVendedorInfo;

    @FXML
    private Label nombreChaza;

    @FXML
    private ChoiceBox Choice_BoxEstado;

    @FXML
    private Text Estado;

    @FXML
    private Button Añadir;

    @FXML
    private Button Productos;

    @FXML
    private Button TusChazas;

    @FXML
    private Button TusOrdenes;

    @FXML
    private Separator separador;

    @FXML
    private ScrollPane scrollGridPane;

    @FXML
    private GridPane producto_GridPane;

    @FXML
    private Label DescripcionChaza;

    @FXML
    private void primerEstilo() {
        TusOrdenes.getStylesheets().clear();
        TusOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        TusChazas.getStylesheets().clear();
        TusChazas.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Productos.getStylesheets().clear();
        Productos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Añadir.getStylesheets().clear();
        Añadir.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

    @FXML
    private void switchToMenuChazasVendedor() throws IOException {
        App.setRoot("menuChazasVendedor");
    }

    @FXML
    private void switchToOrdenesProductosVendedor() throws IOException {
        App.setRoot("ordenesProductosVendedor");
    }

    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }

    @FXML
    private void switchToDatosDelVendedor() throws IOException {
        App.setRoot("DatosDelUsuarioVendedor");
    }

    @FXML
    void anadirProducto() {
        long numeroDeProducto = numProducto();
        String nombreProducto = nombreNuevoProducto.getText().trim();
        String descripcionProducto = descripcionNuevoProducto.getText().trim();
        double precioProducto = Double.parseDouble(precioNuevoProducto.getText().trim());
        LocalDate localValue = fechaExpNuevo.getValue();
        Instant instant = localValue.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date fechaExp = Date.from(instant);
        Date nuevaFechaIngreso = new Date();
        java.sql.Timestamp fechaIngresoSql = new Timestamp(nuevaFechaIngreso.getTime());
        java.sql.Timestamp fechaExpiracionSql = new Timestamp(fechaExp.getTime());
        if(!nombreProducto.equals("") || !descripcionProducto.equals("") || precioProducto != 0){
            controladorProducto.agregarNuevoProducto(numeroDeProducto, nombreProducto, precioProducto, descripcionProducto, nuevaFechaIngreso, fechaExp, chazaEscogida);
            
            try{
                pst = conexion.prepareStatement("insert into producto (codigoProducto, nombreProducto, precioProducto, detalleProducto, fechaIngresoProd, fechaExpiracionProd,idChaza) values(?,?,?,?,?,?,?)");
                pst.setLong(1, numeroDeProducto);
                pst.setString(2, nombreProducto);
                pst.setDouble(3, precioProducto);
                pst.setString(4, descripcionProducto);
                pst.setTimestamp(5, fechaIngresoSql);
                pst.setTimestamp(6, fechaExpiracionSql);
                pst.setLong(7, chazaEscogida.getIdChaza());
                int n = pst.executeUpdate();
                if(n > 0)
                    System.out.println("Se ingreso en la bd");
                mensaje.mensajeInformacion("Se ingreso correctamente " + nombreProducto);
                productoDisplayCard();
            }catch(SQLException e){
                System.out.println("Error en el insertado de la BD " + e.toString());
            }
        }else{
            mensaje.mensajeAdvertencia("Debes llenar todos los campos seleccionados :(");
        }
    }
    
    private long numProducto() {
        /*
        long numeroProductos = controladorProducto.numeroTotalProductos();
        numProducto = 100 + numeroProductos;
        return numProducto;
*/
        numProducto +=controladorProducto.numeroTotalProductos();
        return numProducto;
    }

    public ObservableList<Producto> productoGetData() {
        ObservableList<Producto> listProducto = FXCollections.observableArrayList();
        Producto[] productos = controladorProducto.buscarProductosPorChaza(chazaEscogida);

        for (int i = 0; i < productos.length; i++) {
            listProducto.add(productos[i]);
        }

        return listProducto;
    }

    public void productoDisplayCard() {
        cardListProducto.clear();
        cardListProducto.addAll(productoGetData());

        int row = 0;
        int column = 0;
        producto_GridPane.getChildren().clear();
        producto_GridPane.getRowConstraints().clear();
        producto_GridPane.getColumnConstraints().clear();
        for (int i = 0; i < cardListProducto.size(); i++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("ProductosVendedor.fxml"));
                AnchorPane pane = load.load();
                ProductosVendedorController cardC = load.getController();
                cardC.setData(cardListProducto.get(i));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                producto_GridPane.add(pane, column++, row);

                GridPane.setMargin(pane, new Insets(10));
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    private void estadoChazaBox() {
        Choice_BoxEstado.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value) {
                cambiarEstado(new_value.intValue());
            }
        }
        );
    }

    private void cambiarEstado(int index) {
        Choice_BoxEstado.setValue(estados[index]);
        int value = 0;
        if (index == 0) {
            value = 1;
        }
        controladorChaza.actualizarChaza(chazaEscogida.getNombreChaza(), "Estado", String.valueOf(value));
        mensaje.mensajeConfirmacion("Estado de la chaza " + chazaEscogida.getNombreChaza() + " cambiado con éxito!");
    }

    private void estadoInicial() {
        int value = chazaEscogida.getEstadoChaza();
        if (value == 1) {
            Choice_BoxEstado.setValue(estados[0]);
        } else {
            Choice_BoxEstado.setValue(estados[1]);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DescripcionChaza.setVisible(true);
        producto_GridPane.setVisible(true);
        scrollGridPane.setVisible(true);
        TusOrdenes.setVisible(true);
        separador.setVisible(true);
        TusChazas.setVisible(true);
        Productos.setVisible(true);
        Añadir.setVisible(true);
        Estado.setVisible(true);
        Choice_BoxEstado.setVisible(true);
        Choice_BoxEstado.setItems(FXCollections.observableArrayList(estados));
        nombreChaza.setVisible(true);
        nombreVendedorInfo.setVisible(true);
        nombreVendedor.setVisible(true);
        fotoPerfilV2.setVisible(true);
        fotoPerfilV.setVisible(true);
        findUrChaza.setVisible(true);
        michiHamborgueso.setVisible(true);
        Tienda.setVisible(true);
        Fondo.setVisible(true);
        Panel3.setVisible(true);
        Panel2.setVisible(true);
        Panel.setVisible(true);
        //----
        ventanaAñadir.setVisible(false);
        fondo2.setVisible(false);
        imagenComidaV.setVisible(false);
        nombreproductol.setVisible(false);
        nombreNuevoProducto.setVisible(false);
        descripcionNuevoProducto.setVisible(false);
        preciolabel.setVisible(false);
        precioNuevoProducto.setVisible(false);
        Agregar.setVisible(false);
        //------
        nombreVendedorInfo.setText(vendedorActual.getNombre() + " " + vendedorActual.getApellido());
        nombreVendedor.setText(vendedorActual.getNombre());
        nombreChaza.setText(chazaEscogida.getNombreChaza());
        DescripcionChaza.setText(chazaEscogida.getDescripcion());
        estadoInicial();
        estadoChazaBox();
        productoDisplayCard();
    }
    ///-----------------------
    @FXML
    private AnchorPane ventanaAñadir;
    @FXML
    private ImageView fondo2;
    @FXML
    private ImageView imagenComidaV;
    @FXML
    private Label nombreproductol;
    @FXML
    private TextField nombreNuevoProducto;
    @FXML
    private TextField descripcionNuevoProducto;
    @FXML
    private Label preciolabel;
    @FXML
    private TextField precioNuevoProducto;
    @FXML
    private DatePicker fechaExpNuevo;
    @FXML
    private Button Agregar;
 

    @FXML
    void cerrarVentanaAñadir() {
        ventanaAñadir.setVisible(false);
        fondo2.setVisible(false);
        imagenComidaV.setVisible(false);
        nombreproductol.setVisible(false);
        nombreNuevoProducto.setVisible(false);
        descripcionNuevoProducto.setVisible(false);
        preciolabel.setVisible(false);
        precioNuevoProducto.setVisible(false);
        Agregar.setVisible(false);
    }

    @FXML
    void abrirVentanaAñadir() {
        ventanaAñadir.setVisible(true);
        fondo2.setVisible(true);
        imagenComidaV.setVisible(true);
        nombreproductol.setVisible(true);
        nombreNuevoProducto.setVisible(true);
        descripcionNuevoProducto.setVisible(true);
        preciolabel.setVisible(true);
        precioNuevoProducto.setVisible(true);
        Agregar.setVisible(true);
    }
}
