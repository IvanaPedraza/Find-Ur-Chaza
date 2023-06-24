package Ventanas;

import EstructurasDeDatos.AVLChaza;
import EstructurasDeDatos.NodeChaza;
import Logica.*;
import Modelo.Cliente;
import Modelo.Chaza;
import Modelo.Orden;
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

public class menuChazasController implements Initializable {

    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Cliente clienteActual = InicioSesionController.getClienteLog(); 
    public static Chaza chazaEscogida = new Chaza();
    public Mensaje mensaje = new Mensaje();

    private ObservableList<Chaza> cardListChaza = FXCollections.observableArrayList();

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button botonChazas;

    @FXML
    private AnchorPane chaza_form;

    @FXML
    private GridPane chaza_gridPane;

    @FXML
    private ImageView inicioSesion;

    @FXML
    private Label labelDatosCliente;

    @FXML
    private AnchorPane panel;

    @FXML
    private ScrollPane scrollGridPane;

    @FXML
    void retornarInicioSesion(MouseEvent event) throws IOException {
        App.setRoot("InicioSesion");
    }

    @FXML
    void verChazas(MouseEvent event) {

    }

    @FXML
    void verInfoCliente(MouseEvent event) throws IOException {
        App.setRoot("DatosDelUsuarioCliente");
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
    }

     */
    public ObservableList<Chaza> chazaGetData() {
        ObservableList<Chaza> listChaza = FXCollections.observableArrayList();
        Chaza[] chazas = controladorChaza.totalChazas();

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
                load.setLocation(getClass().getResource("Chazas.fxml"));
                AnchorPane pane = load.load();
                chazasController cardC = load.getController();
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
        Wallpaper.setVisible(true);
        botonChazas.setVisible(true);
        chaza_form.setVisible(true);
        chaza_gridPane.setVisible(true);
        inicioSesion.setVisible(true);
        labelDatosCliente.setVisible(true);
        panel.setVisible(true);
        scrollGridPane.setVisible(true);
        labelDatosCliente.setText("¡Bienvenido " + clienteActual.getNombre() + " " + clienteActual.getApellido() + "!");
        chazaDisplayCard();

    }
}
