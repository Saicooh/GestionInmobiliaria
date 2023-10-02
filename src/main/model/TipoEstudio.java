package src.main.model;

public class TipoEstudio extends Departamento
{
    public TipoEstudio(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (70000000 * demanda);
    }
    // ...
}