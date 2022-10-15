package Calc.Exception;

public class UnknownOperationNameException extends Exception{
    public UnknownOperationNameException(String command) {
        super("Unknown operation name: " + command);
    }
}
