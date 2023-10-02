package src.main.model;

public class TipoSuitePenthouse extends Departamento
{
    public TipoSuitePenthouse(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (250000000 * demanda);
    }
    // ...
}

