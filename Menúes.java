import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menúes
{
    public void mostrarMenu() throws IOException
    {
        int opcion;

        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Seleccione una opcion: ");

        System.out.println("1. Ingresar al sistema de gestión inmobiliaria");
        System.out.println("2. Salir");

        System.out.println("Ingrese una opcion: ");

        opcion = Integer.parseInt(Lector.readLine());

        switch (opcion)
        {
            case 1 -> System.out.println("** codigo de sistema de gestion inmobiliaria **");
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
