package src.main.resources;

public final class Constantes
{
    private Constantes() {}

    private static final String INICIO = "/src/main/ventanas/mainView.fxml";
    private static final String MENU_PRINCIPAL = "/src/main/ventanas/menuView.fxml";

    private static final String AGREGAR_EDIFICIO = "/src/main/ventanas/agregarEdificio.fxml";

    private static final String BUSCAR_EDIFICIO = "/src/main/ventanas/buscarEdificio.fxml";

    private static final String ELIMINAR_EDIFICIO = "/src/main/ventanas/eliminarEdificio.fxml";

    private static final String MOSTRAR_EDIFICIOS = "/src/main/ventanas/mostrarEdificios.fxml";

    private static final String CSV = "DatosIniciales.csv";

    private static final String REPORTE = "Reporte.csv";

    private static final String ADMINISTRAR_DEPARTAMENTOS = "/src/main/ventanas/administrarDepartamentos.fxml";

    private static final String AGREGAR_DEPARTAMENTOS = "/src/main/ventanas/agregarDepartamento.fxml";

    private static final String BUSCAR_DEPARTAMENTO = "/src/main/ventanas/buscarDepartamento.fxml";

    private static final String MOSTRAR_DEPARTAMENTOS = "/src/main/ventanas/mostrarDepartamentos.fxml";

    private static final String ELIMINAR_DEPARTAMENTOS = "/src/main/ventanas/eliminarDepartamento.fxml";

    private static final String EDITAR_DEPARTAMENTO = "/src/main/ventanas/editarDepartamento.fxml";

    private static final String ERROR_INGRESAR = "Error, no se pudo ingresar al sistema";

    private static final String ERROR_OPCION = "Error, no se pudo realizar la operación";

    public static String getInicio() { return INICIO; }
    public static String getMenuPrincipal() { return MENU_PRINCIPAL; }

    public static String getAgregarEdificio() { return AGREGAR_EDIFICIO; }

    public static String getBuscarEdificio() { return BUSCAR_EDIFICIO; }

    public static String getEliminarEdificio() { return ELIMINAR_EDIFICIO; }


    public static String getMostrarEdificios() { return MOSTRAR_EDIFICIOS; }

    public static String getCSV() { return CSV; }

    public static String getReporte() { return REPORTE; }

    public static String getAdministrarDepartamentos() { return ADMINISTRAR_DEPARTAMENTOS; }

    public static String getAgregarDepartamentos() { return AGREGAR_DEPARTAMENTOS; }

    public static String getBuscarDepartamentos() { return BUSCAR_DEPARTAMENTO; }

    public static String getMostrarDepartamentos() { return MOSTRAR_DEPARTAMENTOS; }

    public static String getEliminarDepartamentos() { return ELIMINAR_DEPARTAMENTOS; }

    public static String getEditarDepartamento() { return EDITAR_DEPARTAMENTO; }

    public static String getErrorIngresar() { return ERROR_INGRESAR; }

    public static String getErrorOpcion() { return ERROR_OPCION; }

}
