package src.main.model;

public class SuiteFamiliar extends Departamento
{
    public SuiteFamiliar(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (180000000 * demanda);
    }
}