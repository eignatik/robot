package space.eignatik.robotcommandsapp.exceptions;

/**
 * Runtime exception that displays a script parsing problem due to incorrect syntax of the script.
 */
public class IncorrectScriptingException extends RuntimeException {
    public IncorrectScriptingException(String message) {
        super(message);
    }
}
