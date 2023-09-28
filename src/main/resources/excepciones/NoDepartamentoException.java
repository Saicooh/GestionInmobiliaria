package src.main.resources.excepciones;


/**
 * Se lanza para indicar que no existe un departamento con el nombre
 */
public class NoDepartamentoException extends Exception
{
    public NoDepartamentoException(String message)
    {
        super(message);
    }
}