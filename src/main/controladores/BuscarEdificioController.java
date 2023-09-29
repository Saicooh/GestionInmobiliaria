package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoEdificioException;

public class BuscarEdificioController
{

    @FXML
    private Button buscarButton;

    @FXML
    private TextField nombreEdificioField;

    @FXML
    private Label datosEdificioLabel;

    @FXML
    private Label datosEdificioLabel2;

    @FXML
    public void buscarEdificio()
    {
        try
        {
            String nombreEdificio = nombreEdificioField.getText();

            if (nombreEdificio.isEmpty()) throw new FaltaDatosException();

            Edificio edificioAuxiliar = Sistema.buscarEdificio(nombreEdificio);

            String datosEdificio = edificioAuxiliar.getInformacionCompleta();
            datosEdificioLabel2.setText("Resultados:");
            datosEdificioLabel.setText(datosEdificio);

            Stage stage = (Stage) buscarButton.getScene().getWindow();
            stage.show();
        }
        catch (NoEdificioException | FaltaDatosException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
        }

    }
}