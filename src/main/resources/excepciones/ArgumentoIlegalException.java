package src.main.resources.excepciones;


/**
 * Se lanza para indicar que un argumento proporcionado a un método
 * no cumple con los criterios o condiciones esperadas.
 */

public class ArgumentoIlegalException extends Exception
{
    public ArgumentoIlegalException()
    {
        super("Por favor ingresa un número válido.");
    }
}
