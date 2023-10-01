package src.main.controladores;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import src.main.model.Departamento;
import src.main.model.Edificio;
import src.main.resources.GeneradorXLSX;
import src.main.model.Sistema;
import src.main.resources.UtilidadAlertas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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

        listaFiltrada = Edificio.filtrarPorDisponibilidad(listaFiltrada, disponibilidadChoiceBox.getValue());

        actualizarTabla(listaFiltrada);
    }

    @FXML
    private void cerrarVentana()
    {
        Stage stage = (Stage) tablaDepartamentos.getScene().getWindow();
        stage.close();
    }

    public String solicitarNombreArchivo()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nombre del Archivo");
        dialog.setHeaderText("Ingresa el nombre para la planilla:");
        dialog.setContentText("Nombre:");

        HBox hBox = new HBox(10);
        TextField inputField = new TextField();
        inputField.setText("nombre_default");
        Label suffixLabel = new Label(".xlsx");
        hBox.getChildren().addAll(inputField, suffixLabel);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        dialog.getDialogPane().setContent(hBox);

        Optional<String> resultado = dialog.showAndWait();

        if (resultado.isEmpty()) return null;

        if (inputField.getText().isEmpty())
        {
            UtilidadAlertas.alertaError("Error", "No se ha ingresado un nombre para el archivo.");
            return null;
        }

        return inputField.getText() + ".xlsx"; // Obtener el valor del TextField personalizado
    }

    public void exportarExcel() throws IOException
    {
        String nombreArchivo = solicitarNombreArchivo();
        if (nombreArchivo != null)
        {
            GeneradorXLSX.generarArchivoXLSX(Sistema.getListaEdificios(), nombreArchivo);
            UtilidadAlertas.alertaInformacion("Éxito", "La plantilla ha sido exitosamente generada con el nombre " + nombreArchivo + "." );
        }
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
