package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import src.main.model.Departamento;
import src.main.model.Edificio;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoDepartamentoException;

public class BuscarDepartamentoController implements ControladorConEdificio
{

    @FXML
    private Button buscarButton;

    @FXML
    private TextField numeroDepartamentoField;

    @FXML
    private Label datosDepartamentoLabel;

    @FXML
    private Label datosDepartamentoLabel2;

    private Edificio edificioActual;

    @FXML
    private void buscarDepartamento()
    {
        try
        {
            int numero = Integer.parseInt(numeroDepartamentoField.getText());

            if (numeroDepartamentoField.getText().isEmpty()) throw new FaltaDatosException();

            Departamento departamentoAuxiliar = edificioActual.buscarDepartamento(numero);

            String datosDepartamento = departamentoAuxiliar.getInformacionCompleta();
            datosDepartamentoLabel2.setText("Resultados:");
            datosDepartamentoLabel.setText(datosDepartamento);

            Stage stage = (Stage) buscarButton.getScene().getWindow();
            stage.show();
        }
        catch (NumberFormatException e)
        {
            UtilidadAlertas.alertaError("Error", "El número de departamento debe ser un número entero.");
        }
        catch (NoDepartamentoException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
            datosDepartamentoLabel2.setText("Resultados:");
            datosDepartamentoLabel.setText("Departamento no encontrado.");
        }
        catch (FaltaDatosException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
            datosDepartamentoLabel2.setText("Ingresa un departamento válido");
        }

    }

    public void setEdificioActual(Edificio edificio)
    {
        this.edificioActual = edificio;
    }
}