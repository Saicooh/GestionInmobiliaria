package src.main.model;

import src.main.resources.excepciones.ArgumentoDuplicadoException;
import src.main.resources.excepciones.NoDepartamentoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Edificio
{
    private String nombre;
    private String direccion;
    private int cantidadDepartamentos;
    private int cantidadDepartamentosDisponibles;
    private final ArrayList<Departamento> departamentos;

    private final HashMap<Integer, Departamento> mapaDepartamentos;
    private int demanda;

    public Edificio(String nombre, String direccion, int demanda)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidadDepartamentos = 0;
        this.cantidadDepartamentosDisponibles = 0;
        this.departamentos = new ArrayList<>();
        this.mapaDepartamentos = new HashMap<>(20, 0.75f);
        this.demanda = demanda;
    }

    public void agregarDepartamento(int cantidadIngresar, int cantidadDeHabitaciones, String nombreTipo)
    {

        for (int i = 0; i < cantidadIngresar; i++)
        {
            int numero = this.getCantidadDepartamentos() + 1;

            while(mapaDepartamentos.containsKey(numero)) numero++;

            Departamento departamento = new Departamento(numero, cantidadDeHabitaciones, nombreTipo);

            departamentos.add(departamento);
            mapaDepartamentos.put(numero, departamento);
            this.setCantidadDepartamentos(this.getCantidadDepartamentos() + 1);
            this.setCantidadDepartamentosDisponibles(this.getCantidadDepartamentosDisponibles() + 1);
        }
    }

    public Departamento buscarDepartamento(int numero) throws NoDepartamentoException
    {
        Departamento departamento = mapaDepartamentos.get(numero);
        if (departamento == null) throw new NoDepartamentoException("El departamento '" + numero + "' no existe.");
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
    
    public void mostrarDepartamentosDisponibles(Edificio edificio)
    {
        if (edificio.getCantidadDepartamentosDisponibles() == 0) System.out.println("No hay departamentos disponibles");

        else for (Departamento departamento : edificio.getDepartamentos())
        {
            if (departamento.getDisponible().equals("Disponible")) System.out.println(departamento.getInformacionCompleta() + "\n");
        }

        System.out.println("Cantidad de departamentos disponibles: " + edificio.getCantidadDepartamentosDisponibles() + "\n");
    }

    public void editarDepartamento(int numero, int nuevoNumero, int cantHabitaciones, String value, String value1) throws NoDepartamentoException, ArgumentoDuplicadoException
    {
        Departamento departamento = this.buscarDepartamento(numero);

        for (Departamento depto : departamentos)
            if (depto.getNumero() == nuevoNumero) throw new ArgumentoDuplicadoException("El departamento '" + nuevoNumero + "' ya existe.");

        departamento.setNumero(nuevoNumero);
        departamento.setCantidadHabitaciones(cantHabitaciones);
        departamento.setNombreTipo(value);
        departamento.setDisponible(value1.equals("Disponible"));
    }

    public String getNombre() { return this.nombre; }

    public String getDireccion() { return this.direccion; }

    public int getCantidadDepartamentos() { return this.cantidadDepartamentos; }

    public int getCantidadDepartamentosDisponibles() { return this.cantidadDepartamentosDisponibles; }

    public int getDemanda() { return this.demanda; }

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



}