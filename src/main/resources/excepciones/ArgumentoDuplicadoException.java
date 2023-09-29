package src.main.resources.excepciones;

public class ArgumentoDuplicadoException extends Exception
{
    public ArgumentoDuplicadoException(String item)
    {
        super("El elemento " + item + " ya existe");
    }
}
