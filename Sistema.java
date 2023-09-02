import java.io.*;
import java.util.*;

public class Sistema
{
    public static HashMap<String, Edificio> mapaEdificios = new HashMap<>(100, 0.75f);
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

        if (edificio != null) System.out.println(edificio.getInformacionCompleta());
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
            System.out.println("¿Está seguro de que desea eliminar el edificio '" + nombre + "'? (s/n)");
            String confirmacion = Lector.readLine().trim();

            if (confirmacion.equalsIgnoreCase("s"))
            {
                mapaEdificios.remove(nombre);
                listaEdificios.remove(edificio);

                System.out.println("Se ha eliminado el edificio correctamente");
            }
            else System.out.println("No se hizo ningún cambio");
        }
        else System.out.println("El edificio no existe en el mapa.");
    }

    public void mostrarEdificios()
    {
        if (listaEdificios.isEmpty()) System.out.println("No hay edificios");
        else
        {
            System.out.println("Lista de Edificios:\n");
            for (Edificio edificio : listaEdificios)
            {
                System.out.println(edificio.getInformacionCompleta());
                System.out.println("--------------------------------");
            }
            System.out.println("Total de edificios: " + listaEdificios.size());
        }
    }
    public HashMap<String, Edificio> getMapaEdificios() { return this.mapaEdificios; }

    public static void datosIniciales(String rutaCSV) throws IOException
    {
        List<String> tipos = Arrays.asList("A", "B", "C", "D", "E");

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCSV)))
        {
            reader.readLine();
            String linea;

            while ((linea = reader.readLine()) != null)
            {
                String[] partes = linea.split(",");

                if (partes.length != 4)
                {
                    System.err.println("Formato de línea CSV incorrecto: " + linea);
                    continue;
                }

                String nombre = partes[0];
                String direccion = partes[1];

                int demanda = Integer.parseInt(partes[2]);
                int cantidadDepartamentos = Integer.parseInt(partes[3]);

                Edificio edificio = new Edificio(nombre, direccion, demanda);

                for (int i = 0; i < cantidadDepartamentos; i++)
                {
                    int cantidadHabitaciones = new Random().nextInt(4) + 1;
                    String tipo = tipos.get(new Random().nextInt(tipos.size()));
                    int numero = i + 1;

                    Departamento departamento = new Departamento(numero, cantidadHabitaciones, tipo);
                    edificio.getDepartamentos().add(departamento);
                }

                edificio.setCantidadDepartamentos(cantidadDepartamentos);
                edificio.setCantidadDepartamentosDisponibles(cantidadDepartamentos);

                mapaEdificios.put(nombre, edificio);
                listaEdificios.add(edificio);
            }
        }
        catch (IOException e) { System.err.println("Error al leer el archivo CSV: " + e.getMessage()); }
    }
}