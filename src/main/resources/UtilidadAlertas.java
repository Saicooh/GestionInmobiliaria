package src.main.resources;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public final class UtilidadAlertas
{
    private UtilidadAlertas() {}

    public static void alertaInformacion(String header, String mensaje)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(header);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
