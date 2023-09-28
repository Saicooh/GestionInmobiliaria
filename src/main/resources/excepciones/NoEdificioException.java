package src.main.resources.excepciones;

/**
 * Se lanza para indicar que no existe un edificio con el nombre
 */

public class NoEdificioException extends Exception
{
    public NoEdificioException(String message)
    {
        super(message);
    }
}
