package Calc.Exception;

public class WrongArgsException extends Exception {
    public WrongArgsException() {
        super("The command argument is not a number");
    }
}
