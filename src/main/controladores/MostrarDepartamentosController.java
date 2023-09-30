package src.main.controladores;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import src.main.model.Departamento;

import java.util.ArrayList;

public class MostrarDepartamentosController
{

    @FXML
    public TableView<DepartamentoTabla> tablaDepartamentos;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaNumero;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaHabitaciones;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaTipo;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaDisponible;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaPrecio;
    @FXML
    public TableColumn<DepartamentoTabla, String> columnaDisponibilidad;

    @FXML
    private ChoiceBox<String> disponibilidadChoiceBox;

    @FXML
    public void initialize()
    {
        disponibilidadChoiceBox.getItems().addAll("Disponible", "No Disponible", "Todos");
        disponibilidadChoiceBox.setValue("Todos");  // Valor por defecto
    }

    private final ArrayList<Departamento> listaOriginalDeDepartamentos = new ArrayList<>();

    public void mostrarDepartamentos(ArrayList<Departamento> listaDepartamentos)
    {
        listaOriginalDeDepartamentos.addAll(listaDepartamentos);

        columnaNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
        columnaHabitaciones.setCellValueFactory(cellData -> cellData.getValue().habitacionesProperty());
        columnaTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        columnaDisponible.setCellValueFactory(cellData -> cellData.getValue().disponibleProperty());
        columnaPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());

        for (Departamento departamento : listaDepartamentos)
            tablaDepartamentos.getItems().add(new DepartamentoTabla(departamento));
    }

    @FXML

    private void actualizarTabla(ArrayList<Departamento> lista)
    {
        tablaDepartamentos.getItems().clear();

        for (Departamento departamento : lista)
            tablaDepartamentos.getItems().add(new DepartamentoTabla(departamento));
    }

    @FXML
    private void filtrar()
    {
        ArrayList<Departamento> listaFiltrada = new ArrayList<>(listaOriginalDeDepartamentos);

        filtrarPorDisponibilidad(listaFiltrada);

        actualizarTabla(listaFiltrada);
    }
    private void filtrarPorDisponibilidad(ArrayList<Departamento> lista)
    {
        String estadoSeleccionado = disponibilidadChoiceBox.getValue();

        if(!estadoSeleccionado.equals("Todos")) {
            lista.removeIf(departamento -> !departamento.getDisponible().equals(estadoSeleccionado));
        }
    }

    @FXML
    private void cerrarVentana()
    {
        Stage stage = (Stage) tablaDepartamentos.getScene().getWindow();
        stage.close();
    }

    public static class DepartamentoTabla
    {
        private final SimpleStringProperty numero;
        private final SimpleStringProperty habitaciones;
        private final SimpleStringProperty tipo;
        private final SimpleStringProperty disponible;
        private final SimpleStringProperty precio;

        public DepartamentoTabla(Departamento departamento)
        {
            this.numero = new SimpleStringProperty(String.valueOf(departamento.getNumero()));
            this.habitaciones = new SimpleStringProperty(String.valueOf(departamento.getCantidadHabitaciones()));
            this.tipo = new SimpleStringProperty(departamento.getNombreTipo());
            this.disponible = new SimpleStringProperty(departamento.getDisponible());
            this.precio = new SimpleStringProperty(String.valueOf(departamento.getPrecio()));
        }

        public String getNumero() {
            return numero.get();
        }

        public SimpleStringProperty numeroProperty() {
            return numero;
        }

        public String getHabitaciones() {
            return habitaciones.get();
        }

        public SimpleStringProperty habitacionesProperty() {
            return habitaciones;
        }

        public String getTipo() {
            return tipo.get();
        }

        public SimpleStringProperty tipoProperty() {
            return tipo;
        }

        public String getDisponible() {
            return disponible.get();
        }

        public SimpleStringProperty disponibleProperty() {
            return disponible;
        }

        public SimpleStringProperty precioProperty()
        {
            return precio;
        }
    }
}
