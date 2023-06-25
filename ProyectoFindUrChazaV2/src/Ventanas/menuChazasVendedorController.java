package Ventanas;

import EstructurasDeDatos.AVLChaza;
import EstructurasDeDatos.NodeChaza;
import Logica.*;
import Modelo.Cliente;
import Modelo.Chaza;
import Modelo.Orden;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

public class menuChazasVendedorController implements Initializable {

    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog(); 
    public static Chaza chazaEscogida = new Chaza();
    public Mensaje mensaje = new Mensaje();

    private ObservableList<Chaza> cardListChaza = FXCollections.observableArrayList();

    @FXML
    private ImageView Fondo;
    
    @FXML
    private ImageView fotoPerfilV;

    @FXML
    private Button botonTusChazas;

    @FXML
    private AnchorPane panel;
    
    @FXML
    private AnchorPane panel2;
    
    @FXML
    private AnchorPane panel3;

    @FXML
    private ImageView michiHamborgueso;
    
    @FXML
    private ImageView findUrChaza;
    
    @FXML
    private ScrollPane scrollGridPane;
    
    @FXML
    private GridPane chaza_gridPane;
    
    @FXML
    private Label labelDatosVendedor;
    
    
    @FXML
    void retornarInicioSesion(MouseEvent event) throws IOException {
        App.setRoot("InicioSesion");
    }

    @FXML
    void verInfoVendedor(MouseEvent event) throws IOException {
        App.setRoot("DatosDelUsuarioVendedor");
    }

    /*
    private List<Chaza> chazas = new ArrayList<>();

    private List<Chaza> getData() {
        List<Chaza> chazas = new ArrayList<>();
        Chaza chaza;
        for (int i = 0; i < 20; i++) {

            chaza = new Chaza();
            chaza.setNombreChaza("Kiwi");
            chaza.setImgSrc("/Imagenes/Tiendav.png");
            chazas.add(chaza);
        }

        return chazas;
    }*/

     
    
    public ObservableList<Chaza> chazaGetData() {
        ObservableList<Chaza> listChaza = FXCollections.observableArrayList();
        Chaza[] chazas = controladorChaza.buscarChazasPorVendedor(vendedorActual);

        for (int i = 0; i < chazas.length; i++) {
            listChaza.add(chazas[i]);
        }

        return listChaza;

    }

    public void chazaDisplayCard() {
        cardListChaza.clear();
        cardListChaza.addAll(chazaGetData());

        int row = 0;
        int column = 0;
        chaza_gridPane.getChildren().clear();
        chaza_gridPane.getRowConstraints().clear();
        chaza_gridPane.getColumnConstraints().clear();
        for (int i = 0; i < cardListChaza.size(); i++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("ChazasVendedor.fxml"));
                AnchorPane pane = load.load();
                chazasVendedorController cardC = load.getController();
                cardC.setData(cardListChaza.get(i));

                if (column == 4) {
                    column = 0;
                    row += 1;
                }

                chaza_gridPane.add(pane, column++, row);
                
                GridPane.setMargin(pane, new Insets(10));
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }

    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelDatosVendedor.setVisible(true);
        Fondo.setVisible(true);
        fotoPerfilV.setVisible(true);
        botonTusChazas.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);
        michiHamborgueso.setVisible(true);
        findUrChaza.setVisible(true);
        chaza_gridPane.setVisible(true);
        panel.setVisible(true);
        scrollGridPane.setVisible(true);
        labelDatosVendedor.setText("¡Bienvenido " + vendedorActual.getNombre() + " " + vendedorActual.getApellido() + "!");
        chazaDisplayCard();
    }
}
