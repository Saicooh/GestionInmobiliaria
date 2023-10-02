package src.main.model;

import src.main.controladores.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.main.resources.Constantes;

public class GestionInmobiliaria extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Carga el archivo FXML del menú principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.getInicio()));
        Parent root = loader.load();

        // Obtén una referencia al controlador del menú principal
        MenuController mainMenuController = loader.getController();

        primaryStage.setTitle("Gestión Inmobiliaria");
        primaryStage.setScene(new Scene(root, 800, 600));

        primaryStage.setResizable(false);
        primaryStage.show();

        // Puedes pasar una referencia de la ventana principal al controlador del menú principal si es necesario
        mainMenuController.setPrimaryStage(primaryStage);
    }

    public static void main(String[] args)
    {
        Sistema.inicializarCSV(Constantes.getCSV());
        Sistema.datosIniciales();
        launch(args);
    }
}
