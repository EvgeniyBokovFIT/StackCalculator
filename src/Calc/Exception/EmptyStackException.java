package Calc.Exception;

public class EmptyStackException extends Exception{
    public EmptyStackException() {
        super("Stack is empty");
    }
}
