package src.main.model;

public abstract class Departamento
{
    private int numero;
    private int cantidadHabitaciones;
    private String disponible;
    private String nombreTipo;
    private int precio;

    public Departamento(int numero, int cantidadHabitaciones, String nombre, double demanda)
    {
        this.numero = numero;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.nombreTipo = nombre;
        this.disponible = "Disponible";
        this.precio = calcularPrecio(demanda);
    }

    public int getNumero() { return this.numero; }

    public int getCantidadHabitaciones() { return this.cantidadHabitaciones; }

    public String getDisponible() { return this.disponible; }

    public String getNombreTipo() { return this.nombreTipo; }

    public String getInformacionCompleta() { return "Numero: " + numero + "\nCantidad de habitaciones: " + cantidadHabitaciones + "\nTipo: " + nombreTipo + "\nPrecio: " + precio + "\nDisponibilidad: " + disponible; }

    public int getPrecio() { return precio; }

    public void setNumero(int numero) { this.numero = numero; }

    public void setCantidadHabitaciones(int cantidadHabitaciones) { this.cantidadHabitaciones = cantidadHabitaciones; }

    public void setDisponible(boolean disponible)
    {
        if (disponible) this.disponible = "Disponible";
        else this.disponible = "No Disponible";
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }

    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo; }

    // Implementación específica para Suite Penthouse
    public abstract int calcularPrecio(double demanda);
}
