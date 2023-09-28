package src.main.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.main.model.Sistema;
import src.main.resources.Constantes;

import java.io.IOException;
import java.util.Objects;

public class MenuEdificioController
{
    @FXML
    private TextField nombreEdificioTextField;

    @FXML
    private Button administrarDepartamentosButton;

    private void mostrarVentana(String recursoFXML, String titulo) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(recursoFXML));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(new Scene(root));
        stage.setWidth(616);
        stage.setHeight(439);
        stage.show();
    }
    @FXML
    private void agregarEdificio()
    {
        try { mostrarVentana(Constantes.getAgregarEdificio(), "Agregar Edificio"); }
        catch (Exception e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorOpcion());}
    }

    @FXML
    private void buscarEdificio()
    {
        try { mostrarVentana(Constantes.getBuscarEdificio(), "Buscar Edificio"); }
        catch (Exception e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorOpcion());}
    }

    @FXML
    private void eliminarEdificio()
    {
        try { mostrarVentana(Constantes.getEliminarEdificio(), "Eliminar Edificio"); }
        catch (Exception e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorOpcion());}
    }

    @FXML
    private void mostrarEdificios()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.getMostrarEdificios()));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Mostrar Edificios");
            stage.setScene(new Scene(root));

            stage.setWidth(616); stage.setHeight(439);

            MostrarEdificiosController controller = loader.getController();
            controller.mostrarEdificios(Sistema.getListaEdificios());

            stage.show();
        }
        catch (Exception e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorOpcion());}
    }

    @FXML
    private void administrarDepartamentos() throws IOException
    {
        Parent nuevoContenido = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(Constantes.getAdministrarDepartamentos())));

        Stage stageActual = (Stage) administrarDepartamentosButton.getScene().getWindow();

        Scene nuevaEscena = new Scene(nuevoContenido, 800, 600);
        stageActual.setScene(nuevaEscena);
    }

    @FXML
    private void inicio()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.getInicio()));
            Parent root = loader.load();

            // Configura el controlador de la vista principal si es necesario
            MenuController mainMenuController = loader.getController();
            Stage stage = MenuController.getPrimaryStage(); // Obtiene la referencia a la escena principal

            mainMenuController.setPrimaryStage(stage); // Pasa la referencia a la escena principal

            Scene scene = new Scene(root);

            stage.setWidth(816); stage.setHeight(639);

            stage.setScene(scene);
        }
        catch (Exception e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorIngresar()); }
    }
}
