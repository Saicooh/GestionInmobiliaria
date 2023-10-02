package src.main.model;

public class TipoEstudioEconomico extends Departamento
{
    public TipoEstudioEconomico(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (40000000 * demanda);
    }
    // ...
}