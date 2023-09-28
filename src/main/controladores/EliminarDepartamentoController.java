package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.NoDepartamentoException;

import java.io.IOException;

public class EliminarDepartamentoController {

    @FXML
    private Button eliminarDepartamentoButton;
    @FXML
    private TextField numeroDepartamentoTextField;

    private Edificio edificio;

    public void setEdificio(Edificio edificio){
        this.edificio = edificio;
    }

    @FXML
    private void eliminarDepartamento() throws IOException
    {
        try
        {
            int numero = Integer.parseInt(numeroDepartamentoTextField.getText());

            boolean eliminado = edificio.eliminarDepartamento(numero);

            if (eliminado) UtilidadAlertas.alertaInformacion("Departamento eliminado", "El departamento ha sido eliminado exitosamente.");
            else throw new NoDepartamentoException("El departamento '" + numero + "' no existe.");

            Stage stage = (Stage) numeroDepartamentoTextField.getScene().getWindow();
            stage.close();

        }
        catch (NumberFormatException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), "Por favor ingresa un número válido.");
            return;
        }
        catch (NoDepartamentoException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), e.getMessage());
            return;
        }

        Sistema.guardarEnCSV(Constantes.getCSV());
    }
}