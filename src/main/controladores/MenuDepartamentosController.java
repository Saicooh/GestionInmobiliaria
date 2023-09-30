package src.main.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoEdificioException;

import java.io.IOException;
import java.util.function.Consumer;

public class MenuDepartamentosController
{
    private Edificio edificio;
    @FXML
    public TextField nombreEdTextField;

    private void operacionDepartamento(String fxmlResource, String titulo, Consumer<ControladorConEdificio> configuracion)
    {
        try
        {
            validarNombreEdificio();
            edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            ControladorConEdificio controller = mostrarVentana(fxmlResource, titulo);
            configuracion.accept(controller);
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
        }
    }
    @FXML
    private Edificio obtenerEdificioValidado(String nombre) throws NoEdificioException, FaltaDatosException
    {
        Edificio edificioAux = Sistema.buscarEdificio(nombre);

        if (nombre.isEmpty()) throw new FaltaDatosException();

        return edificioAux;
    }

    private <T> T mostrarVentana(String fxmlResource, String titulo) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlResource));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(new Scene(root));
        stage.setWidth(616);
        stage.setHeight(439);
        stage.show();

        return loader.getController();
    }

    private void validarNombreEdificio() throws FaltaDatosException
    {
        if (nombreEdTextField.getText().isEmpty()) throw new FaltaDatosException();
    }

    @FXML
    private void agregarDepartamento()
    {
        operacionDepartamento(Constantes.getAgregarDepartamentos(), "Agregar Departamento", controller -> controller.setEdificioActual(edificio));
    }

    public void buscarDepartamento()
    {
        operacionDepartamento(Constantes.getBuscarDepartamentos(), "Buscar Departamento", controller -> controller.setEdificioActual(edificio));
    }

    @FXML
    private void eliminarDepartamento()
    {
        operacionDepartamento(Constantes.getEliminarDepartamentos(), "Eliminar Departamento", controller -> controller.setEdificioActual(edificio));
    }

    @FXML
    private void mostrarDepartamentos()
    {
        try
        {
            validarNombreEdificio();
            Edificio edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            MostrarDepartamentosController mostrar = mostrarVentana(Constantes.getMostrarDepartamentos(), "Mostrar Departamentos");
            mostrar.mostrarDepartamentos(edificio.getDepartamentos());
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
        }
    }

    @FXML
    private void editarDepartamento()
    {
        operacionDepartamento(Constantes.getEditarDepartamento(), "Editar Departamento", controller -> controller.setEdificioActual(edificio));
    }

    public void volver()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Constantes.getMenuPrincipal()));
            Parent root = loader.load();

            Stage stageActual = (Stage) nombreEdTextField.getScene().getWindow();
            stageActual.setWidth(816);
            stageActual.setHeight(639);

            stageActual.setScene(new Scene(root));
        }
        catch (IOException e)
        {
            UtilidadAlertas.alertaError("Error", "No se pudo volver al menú principal.");
        }
    }

}
