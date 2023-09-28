package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

public class AgregarDepartamentoController
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
            if (cantidadDepartamentos.isEmpty() || cantidadHabitaciones.isEmpty() || tipoDeDepartamentoComboBox.getSelectionModel().getSelectedItem() == null)
            {
                throw new FaltaDatosException("Por favor ingresa todos los datos.");
            }

            if (Integer.parseInt(cantidadDepartamentos) < 1 || Integer.parseInt(cantidadHabitaciones) < 1)
            {
                throw new ArgumentoIlegalException("Por favor ingresa un número válido.");
            }

            edificioActual.agregarDepartamento(Integer.parseInt(cantidadDepartamentos), Integer.parseInt(cantidadHabitaciones), nombreTipo);

            Stage stage = (Stage) agregarDepartamentoButton.getScene().getWindow();
            stage.close();

            if (cantidadDepartamentos.equals("1")) UtilidadAlertas.alertaInformacion("Departamento agregado", "El departamento ha sido agregado correctamente.");
            else UtilidadAlertas.alertaInformacion("Departamentos agregados", "Los departamentos han sido agregados correctamente.");

            Sistema.guardarEnCSV(Constantes.getCSV());

        }
        catch (FaltaDatosException | ArgumentoIlegalException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), e.getMessage());
        }
        catch (NumberFormatException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "La cantidad de departamentos y habitaciones debe ser un número entero.");
        }
        catch (IOException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "No se pudo guardar el departamento.");
        }
    }

}
