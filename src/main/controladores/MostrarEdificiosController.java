package src.main.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import src.main.model.Edificio;

import java.util.ArrayList;

public class MostrarEdificiosController
{

    @FXML
    private VBox edificiosContainer;

    public void mostrarEdificios(ArrayList<Edificio> listaEdificios)
    {
        if (listaEdificios.isEmpty())
        {
            Label noEdificiosLabel = new Label("No hay edificios.");
            edificiosContainer.getChildren().add(noEdificiosLabel);
        }
        else for (Edificio edificio : listaEdificios)
        {
                Label edificioLabel = new Label(edificio.getInformacionCompleta());
                edificiosContainer.getChildren().add(edificioLabel);
        }
    }

    @FXML
    private void cerrarVentana()
    {
        Stage stage = (Stage) edificiosContainer.getScene().getWindow();
        stage.close();
    }
}
