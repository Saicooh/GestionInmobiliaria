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

public class EliminarDepartamentoController implements ControladorConEdificio
{

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

            edificio.eliminarDepartamento(numero);

            UtilidadAlertas.alertaInformacion("Departamento eliminado", "El departamento ha sido eliminado exitosamente.");

            Stage stage = (Stage) numeroDepartamentoTextField.getScene().getWindow();
            stage.close();

        }
        catch (NumberFormatException e)
        {
            UtilidadAlertas.alertaError("Error", "El número de departamento debe ser un número entero.");
            return;
        }
        catch (NoDepartamentoException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
            return;
        }

        Sistema.guardarEnCSV(Constantes.getCSV());
    }

    @Override
    public void setEdificioActual(Edificio edificio)
    {
        this.edificio = edificio;
    }
}