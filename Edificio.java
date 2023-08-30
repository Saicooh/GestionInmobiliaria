import java.util.Map;
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

    public String getNombre() { return this.nombre; }

    public String getDireccion() { return this.direccion; }

    public int getCantidadDepartamentos() { return this.cantidadDepartamentos; }

    public int getCantidadDepartamentosDisponibles() { return this.cantidadDepartamentosDisponibles; }

    public int getDemanda() { return this.demanda; }

    public ArrayList<Departamento> getDepartamentos() { return this.departamentos; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCantidadDepartamentos(int cantidadDepartamentos) { this.cantidadDepartamentos = cantidadDepartamentos; }

    public void setDemanda(int demanda) { this.demanda = demanda; }
}