package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import src.main.model.Departamento;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.excepciones.ArgumentoDuplicadoException;
import src.main.resources.excepciones.NoDepartamentoException;

import java.io.IOException;

public class EditarAtributosDeptoController
{
    @FXML
    private Button btnGuardar;
    @FXML
    private ChoiceBox<String> tipoChoiceBox;
    @FXML
    private Label feedbackLabel;
    @FXML
    private TextField numeroField;
    @FXML
    private TextField numeroDepartamentoField, cantidadHabitacionesField;
    @FXML
    private ChoiceBox<String> disponibleChoiceBox;
    @FXML
    private VBox formularioEdicion;
    private Edificio edificioActual;

    public void buscarYMostrarDepartamento()
    {
        try
        {
            int numero = Integer.parseInt(numeroDepartamentoField.getText());

            Departamento depto = edificioActual.buscarDepartamento(numero);
            numeroField.setText(String.valueOf(depto.getNumero()));
            numeroDepartamentoField.setText(String.valueOf(depto.getNumero()));
            cantidadHabitacionesField.setText(String.valueOf(depto.getCantidadHabitaciones()));
            disponibleChoiceBox.setValue(depto.getDisponible());
            tipoChoiceBox.setValue(depto.getNombreTipo());
            feedbackLabel.setText("");

            formularioEdicion.setVisible(true);
        }
        catch (NumberFormatException e)
        {
            feedbackLabel.setText("El número de departamento debe ser un número entero.");
        }
        catch (NoDepartamentoException e)
        {
            feedbackLabel.setText(e.getMessage());
        }
    }

    public void guardarCambios() throws IOException
    {
        try
        {
            int numero = Integer.parseInt(numeroDepartamentoField.getText());

            int nuevoNumero = Integer.parseInt(numeroField.getText());

            int cantHabitaciones = Integer.parseInt(cantidadHabitacionesField.getText());

            feedbackLabel.setText("Cambios guardados con éxito");

            edificioActual.editarDepartamento(numero, nuevoNumero, cantHabitaciones, tipoChoiceBox.getValue(), disponibleChoiceBox.getValue());

            Sistema.guardarEnCSV(Constantes.getCSV());

        }
        catch (NumberFormatException e)
        {
            feedbackLabel.setText("Por favor, ingrese solo números en los campos de número y cantidad de habitaciones.");
        }
        catch (NoDepartamentoException | ArgumentoDuplicadoException e)
        {
            feedbackLabel.setText(e.getMessage());
        }
    }

    public void setEdificio(Edificio edificio)
    {
        this.edificioActual = edificio;
    }
}

