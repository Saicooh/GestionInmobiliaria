import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Edificio
{
    private String nombre;
    private String direccion;
    private int cantidadDepartamentos;
    private int cantidadDepartamentosDisponibles;
    private ArrayList<Departamento> departamentos;
    private int demanda;

    public Edificio(String nombre, String direccion, int demanda)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadDepartamentos = 0;
        this.cantidadDepartamentosDisponibles = 0;
        this.departamentos = new ArrayList<>();
        this.demanda = demanda;
    }

    public void agregarDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese la cantidad de departamentos que quiere agregar:");
        int cantidadIngresar = Integer.parseInt(Lector.readLine());

        if (cantidadIngresar < 1)
        {
            System.out.println("La cantidad de departamentos debe ser mayor a 0");
            return;
        }

        System.out.println("Ingrese la cantidad de habitaciones");
        int cantidadDeHabitaciones = Integer.parseInt(Lector.readLine());
        System.out.println("Ingrese el nombre del tipo de departamento: ");
        String nombreTipo = Lector.readLine();

        for (int i = 0; i < cantidadIngresar; i++)
        {
            int numero = edificio.getCantidadDepartamentos() + 1;
            Departamento departamento = new Departamento(numero, cantidadDeHabitaciones, nombreTipo);

            edificio.getDepartamentos().add(departamento);
            edificio.setCantidadDepartamentos(edificio.getCantidadDepartamentos() + 1);
            edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() + 1);
        }
    }

    public void eliminarDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero del departamento: ");
        int numero = Integer.parseInt(Lector.readLine());

        int indiceDepartamento = numero - 1;
        Departamento departamento = edificio.getDepartamentos().get(indiceDepartamento);

        if (edificio.getCantidadDepartamentos() < numero) System.out.println("El departamento buscado no existe");
        else
        {
            edificio.setCantidadDepartamentos(edificio.getCantidadDepartamentos() - 1);

            if (departamento.getDisponible().equals("Disponible"))
                edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() - 1);

            edificio.getDepartamentos().remove(indiceDepartamento);
        }
    }

    public void mostrarDepartamentos(Edificio edificio, int numero)
    {
        if (edificio.getCantidadDepartamentos() < numero)
        {
            System.out.println("El departamento buscado no existe");
            return;
        }

        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        int indiceDepartamento = numero - 1;

        Departamento departamento = edificio.getDepartamentos().get(indiceDepartamento);

        departamento.getInformacionCompleta();
    }

    public void mostrarDepartamentos(Edificio edificio)
    {
        if (edificio.getCantidadDepartamentos() == 0) System.out.println("No hay departamentos ingresados");
        else for (Departamento departamento : edificio.getDepartamentos()) System.out.println(departamento.getInformacionCompleta() + "\n");

        System.out.println("Cantidad de departamentos: " + edificio.getCantidadDepartamentos() + "\n");
    }

    public void disponibilidadDepartamento(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el numero del departamento: ");
        int numero = Integer.parseInt(Lector.readLine());

        System.out.println("El departamento está " + edificio.getDepartamentos().get(numero - 1).getDisponible());
        System.out.println("Desea cambiar el estado del departamento? (s/n)");
        String respuesta = Lector.readLine();

        int indiceDepartamento = numero - 1;

        Departamento departamento = edificio.getDepartamentos().get(indiceDepartamento);

        if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si"))
        {
            if (departamento.getDisponible().equals("Disponible"))
            {
                departamento.setDisponible(false);
                edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() - 1);
            }
            else
            {
                departamento.setDisponible(true);
                edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() + 1);
            }
        }
    }

    public void mostrarDepartamentosDisponibles(Edificio edificio)
    {
        if (edificio.getCantidadDepartamentosDisponibles() == 0) System.out.println("No hay departamentos disponibles");

        else for (Departamento departamento : edificio.getDepartamentos())
        {
            if (departamento.getDisponible().equals("Disponible")) System.out.println(departamento.getInformacionCompleta() + "\n");
        }

        System.out.println("Cantidad de departamentos disponibles: " + edificio.getCantidadDepartamentosDisponibles() + "\n");
    }

    public String getNombre() { return this.nombre; }

    public String getDireccion() { return this.direccion; }

    public int getCantidadDepartamentos() { return this.cantidadDepartamentos; }

    public int getCantidadDepartamentosDisponibles() { return this.cantidadDepartamentosDisponibles; }

    public int getDemanda() { return this.demanda; }

    public String getInformacionCompleta()
    {
        return "Nombre: " + nombre + "\nDirección: " + direccion + "\nDemanda: " + demanda + "\nCantidad de departamentos: " + cantidadDepartamentos + "\nCantidad de departamentos disponibles: " + cantidadDepartamentosDisponibles;
    }

    public ArrayList<Departamento> getDepartamentos() { return this.departamentos; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCantidadDepartamentos(int cantidadDepartamentos) { this.cantidadDepartamentos = cantidadDepartamentos; }

    public void setDemanda(int demanda) { this.demanda = demanda; }

    public void setCantidadDepartamentosDisponibles(int cantidadDepartamentosDisponibles) { this.cantidadDepartamentosDisponibles = cantidadDepartamentosDisponibles; }


}