package src.main.model;

public class TipoSuiteEjecutiva extends Departamento
{
    public TipoSuiteEjecutiva(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        super(numero, cantidadHabitaciones, nombre, demanda);
    }

    // Implementación específica para Suite Penthouse
    @Override
    public int calcularPrecio(double demanda)
    {
        return (int) (180000000 * demanda);
    }
    // ...
}