package src.main.model;

public class SuitePenthouse extends Departamento
{
    public SuitePenthouse(int numero, int cantidadHabitaciones, String nombre, double demanda)
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

