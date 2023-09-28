package src.main.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import src.main.resources.Constantes;

import java.io.IOException;

public class MenuController
{
    private static Stage primaryStage;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnSalir;
    @FXML
    private ImageView logoImageView;

    @FXML
    private void ingresarAlSistema()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.getMenuPrincipal()));
            Parent root = loader.load();

            Scene currentScene = primaryStage.getScene();
            currentScene.setRoot(root);

        }
        catch (IOException e) { ManejadorExcepciones.handleException(new Exception("Error"), Constantes.getErrorIngresar()); }
    }

    @FXML
    private void salir()
    {
        primaryStage.close();
        System.exit(0);
    }

    public static Stage getPrimaryStage() { return primaryStage; }

    public void setPrimaryStage(Stage primaryStage) { MenuController.primaryStage = primaryStage; }
}
