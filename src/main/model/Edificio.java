package src.main.model;

import src.main.resources.excepciones.ArgumentoDuplicadoException;
import src.main.resources.excepciones.ArgumentoIlegalException;
import src.main.resources.excepciones.FaltaDatosException;
import src.main.resources.excepciones.NoDepartamentoException;

import java.util.ArrayList;
import java.util.HashMap;


public class Edificio
{
    private String nombre;
    private String direccion;
    private int cantidadDepartamentos;
    private int cantidadDepartamentosDisponibles;

    private int cantidadDepartamentosNoDisponibles;
    private final ArrayList<Departamento> departamentos;

    private final HashMap<Integer, Departamento> mapaDepartamentos;
    private double demanda;

    public Edificio(String nombre, String direccion, double demanda)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadDepartamentos = 0;
        this.cantidadDepartamentosDisponibles = 0;
        this.departamentos = new ArrayList<>();
        this.mapaDepartamentos = new HashMap<>(20, 0.75f);
        this.demanda = demanda;
    }

    public void agregarDepartamento(int cantidadIngresar, int cantidadDeHabitaciones, String nombreTipo) throws ArgumentoIlegalException, FaltaDatosException
    {
        if (cantidadIngresar < 1 || cantidadDeHabitaciones < 1) throw new ArgumentoIlegalException();

        for (int i = 0; i < cantidadIngresar; i++)
        {
            int numero = 1;
            while(mapaDepartamentos.containsKey(numero)) numero++;

            Departamento departamento = null;

            switch (nombreTipo)
            {
                case "Suite Penthouse" -> departamento = new TipoSuitePenthouse(numero, cantidadDeHabitaciones, nombreTipo, demanda);
                case "Suite Ejecutiva" -> departamento = new TipoSuiteEjecutiva(numero, cantidadDeHabitaciones, nombreTipo, demanda);
                case "Suite Familiar" -> departamento = new TipoSuiteFamiliar(numero, cantidadDeHabitaciones, nombreTipo, demanda);
                case "Estudio" -> departamento = new TipoEstudio(numero, cantidadDeHabitaciones, nombreTipo, demanda);
                case "Estudio Económico" -> departamento = new TipoEstudioEconomico(numero, cantidadDeHabitaciones, nombreTipo, demanda);
            }

            if (departamento != null)
            {
                departamentos.add(departamento);
                mapaDepartamentos.put(numero, departamento);
                this.setCantidadDepartamentos(this.getCantidadDepartamentos() + 1);
                this.setCantidadDepartamentosDisponibles(this.getCantidadDepartamentosDisponibles() + 1);
            }
        }
    }

    public Departamento buscarDepartamento(int numero) throws NoDepartamentoException
    {
        Departamento departamento = mapaDepartamentos.get(numero);
        if (departamento == null) throw new NoDepartamentoException();
        return departamento;
    }

    public void eliminarDepartamento(int numero) throws NoDepartamentoException
    {
        Departamento departamento = buscarDepartamento(numero);

        departamentos.remove(departamento);
        mapaDepartamentos.remove(numero);
        this.setCantidadDepartamentos(this.getCantidadDepartamentos() - 1);
        this.setCantidadDepartamentosDisponibles(this.getCantidadDepartamentosDisponibles() - 1);
    }

    public void editarDepartamento(int numero, int nuevoNumero, int cantHabitaciones, String nombreTipo, String disponibilidad) throws NoDepartamentoException, ArgumentoDuplicadoException, ArgumentoIlegalException
    {
        Departamento departamento = this.buscarDepartamento(numero);

        if (nuevoNumero < 1 || cantHabitaciones < 1) throw new ArgumentoIlegalException();
        if (mapaDepartamentos.containsKey(nuevoNumero) && numero != nuevoNumero) throw new ArgumentoDuplicadoException();

        if (departamento.getDisponible().equals("No Disponible") && disponibilidad.equals("Disponible"))
        {
            this.setCantidadDepartamentosDisponibles(this.getCantidadDepartamentosDisponibles() + 1);
            this.cantidadDepartamentosNoDisponibles--;
        }
        if (departamento.getDisponible().equals("Disponible") && disponibilidad.equals("No Disponible")) {
            this.setCantidadDepartamentosDisponibles(this.getCantidadDepartamentosDisponibles() - 1);
            this.cantidadDepartamentosNoDisponibles++;
        }

        departamento.setNumero(nuevoNumero);
        departamento.setCantidadHabitaciones(cantHabitaciones);
        departamento.setNombreTipo(nombreTipo);
        departamento.setDisponible(disponibilidad.equals("Disponible"));

        mapaDepartamentos.remove(numero);
        mapaDepartamentos.put(nuevoNumero, departamento);
    }

    public static void filtrarDatos(ArrayList<Departamento> listaFiltrada, int cantValor) throws ArgumentoIlegalException
    {
        if (cantValor < 1) throw new ArgumentoIlegalException();

        listaFiltrada.removeIf(depto -> depto.getCantidadHabitaciones() != cantValor);
    }


    public static void filtrarDatos(ArrayList<Departamento> listaFiltrada, String estado)
    {
        if (!estado.equals("Todos"))
        {
            listaFiltrada.removeIf(departamento -> !departamento.getDisponible().equals(estado));
        }
    }


    public String getNombre() { return this.nombre; }

    public String getDireccion() { return this.direccion; }

    public int getCantidadDepartamentos() { return this.cantidadDepartamentos; }

    public int getCantidadDepartamentosDisponibles() { return this.cantidadDepartamentosDisponibles; }

    public double getDemanda() { return this.demanda; }

    public int getCantidadDepartamentosNoDisponibles()
    {
        return this.cantidadDepartamentosNoDisponibles;
    }

    public String getInformacionCompleta()
    {
        return "Nombre: " + nombre + "\nDirección: " + direccion + "\nDemanda: " + demanda + "\nCantidad de departamentos: " + cantidadDepartamentos + "\nCantidad de departamentos disponibles: " + cantidadDepartamentosDisponibles;
    }

    public ArrayList<Departamento> getDepartamentos() { return this.departamentos; }

    public HashMap<Integer, Departamento> getMapaDepartamentos() { return this.mapaDepartamentos; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public void setCantidadDepartamentos(int cantidadDepartamentos) { this.cantidadDepartamentos = cantidadDepartamentos; }

    public void setDemanda(int demanda) { this.demanda = demanda; }

    public void setCantidadDepartamentosDisponibles(int cantidadDepartamentosDisponibles) { this.cantidadDepartamentosDisponibles = cantidadDepartamentosDisponibles; }

    public void setCantidadDepartamentosNoDisponibles(int cantidadDepartamentosNoDisponibles) { this.cantidadDepartamentosNoDisponibles = cantidadDepartamentosNoDisponibles; }

}