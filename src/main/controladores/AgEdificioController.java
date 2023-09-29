package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.ArgumentoDuplicadoException;

import java.io.IOException;

public class AgEdificioController
{

    @FXML
    private TextField nombreEdificioTextField;

    @FXML
    private TextField direccionTextField;

    @FXML
    private TextField demandaTextField;

    @FXML
    private Button agregarButton;

    @FXML
    private void agregarEdificio()
    {
        // Obtén los valores del nombre del edificio y el número de pisos desde los campos de texto
        String nombreEdificio = nombreEdificioTextField.getText();
        String direccion = direccionTextField.getText();
        String demanda = demandaTextField.getText();

        // Validación simple: Verifica que los campos no estén vacíos
        if (nombreEdificio.isEmpty() || direccion.isEmpty() || demanda.isEmpty())
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "Por favor, ingresa todos los datos.");
            return;
        }

        try
        {
            Sistema.agregarEdificio(nombreEdificio, direccion, Integer.parseInt(demanda));

            Stage stage = (Stage) agregarButton.getScene().getWindow();
            stage.close();

            UtilidadAlertas.alertaInformacion("Edificio agregado", "El edificio ha sido agregado correctamente.");

            Sistema.guardarEnCSV(Constantes.getCSV());
        }
        catch (NumberFormatException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "La demanda debe ser un número entero.");
        }
        catch (IOException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "No se pudo guardar el edificio.");
        }
        catch (ArgumentoDuplicadoException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), e.getMessage());
        }
    }
}
