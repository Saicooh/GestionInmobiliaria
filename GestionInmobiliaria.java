import java.io.*;
public class GestionInmobiliaria
{
    public static void main(String[] args) throws IOException
    {
        Sistema.datosIniciales("DatosIniciales.csv");

        System.out.println("Bienvenido a la gestión inmobilaria");

        Menues menu = new Menues();

        menu.mostrarMenu();
    }
}