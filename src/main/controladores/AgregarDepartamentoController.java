package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.ArgumentoIlegalException;
import src.main.resources.excepciones.FaltaDatosException;

import java.io.IOException;

public class AgregarDepartamentoController implements ControladorConEdificio
{

    private Edificio edificioActual;

    @FXML
    private TextField cantDepartamentosTextField;

    @FXML
    private Button agregarDepartamentoButton;

    @FXML
    private TextField cantHabitacionesTextField;

    @FXML
    private ComboBox<String> tipoDeDepartamentoComboBox;

    @FXML
    public void initialize() {
        tipoDeDepartamentoComboBox.getItems().addAll("A", "B", "C", "D", "E");
    }

    public void setEdificioActual(Edificio edificio)
    {
        this.edificioActual = edificio;
    }

    @FXML
    private void agregarDepartamento()
    {

        String cantidadDepartamentos = cantDepartamentosTextField.getText();
        String cantidadHabitaciones = cantHabitacionesTextField.getText();
        String nombreTipo = tipoDeDepartamentoComboBox.getValue();

        try
        {
            if (cantidadDepartamentos.isEmpty() || cantidadHabitaciones.isEmpty() || tipoDeDepartamentoComboBox.getSelectionModel().getSelectedItem() == null) throw new FaltaDatosException();

            edificioActual.agregarDepartamento(Integer.parseInt(cantidadDepartamentos), Integer.parseInt(cantidadHabitaciones), nombreTipo);

            Stage stage = (Stage) agregarDepartamentoButton.getScene().getWindow();
            stage.close();

            if (cantidadDepartamentos.equals("1")) UtilidadAlertas.alertaInformacion("Departamento agregado", "El departamento ha sido agregado correctamente.");
            else UtilidadAlertas.alertaInformacion("Departamentos agregados", "Los departamentos han sido agregados correctamente.");

            Sistema.guardarEnCSV(Constantes.getCSV());
        }
        catch (ArgumentoIlegalException | FaltaDatosException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
        }
        catch (NumberFormatException e)
        {
            UtilidadAlertas.alertaError("Error", "Los campos de cantidad de departamentos y cantidad de habitaciones deben ser números enteros.");
        }
        catch (IOException e)
        {
            UtilidadAlertas.alertaError("Error", "Error al guardar en el archivo CSV.");
        }
    }

}
