package src.main.controladores;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ManejadorExcepciones
{

    public static void handleException(Exception e, String mensajeUsuario)
    {
        showAlert(mensajeUsuario);
    }

    private static void showAlert(String mensaje)
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
