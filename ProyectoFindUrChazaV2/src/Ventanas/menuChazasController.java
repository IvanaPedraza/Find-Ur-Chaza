package Ventanas;

import Logica.*;
import Modelo.Chaza;
import Modelo.Cliente;
import Ventanas.*;
import Modelo.Chaza;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;



public class menuChazasController implements Initializable{
    
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    public static Chaza chazaEscogida = new Chaza();
    public Mensaje mensaje = new Mensaje();
    
    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button botonChazas;

    @FXML
    private GridPane grid;

    @FXML
    private Button botonOrdenesCliente;

    @FXML
    private ImageView inicioSesion;

    @FXML
    private Label labelDatosCliente;

    @FXML
    private AnchorPane panel;

    @FXML
    private ScrollPane scroll;

    @FXML
    void retornarInicioSesion(MouseEvent event) {

    }

    @FXML
    void verChazas(MouseEvent event) {

    }

    @FXML
    void verInfoCliente(MouseEvent event) {

    }

    @FXML
    void verOrdenesCliente(MouseEvent event) {

    }
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

    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        chazas.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < chazas.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                chazasController ChazasController = fxmlLoader.getController();
                ChazasController.setData(chazas.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
