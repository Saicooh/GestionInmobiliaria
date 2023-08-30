import java.io.*;
import java.util.*;

public class Sistema
{
    public HashMap<String, Edificio> mapaEdificios;

    public void agregarEdificio() throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del edificio: ");
        String nombre = Lector.readLine();

        System.out.println("Ingrese la dirección del edificio: ");
        String direccion = Lector.readLine();

        System.out.println("Ingrese la demanda del edificio");
        int demanda = Integer.parseInt(Lector.readLine());

        Edificio edificio = new Edificio(nombre, direccion, demanda);

        mapaEdificios.put(nombre, edificio);

        System.out.println("Se ha guardado el edificio correctamente");
    }

    public void buscarEdificio() throws IOException
    {
        // Pedir nombre de edificio
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del edificio: ");
        String nombre = Lector.readLine();

        Edificio edificio = mapaEdificios.get(nombre);

        System.out.println("Nombre: " + edificio.getNombre());
        System.out.println("Dirección: " + edificio.getDireccion());
        System.out.println("Demanda: " + edificio.getDemanda());
        System.out.println("Cantidad de departamentos: " + edificio.getCantidadDepartamentos());
        System.out.println("Cantidad de departamentos disponibles: " + edificio.getCantidadDepartamentosDisponibles());

        // Mostrar edificio y mostrar menu de opciones

        // Si no existe, mostrar mensaje de error

        // Si existe, mostrar menu de opciones
    }

    public void eliminarEdificio() throws IOException
    {
        // Pedir nombre de edificio

        // Buscar edificio en el mapa

        // Si no existe, mostrar mensaje de error

        // Si existe, eliminar edificio del mapa y mostrar mensaje de éxito
    }

    public void mostrarEdificios(boolean disponible) throws IOException
    {
        // Mostrar todos los edificios del mapa

        // Si no hay edificios, mostrar mensaje de error
    }

    public void agregarDepartamento() throws IOException
    {
        //Pedir edificio

        // Pedir tipo de departamento

        // Pedir cantidad de habitaciones

        // Pedir precio

        // Crear departamento

        // Agregar departamento al edificio

        // Mostrar mensaje de éxito
    }

    public void buscarDepartamento() throws IOException
    {
        // Pedir número de departamento

        // Buscar departamento en el edificio

        // Si no existe, mostrar mensaje de error

        // Si existe, mostrar departamento y mostrar menu de opciones
    }

    public void eliminarDepartamento() throws IOException
    {
        // Pedir número de departamento

        // Buscar departamento en el edificio

        // Si no existe, mostrar mensaje de error

        // Si existe, eliminar departamento del edificio y mostrar mensaje de éxito
    }

    public void mostrarDepartamentos() throws IOException
    {
        // Mostrar todos los departamentos del edificio, con su tipo, precio y disponibilidad

        // Si no hay departamentos, mostrar mensaje de error
    }

    public void mostrarDepartamentosDisponibles() throws IOException
    {
        // Mostrar todos los departamentos disponibles del edificio, con su tipo y precio

        // Si no hay departamentos disponibles, mostrar mensaje de que no hay departamentos disponibles
    }
}