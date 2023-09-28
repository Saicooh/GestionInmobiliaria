package src.main.model;

public class Departamento
{
    private int numero;
    private int cantidadHabitaciones;
    private String disponible;
    private String nombreTipo;
    private int precio;

    public Departamento(int numero, int cantidadHabitaciones, String nombre)
    {
        this.numero = numero;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.nombreTipo = nombre;
        this.disponible = "Disponible";

        switch (nombre)
        {
            case "A" -> this.precio = 100000;
            case "B" -> this.precio = 80000;
            case "C" -> this.precio = 60000;
            case "D" -> this.precio = 40000;
            case "E" -> this.precio = 20000;
            default -> this.precio = 0;
        }
    }

    public int getNumero() { return this.numero; }

    public int getCantidadHabitaciones() { return this.cantidadHabitaciones; }

    public String getDisponible() { return this.disponible; }

    public String getNombreTipo() { return this.nombreTipo; }

    public int getPrecio() { return this.precio; }

    public String getInformacionCompleta() { return "Numero: " + numero + "\nCantidad de habitaciones: " + cantidadHabitaciones + "\nTipo: " + nombreTipo + "\nPrecio: " + precio + "\nDisponibilidad: " + disponible; }

    public void setNumero(int numero) { this.numero = numero; }

    public void setCantidadHabitaciones(int cantidadHabitaciones) { this.cantidadHabitaciones = cantidadHabitaciones; }

    public void setDisponible(boolean disponible)
    {
        if (disponible) this.disponible = "Disponible";
        else this.disponible = "No Disponible";
    }

    public void setPrecio(int precio) { this.precio = precio; }

    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo;}
}
