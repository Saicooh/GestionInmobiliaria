package src.main.model;

public class TipoSuiteFamiliar extends Departamento
{
    public TipoSuiteFamiliar(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (120000000 * demanda);
    }
}