package src.main.model;

public class Departamento
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

        switch (nombre)
        {
            case "Suite Penthouse" -> this.precio = (int) (250000000 * demanda);
            case "Suite Ejecutiva" -> this.precio = (int) (180000000 * demanda);
            case "Suite Familiar" -> this.precio = (int) (120000000 * demanda);
            case "Estudio" -> this.precio = (int) (70000000 * demanda);
            case "Estudio Económico" -> this.precio = (int) (40000000 * demanda);
        }
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

    public void setNombreTipo(String nombreTipo) { this.nombreTipo = nombreTipo;}
}
