import java.io.*;
import java.util.*;

public class Menues
{
    public void mostrarMenu() throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
        Menues menu = new Menues();
        int opcion;

        System.out.println("Seleccione una opcion: ");

        System.out.println("1. Ingresar al sistema de gestión inmobiliaria");
        System.out.println("2. Salir");

        System.out.println("Ingrese una opción: ");

        while(true)
        {
            opcion = Integer.parseInt(Lector.readLine());

            if(opcion != 1 && opcion != 2) System.out.println("Ingrese una opcion valida");
            else break;
        }

        switch (opcion)
        {
            case 1 ->
            {
                System.out.println("Ingresando al sistema de gestión inmobiliaria");
                menu.mostrarMenuSistema();
            }
            case 2 -> exit();
        }

    }

    public void exit()
    {
        System.out.println("Gracias por usar el sistema de gestión inmobiliaria");
        System.exit(0);
    }

    public void mostrarMenuSistema() throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
        Sistema funciones = new Sistema();
        Menues menu = new Menues();
        int opcion;

        System.out.println("Seleccione una opcion: ");

        System.out.println("1. Agregar Edificio");
        System.out.println("2. Buscar Edificio");
        System.out.println("3. Eliminar Edificio");
        System.out.println("4. Mostrar Edificios");
        System.out.println("5. Administrar Departamentos");
        System.out.println("6. Volver Menu Principal");

        while (true)
        {
            opcion = Integer.parseInt(Lector.readLine());

            if (opcion < 1 || opcion > 6) System.out.println("Ingrese una opcion valida");
            else break;
        }

        switch (opcion)
        {
            case 1 -> funciones.agregarEdificio();
            case 2 -> funciones.buscarEdificio();
            case 3 -> funciones.eliminarEdificio();
            case 4 -> funciones.mostrarEdificios();
            case 5 ->
            {
                System.out.println("Ingrese el nombre del edificio: ");
                String nombre = Lector.readLine();

                Edificio edificio = Sistema.mapaEdificios.get(nombre);

                if (edificio == null) System.out.println("El edificio no existe");
                else menu.mostrarSubMenuDep(edificio);
            }
            case 6 -> menu.mostrarMenu();
            default -> System.out.println("Opción inválida");
        }

        menu.mostrarMenuSistema();
    }

    public void mostrarSubMenuDep(Edificio edificio) throws IOException
    {
        BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
        Sistema funciones = new Sistema();
        Menues menu = new Menues();
        int opcion;

        System.out.println("Seleccione una opcion: ");

        System.out.println("1. Agregar Departamento");
        System.out.println("2. Buscar Departamento");
        System.out.println("3. Eliminar Departamento");
        System.out.println("4. Modificar disponibilidad de Departamento");
        System.out.println("5. Mostrar Departamentos");
        System.out.println("6. Mostrar Departamentos Disponibles");
        System.out.println("7. Volver Menu Edificios");

        while (true)
        {
            opcion = Integer.parseInt(Lector.readLine());

            if (opcion < 1 || opcion > 7) System.out.println("Ingrese una opcion valida");
            else break;
        }

        switch (opcion)
        {
            case 1 -> funciones.agregarDepartamento(edificio);
            case 2 -> funciones.buscarDepartamento(edificio);
            case 3 -> funciones.eliminarDepartamento(edificio);
            case 4 -> funciones.disponibilidadDepartamento(edificio);
            case 5 -> funciones.mostrarDepartamentos(edificio);
            case 6 -> funciones.mostrarDepartamentosDisponibles(edificio);
            case 7 -> menu.mostrarMenuSistema();
            default -> System.out.println("Opción inválida");
        }

        menu.mostrarSubMenuDep(edificio);

    }
}
