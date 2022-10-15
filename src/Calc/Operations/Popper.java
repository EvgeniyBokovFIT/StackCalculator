package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.EmptyStackException;

import java.util.logging.Logger;

public class Popper implements Operation{
    private static final Logger logger = Logger.getLogger("Popper");
    @Override
    public void Calculate(Context context) throws EmptyStackException, BadNumberOfArgumentsException {
        if(context.getWords().length != 1) {
            throw new BadNumberOfArgumentsException("POP");
        }
        String elem;
        if(context.getStack().isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            elem = context.getStack().pop().toString();
        }
        logger.info("Element " + elem + " successfully popped off the stack");

    }
}
