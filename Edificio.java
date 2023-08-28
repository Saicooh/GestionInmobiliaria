import java.util.Map;

public class Edificio
{
    import java.util.Map;

    public class Edificio {
        private String nombre;
        private String direccion;
        private int cantidadDepartamentos;
        private int cantidadEdificios;
        private int cantidadDepartamentosDisponibles;
        private Departamento[] departamentos;
        private Map<String, Edificio> mapaEdificios;
        private int demanda;

        public Edificio(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.cantidadDepartamentos = 0;
            this.cantidadDepartamentosDisponibles = 0;
            this.departamentos = new Departamento[cantidadDepartamentos];
        }

        public String getNombre() {
            return this.nombre;
        }

        public String getDireccion() {
            return this.direccion;
        }

        public int getCantidadDepartamentos() {
            return this.cantidadDepartamentos;
        }

        public int getCantidadDepartamentosDisponibles() {
            return this.cantidadDepartamentosDisponibles;
        }

        public int getCantidadEdificios() {
            return this.cantidadEdificios;
        }

        public Departamento[] getDepartamentos() {
            return this.departamentos;
        }

        public Map<String, Edificio> getMapaEdificios() {
            return this.mapaEdificios;
        }

        public int getDemanda() {
            return this.demanda;
        }

        public void getEdificio(String clave) {
            this.mapaEdificios.get(clave);
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void setCantidadDepartamentos(int cantidadDepartamentos) {
            this.cantidadDepartamentos = cantidadDepartamentos;
        }

        public void setDepartamentos(Departamento[] departamentos) {
            this.departamentos = departamentos;
        }

        public void setMapaEdificios(Map<String, Edificio> mapaEdificios) {
            this.mapaEdificios = mapaEdificios;
        }

        public void setCantidadEdificios(int cantidadEdificios) {
            this.cantidadEdificios = cantidadEdificios;
        }

        public void setDemanda(int demanda) {
            this.demanda = demanda;
        }
    }
}
