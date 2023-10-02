package src.main.model;

import src.main.resources.UtilidadAlertas;
import src.main.resources.excepciones.ArgumentoDuplicadoException;
import src.main.resources.excepciones.ArgumentoIlegalException;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoEdificioException;

import java.io.*;
import java.util.*;

public final class Sistema
{
    private Sistema() {}

    private static final HashMap<String, Edificio> mapaEdificios = new HashMap<>(100, 0.75f);
    private static final ArrayList<Edificio> listaEdificios = new ArrayList<>();

    public static void agregarEdificio(String nombre, String direccion, double demanda) throws ArgumentoDuplicadoException
    {
        if (mapaEdificios.containsKey(nombre)) throw new ArgumentoDuplicadoException();

        Edificio nuevoEdificio = new Edificio(nombre, direccion, demanda);
        mapaEdificios.put(nombre, nuevoEdificio);
        listaEdificios.add(nuevoEdificio);
    }

    public static Edificio buscarEdificio(String nombre) throws NoEdificioException
    {
        Edificio edificio = mapaEdificios.get(nombre);
        if (edificio == null) throw new NoEdificioException();
        return edificio;
    }

    public static void filtrarPorDemanda(ArrayList<Edificio> listaFiltrada, ArrayList<Edificio>listaOriginalDeEdificios, double minDemanda, double maxDemanda)
    {
        for (Edificio edificio : listaOriginalDeEdificios)
            if (edificio.getDemanda() >= minDemanda && edificio.getDemanda() <= maxDemanda) listaFiltrada.add(edificio);
    }

    public static void eliminarEdificio(Edificio edificio)
    {
        mapaEdificios.remove(edificio.getNombre());
        listaEdificios.remove(edificio);
    }

    public static void datosIniciales()
    {
        Random rand = new Random();

        try
        {
            for (int i = 6; i <= 25; i++)
            {
                double demandaSinRedondear = 0.5 + (1.3 - 0.5) * rand.nextDouble();
                double demandaAleatoria = Math.round(demandaSinRedondear * 10.0) / 10.0;
                agregarEdificio("Edificio " + i, "Dirección " + i, demandaAleatoria);

                Edificio edificioActual = buscarEdificio("Edificio " + i);

                int cantidadDeptos = rand.nextInt(5) + 1; // Generar entre 1 y 5 departamentos

                for (int j = 0; j < cantidadDeptos; j++)
                {
                    int cantidadHabitaciones = rand.nextInt(5) + 1; // Generar entre 1 y 5 habitaciones

                    String[] tipos = {"Suite Penthouse", "Suite Ejecutiva", "Suite Familiar", "Estudio", "Estudio Económico"};
                    String tipoAleatorio = tipos[rand.nextInt(tipos.length)];

                    edificioActual.agregarDepartamento(1, cantidadHabitaciones, tipoAleatorio);
                }
            }
        }
        catch (ArgumentoDuplicadoException | NoEdificioException | ArgumentoIlegalException | FaltaDatosException e)
        {
            UtilidadAlertas.alertaError("Error", e.getMessage());
        }
    }

    public static void inicializarCSV(String rutaCSV)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCSV)))
        {
            reader.readLine(); // Ignorar la primera línea (encabezados)
            String linea;

            while ((linea = reader.readLine()) != null)
            {
                String[] partes = linea.split(",");

                String nombre = partes[0];
                String direccion = partes[1];
                double demanda = Double.parseDouble(partes[2]);
                int cantidadDepartamentos = Integer.parseInt(partes[3]);

                Edificio edificio = new Edificio(nombre, direccion, demanda);

                int i = 4;

                // Cambio en la condición del bucle
                while (i < partes.length && partes[i] != null)
                {
                    int numero = Integer.parseInt(partes[i]);
                    i++;

                    int cantidadHabitaciones = Integer.parseInt(partes[i]);
                    i++;

                    String tipo = partes[i];
                    i++;

                    Departamento departamento = null;

                    switch (tipo)
                    {
                        case "Suite Penthouse" -> departamento = new TipoSuitePenthouse(numero, cantidadHabitaciones, tipo, demanda);
                        case "Suite Ejecutiva" -> departamento = new TipoSuiteEjecutiva(numero, cantidadHabitaciones, tipo, demanda);
                        case "Suite Familiar" -> departamento = new TipoSuiteFamiliar(numero, cantidadHabitaciones, tipo, demanda);
                        case "Estudio" -> departamento = new TipoEstudio(numero, cantidadHabitaciones, tipo, demanda);
                        case "Estudio Económico" -> departamento = new TipoEstudioEconomico(numero, cantidadHabitaciones, tipo, demanda);
                    }

                    String disponibilidad = partes[i];
                    i++;

                    assert departamento != null;

                    if (disponibilidad.equals("Disponible"))
                    {
                        departamento.setDisponible(true);
                        edificio.setCantidadDepartamentosDisponibles(edificio.getCantidadDepartamentosDisponibles() + 1);
                    }
                    else
                    {
                        departamento.setDisponible(false);
                        edificio.setCantidadDepartamentosNoDisponibles(edificio.getCantidadDepartamentosNoDisponibles() + 1);
                    }

                    edificio.getDepartamentos().add(departamento);
                    edificio.getMapaDepartamentos().put(numero, departamento);
                }

                edificio.setCantidadDepartamentos(cantidadDepartamentos);
                edificio.setCantidadDepartamentosDisponibles(cantidadDepartamentos);

                mapaEdificios.put(nombre, edificio);
                listaEdificios.add(edificio);
            }
        }
        catch (IOException e) { System.err.println("Error al leer el archivo CSV: " + e.getMessage()); }
    }

    public static void guardarEnCSV(String rutaCSV) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaCSV)))
        {
            writer.write("nombreEdificio,direccion,demanda,cantidad_departamentos,[DEPARTAMENTOS]numero,cantidadDeHab,tipo\n");

            for (Edificio edificio : listaEdificios)
            {
                StringBuilder linea = new StringBuilder();

                linea.append(edificio.getNombre()).append(",");
                linea.append(edificio.getDireccion()).append(",");
                linea.append(edificio.getDemanda()).append(",");
                linea.append(edificio.getCantidadDepartamentos());

                for (Departamento depto : edificio.getDepartamentos())
                {
                    linea.append(",").append(depto.getNumero());
                    linea.append(",").append(depto.getCantidadHabitaciones());
                    linea.append(",").append(depto.getNombreTipo());
                    linea.append(",").append(depto.getDisponible());
                }

                writer.write(linea + "\n");
            }
        }
    }


    public static HashMap<String, Edificio> getMapaEdificios() { return mapaEdificios; }
    public static ArrayList<Edificio> getListaEdificios() { return listaEdificios; }
}