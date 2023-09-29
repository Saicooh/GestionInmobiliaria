package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.main.model.Departamento;

import java.util.ArrayList;
import java.util.Comparator;

public class MostrarDepartamentosController
{

    public VBox departamentosContainer;

    public void mostrarDepartamentos(ArrayList<Departamento> listaDepartamentos)
    {
        listaDepartamentos.sort(Comparator.comparingInt(Departamento::getNumero));

        if (listaDepartamentos.isEmpty())
        {
            Label noEdificiosLabel = new Label("No hay departamentos.");
            departamentosContainer.getChildren().add(noEdificiosLabel);
        }
        else for (Departamento departamento : listaDepartamentos)
        {
            Label departamentoLabel = new Label(departamento.getInformacionCompleta());
            departamentosContainer.getChildren().add(departamentoLabel);
        }
    }

    @FXML
    private void cerrarVentana()
    {
        Stage stage = (Stage) departamentosContainer.getScene().getWindow();
        stage.close();
    }
}
