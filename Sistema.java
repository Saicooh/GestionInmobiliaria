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

        System.out.println("Se ha guardado el edificio correctamente");
    }

    public void buscarEdificio() throws IOException
    {
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
        else System.out.println("El edificio no existe en el mapa.");
    }

    public void eliminarEdificio() throws IOException
    {
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
        else System.out.println("El edificio no existe en el mapa.");
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
    }

    public void agregarDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese la cantidad de departamentos que quiere agregar:");
        int cantidadIngresar = Integer.parseInt(Lector.readLine());

        System.out.println("Ingrese la cantidad de habitaciones");
        int cantidadDeHabitaciones = Integer.parseInt(Lector.readLine());
        System.out.println("Ingrese el nombre del tipo de departamento: ");
        String nombreTipo = Lector.readLine();

        for(int i = 0; i < cantidadIngresar; i++)
        {
            int numero = edificio.getCantidadDepartamentos() + 1;
            Departamento departamento = new Departamento(numero, cantidadDeHabitaciones, nombreTipo);

            edificio.getDepartamentos().add(departamento);
            edificio.setCantidadDepartamentos(edificio.getCantidadDepartamentos()+1);
            edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles()+1);
        }
    }
    public void eliminarDepartamento(Edificio edificio) throws IOException
    {
        // Pedir número de departamento
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero del departamento: ");
        int numero = Integer.parseInt(Lector.readLine());

        Departamento departamento = edificio.getDepartamentos().get(numero - 1);

        if(edificio.getCantidadDepartamentos() < numero) System.out.println("El departamento buscado no existe");
        else
        {
            edificio.setCantidadDepartamentos(edificio.getCantidadDepartamentos() - 1);
            if(departamento.getDisponible().equals("Disponible")) edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() - 1);
            edificio.getDepartamentos().remove(numero - 1);
        }
    }

    public void buscarDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el número del departamento: ");

        int numero = Integer.parseInt(Lector.readLine());

        Departamento departamento = edificio.getDepartamentos().get(numero-1);

        System.out.println("Numero de Departamento: " + departamento.getNumero());
        System.out.println("Cantidad de habitaciones: " + departamento.getCantidadHabitaciones());
        System.out.println("Tipo de Departamento: " + departamento.getNombreTipo());
        System.out.println("Precio: " + (departamento.getPrecio() * edificio.getDemanda()));
        System.out.println("Disponibilidad: " + departamento.getDisponible());
        System.out.println(" ");
    }
    public void disponibilidadDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero del departamento: ");
        int numero = Integer.parseInt(Lector.readLine());

        System.out.println("El departamento está " + edificio.getDepartamentos().get(numero-1).getDisponible());
        System.out.println("Desea cambiar el estado del departamento? (s/n)");
        String respuesta = Lector.readLine();

        Departamento departamento = edificio.getDepartamentos().get(numero-1);

        if(respuesta.equals("s") || respuesta.equals("S") || respuesta.equals("si") || respuesta.equals("Si"))
        {
            if(departamento.getDisponible().equals("Disponible")) departamento.setDisponible(false);
            else departamento.setDisponible(true);
        }
    }

    public void mostrarDepartamentos(Edificio edificio) throws IOException
    {
        for(int i = 0; i < edificio.getCantidadDepartamentos(); i++)
        {
            Departamento departamento = edificio.getDepartamentos().get(i);
            System.out.println("Numero de Departamento: " + departamento.getNumero());
            System.out.println("Cantidad de habitaciones: " + departamento.getCantidadHabitaciones());
            System.out.println("Tipo de Departamento: " + departamento.getNombreTipo());
            System.out.println("Precio: " + (departamento.getPrecio() * edificio.getDemanda()));
            System.out.println("Disponibilidad: " + departamento.getDisponible());
            System.out.println(" ");
        }
    }

    public void mostrarDepartamentosDisponibles(Edificio edificio) throws IOException
    {
        if(edificio.getCantidadDepartamentosDisponibles() == 0)
        {
            System.out.println("No hay departamentos disponibles");
            return;
        }

        for(int i = 0; i < edificio.getCantidadDepartamentos(); i++)
        {
            Departamento departamento = edificio.getDepartamentos().get(i);

            if(departamento.getDisponible().equals("Disponible"))
            {
                System.out.println("Numero de Departamento: " + departamento.getNumero());
                System.out.println("Cantidad de habitaciones: " + departamento.getCantidadHabitaciones());
                System.out.println("Tipo de Departamento: " + departamento.getNombreTipo());
                System.out.println("Precio: " + departamento.getPrecio());
                System.out.println("Disponible: " + departamento.getDisponible());
                System.out.println(" ");
            }
        }
    }

    public HashMap<String, Edificio> getMapaEdificios() { return this.mapaEdificios; }
}