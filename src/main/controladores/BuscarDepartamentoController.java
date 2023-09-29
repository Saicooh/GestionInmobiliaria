package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Departamento;
import src.main.model.Edificio;
import src.main.resources.excepciones.NoDepartamentoException;

import java.io.IOException;

public class BuscarDepartamentoController
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

            Departamento departamentoAuxiliar = edificioActual.buscarDepartamento(numero);

            String datosDepartamento = departamentoAuxiliar.getInformacionCompleta();
            datosDepartamentoLabel2.setText("Resultados:");
            datosDepartamentoLabel.setText(datosDepartamento);

            Stage stage = (Stage) buscarButton.getScene().getWindow();
            stage.show();
        }
        catch (NumberFormatException e)
        {
            if (numeroDepartamentoField.getText().isEmpty())
            {
                ManejadorExcepciones.handleException(new Exception("Error"), "El número de departamento no puede estar vacío.");
                datosDepartamentoLabel2.setText("Ingresa un departamento válido");
            }
            else ManejadorExcepciones.handleException(new Exception("Error"), "El número de departamento debe ser un número.");
        }
        catch (NoDepartamentoException e)
        {
            ManejadorExcepciones.handleException(new Exception("Error"), e.getMessage());
            datosDepartamentoLabel2.setText("Resultados:");
            datosDepartamentoLabel.setText("Departamento no encontrado.");
        }

    }

    public void setEdificioActual(Edificio edificio)
    {
        this.edificioActual = edificio;
    }
}