package src.main.resources.excepciones;

public class ArgumentoDuplicadoException extends Exception
{
    public ArgumentoDuplicadoException()
    {
        super("El elemento ya existe");
    }
}
