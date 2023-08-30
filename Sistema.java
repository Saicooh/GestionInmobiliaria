import java.io.*;
import java.util.*;

public class Sistema
{
    public static HashMap<String, Edificio> mapaEdificios = new HashMap<>();
    private static ArrayList<Edificio> listaEdificios = new ArrayList<>();

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
        listaEdificios.add(edificio);

        for (String clave : mapaEdificios.keySet()) {
            System.out.println("Clave: " + clave);
        }

        System.out.println("Se ha guardado el edificio correctamente");
    }

    public void buscarEdificio() throws IOException
    {
        // Pedir nombre de edificio
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del edificio: ");

        String nombre = Lector.readLine();

        Edificio edificio = mapaEdificios.get(nombre);

        if (edificio != null)
        {
            System.out.println("Nombre: " + edificio.getNombre());
            System.out.println("Dirección: " + edificio.getDireccion());
            System.out.println("Demanda: " + edificio.getDemanda());
            System.out.println("Cantidad de departamentos: " + edificio.getCantidadDepartamentos());
            System.out.println("Cantidad de departamentos disponibles: " + edificio.getCantidadDepartamentosDisponibles());
        }
        else
        {
            System.out.println("El edificio no existe en el mapa.");
            // Mostrar mensaje de error
        }
    }

    public void eliminarEdificio() throws IOException
    {
        // Pedir nombre de edificio
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del edificio: ");

        String nombre = Lector.readLine();

        Edificio edificio = mapaEdificios.get(nombre);

        if (edificio != null)
        {
            mapaEdificios.remove(nombre);
            listaEdificios.remove(edificio);

            System.out.println("Se ha eliminado el edificio correctamente");
        }
        else
        {
            System.out.println("El edificio no existe en el mapa.");
        }
    }

    public void mostrarEdificios() throws IOException
    {
        if (listaEdificios.isEmpty())
        {
            System.out.println("No hay edificios");
            return;
        }

        for (Edificio edificio : listaEdificios)
        {
            System.out.println("Nombre: " + edificio.getNombre());
            System.out.println("Dirección: " + edificio.getDireccion());
            System.out.println("Demanda: " + edificio.getDemanda());
            System.out.println("Cantidad de departamentos: " + edificio.getCantidadDepartamentos());
            System.out.println("Cantidad de departamentos disponibles: " + edificio.getCantidadDepartamentosDisponibles());
        }

        // Si no hay edificios, mostrar mensaje de error
    }

    public void agregarDepartamento() throws IOException
    {
        //Pedir edificio
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre del edificio: ");

        while (true)
        {
            String nombre = Lector.readLine();

            Edificio edificio = mapaEdificios.get(nombre);

            if (edificio != null)
            {
                int numero = Integer.parseInt(Lector.readLine());
                int cantidadDeHabitaciones = Integer.parseInt(Lector.readLine());
                String nombreTipo = Lector.readLine();

                Departamento departamento = new Departamento(numero, cantidadDeHabitaciones, nombreTipo);

                edificio.getDepartamentos().add(departamento);
                edificio.setCantidadDepartamentos(edificio.getCantidadDepartamentos()+1);
                edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles()+1);

                mapaEdificios.put(nombre, edificio);

                break;

            } else {
                System.out.println("El edificio no existe en el mapa.");
                System.out.println("Intente nuevamente");

            }
        }
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

    public HashMap<String, Edificio> getMapaEdificios() { return this.mapaEdificios; }
}