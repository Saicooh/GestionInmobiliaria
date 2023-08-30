public class Tipo
{
    private String nombreTipo;
    private int precio;

    public Tipo(String nombre)
    {
        this.nombreTipo = nombre;

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

    public String getNombre()
    {
        return this.nombreTipo;
    }

    public int getPrecio()
    {
        return this.precio;
    }

    public void setNombre(String nombre)
    {
        this.nombreTipo = nombre;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
}
