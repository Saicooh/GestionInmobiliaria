package src.main.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import src.main.model.Edificio;
import src.main.model.Sistema;
import src.main.resources.Constantes;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoEdificioException;

import java.io.IOException;

public class MenuDepartamentosController
{
    @FXML
    public TextField nombreEdTextField;

    @FXML
    private Edificio obtenerEdificioValidado(String nombre) throws NoEdificioException, FaltaDatosException
    {
        Edificio edificioAux = Sistema.buscarEdificio(nombre);

        if (nombre.isEmpty()) throw new FaltaDatosException("El nombre del edificio no puede estar vacío.");

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

    public void agregarDepartamento()
    {
        try
        {
            Edificio edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            AgregarDepartamentoController controller = mostrarVentana(Constantes.getAgregarDepartamentos(), "Agregar Departamento");
            controller.setEdificioActual(edificio);
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            ManejadorExcepciones.handleException(e, e.getMessage());
        }
    }

    public void buscarDepartamento()
    {
        try
        {
            Edificio edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            BuscarDepartamentoController buscar = mostrarVentana(Constantes.getBuscarDepartamentos(), "Buscar Departamento");
            buscar.setEdificioActual(edificio);
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            ManejadorExcepciones.handleException(e, e.getMessage());
        }
    }

    @FXML
    private void eliminarDepartamento()
    {
        try
        {
            Edificio edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            EliminarDepartamentoController eliminar = mostrarVentana(Constantes.getEliminarDepartamentos(), "Eliminar Departamento");
            eliminar.setEdificio(edificio);
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            ManejadorExcepciones.handleException(e, e.getMessage());
        }
    }

    @FXML
    private void mostrarDepartamentos()
    {
        try
        {
            Edificio edificio = obtenerEdificioValidado(nombreEdTextField.getText());
            MostrarDepartamentosController mostrar = mostrarVentana(Constantes.getMostrarDepartamentos(), "Mostrar Departamentos");
            mostrar.mostrarDepartamentos(edificio.getDepartamentos());
        }
        catch (NoEdificioException | FaltaDatosException | IOException e)
        {
            ManejadorExcepciones.handleException(e, e.getMessage());
        }
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
            ManejadorExcepciones.handleException(e, "Error al volver a la vista anterior.");
        }
    }

}
