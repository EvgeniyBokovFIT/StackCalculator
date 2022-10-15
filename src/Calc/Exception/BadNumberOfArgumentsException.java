package Calc.Exception;

public class BadNumberOfArgumentsException extends Exception {
    public BadNumberOfArgumentsException(String command) {
        super("Bad number of arguments in command " + command);
    }
}
