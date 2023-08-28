public class Tipo
{
    private String nombreTipo;
    private int precio;

    public Tipo(String nombre, int precio)
    {
        this.nombreTipo = nombre;
        this.precio = precio;
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
