public class Departamento
{
    private int numero;
    private int cantidadHabitaciones;
    private boolean disponible;
    private Tipo tipo;

    public Departamento(int numero, int cantidadHabitaciones, boolean disponible, String nombreTipo, int precio)
    {
        this.numero = numero;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.disponible = true;
        this.tipo = new Tipo(nombreTipo);
    }

    public int getNumero()
    {
        return this.numero;
    }

    public int getCantidadHabitaciones()
    {
        return this.cantidadHabitaciones;
    }

    public boolean getDisponible()
    {
        return this.disponible;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones)
    {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public void getTipo()
    {
        this.tipo.getNombre();
        this.tipo.getPrecio();
    }

}
