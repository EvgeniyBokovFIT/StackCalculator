package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.EmptyStackException;

import java.util.logging.Logger;

public class Printer implements Operation {
    private static final Logger logger = Logger.getLogger("Printer");
    @Override
    public void Calculate(Context context) throws BadNumberOfArgumentsException, EmptyStackException {
        if (context.getWords().length != 1) {
            throw new BadNumberOfArgumentsException("PRINT");
        }
        if (context.getStack().isEmpty()) {
            throw new EmptyStackException();
        }
        System.out.println(context.contextStackPeek());
        logger.info("Element successfully printed");

    }
}
