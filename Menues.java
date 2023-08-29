import java.io.*;


public class Menues
{
    public void mostrarMenu() throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Seleccione una opcion: ");

        System.out.println("1. Ingresar al sistema de gestión inmobiliaria");
        System.out.println("2. Salir");

        System.out.println("Ingrese una opción: ");

        int opcion = Integer.parseInt(Lector.readLine());

        switch (opcion)
        {
            case 1 -> System.out.println("Ingresando al sistema de gestión inmobiliaria");
            case 2 -> exit();
            default -> System.out.println("Opción inválida");
        }
    }

    public void exit()
    {
        System.out.println("Gracias por usar el sistema de gestión inmobiliaria");
        System.exit(0);
    }


}
