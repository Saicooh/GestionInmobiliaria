package src.main.resources.excepciones;

/**
 * Se lanza para indicar que no se ha proporcionado un dato necesario
 * para realizar una operación.
 */

public class FaltaDatosException extends Exception
{
    public FaltaDatosException(String message)
    {
        super(message);
    }
}
