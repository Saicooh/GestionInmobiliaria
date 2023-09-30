package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoEdificioException;

import java.io.IOException;

public class EliminarEdificioController
{

    @FXML
    private Button eliminarButton;
    @FXML
    private TextField nombreEdificioTextField;

    @FXML
    private void eliminarEdificio() throws IOException
    {
        String nombreEdificio = nombreEdificioTextField.getText();

        try
        {
            if (nombreEdificio.isEmpty()) throw new FaltaDatosException();
        }
        catch (FaltaDatosException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
            return;
        }

        Edificio edificio;

        try { edificio = Sistema.buscarEdificio(nombreEdificio); }
        catch (NoEdificioException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
            return;
        }

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Edificio");
        alert.setHeaderText("Información del Edificio:");
        alert.setContentText("Nombre: " + edificio.getNombre() + "\nDirección: " + edificio.getDireccion() + "\n¿Deseas eliminar este edificio?");

        ButtonType btnSi = new ButtonType("Sí");
        ButtonType btnNo = new ButtonType("No");
        alert.getButtonTypes().setAll(btnSi, btnNo);

        if (alert.showAndWait().get() == btnSi)
        {
            Sistema.eliminarEdificio(edificio);
            UtilidadAlertas.alertaInformacion("Edificio eliminado", "El edificio ha sido eliminado correctamente.");
        }

        Sistema.guardarEnCSV(Constantes.getCSV());
    }
}
