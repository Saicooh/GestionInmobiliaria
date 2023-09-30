package src.main.controladores;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Edificio;

import java.util.ArrayList;

public class MostrarEdificiosController
{
    @FXML
    public TableView<EdificioTabla> tablaEdificios;
    @FXML
    public TableColumn<EdificioTabla, String> columnaNombre;
    @FXML
    public TableColumn<EdificioTabla, String> columnaDireccion;
    @FXML
    public TableColumn<EdificioTabla, String> columnaDemanda;
    @FXML
    public TableColumn<EdificioTabla, String> columnaCantidadDepartamentos;
    @FXML
    public TableColumn<EdificioTabla, String> columnaCantidadDepartamentosDisponibles;
    @FXML
    public TableColumn<EdificioTabla, String> columnaCantidadDepartamentosNoDisponibles;

    @FXML
    private TextField minDemandaField;
    @FXML
    private TextField maxDemandaField;

    private final ArrayList<Edificio> listaOriginalDeEdificios = new ArrayList<>();

    public void mostrarEdificios(ArrayList<Edificio> listaEdificios)
    {
        listaOriginalDeEdificios.addAll(listaEdificios);

        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        columnaDireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        columnaDemanda.setCellValueFactory(cellData -> cellData.getValue().demandaProperty());
        columnaCantidadDepartamentos.setCellValueFactory(cellData -> cellData.getValue().cantidadDepartamentosProperty());
        columnaCantidadDepartamentosDisponibles.setCellValueFactory(cellData -> cellData.getValue().cantidadDepartamentosDisponiblesProperty());
        columnaCantidadDepartamentosNoDisponibles.setCellValueFactory(cellData -> cellData.getValue().cantidadDepartamentosNoDisponiblesProperty());

        for (Edificio edificio : listaEdificios)
            tablaEdificios.getItems().add(new EdificioTabla(edificio));
    }

    @FXML
    private void filtrarPorDemanda()
    {
        double minDemanda = Double.parseDouble(minDemandaField.getText());
        double maxDemanda = Double.parseDouble(maxDemandaField.getText());

        ArrayList<Edificio> listaFiltrada = new ArrayList<>();

        for (Edificio edificio : listaOriginalDeEdificios)
        {
            if (edificio.getDemanda() >= minDemanda && edificio.getDemanda() <= maxDemanda) listaFiltrada.add(edificio);
        }

        actualizarTabla(listaFiltrada);
    }

    private void actualizarTabla(ArrayList<Edificio> lista)
    {
        tablaEdificios.getItems().clear();
        for (Edificio edificio : lista)
            tablaEdificios.getItems().add(new EdificioTabla(edificio));
    }

    @FXML
    private void cerrarVentana()
    {
        Stage stage = (Stage) tablaEdificios.getScene().getWindow();
        stage.close();
    }

    public static class EdificioTabla
    {
        private final SimpleStringProperty nombre;
        private final SimpleStringProperty direccion;
        private final SimpleStringProperty demanda;
        private final SimpleStringProperty cantidadDepartamentos;

        private final SimpleStringProperty cantidadDepartamentosDisponibles;
        private final SimpleStringProperty cantidadDepartamentosNoDisponibles;

        public EdificioTabla(Edificio edificio)
        {
            this.nombre = new SimpleStringProperty(edificio.getNombre());
            this.direccion = new SimpleStringProperty(edificio.getDireccion());
            this.demanda = new SimpleStringProperty(String.valueOf(edificio.getDemanda()));
            this.cantidadDepartamentos = new SimpleStringProperty(String.valueOf(edificio.getCantidadDepartamentos()));
            this.cantidadDepartamentosDisponibles = new SimpleStringProperty(String.valueOf(edificio.getCantidadDepartamentosDisponibles()));
            this.cantidadDepartamentosNoDisponibles = new SimpleStringProperty(String.valueOf(edificio.getCantidadDepartamentosNoDisponibles()));
        }

        public String getNombre() {
            return nombre.get();
        }

        public SimpleStringProperty nombreProperty() {
            return nombre;
        }

        public String getDireccion() {
            return direccion.get();
        }

        public SimpleStringProperty direccionProperty() {
            return direccion;
        }

        public SimpleStringProperty demandaProperty() {
            return demanda;
        }


        public SimpleStringProperty cantidadDepartamentosProperty() {
            return cantidadDepartamentos;
        }

        public ObservableValue<String> cantidadDepartamentosDisponiblesProperty()
        {
            return cantidadDepartamentosDisponibles;
        }

        public ObservableValue<String> cantidadDepartamentosNoDisponiblesProperty()
        {
            return cantidadDepartamentosNoDisponibles;
        }
    }
}
