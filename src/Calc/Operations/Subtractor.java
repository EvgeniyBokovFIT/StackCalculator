package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.EmptyStackException;
import Calc.Exception.WrongArgsException;
import Calc.Worker;

import java.util.logging.Logger;

public class Subtractor implements Operation {
    private static final Logger logger = Logger.getLogger("Subtractor");
    @Override
    public void Calculate(Context context) throws BadNumberOfArgumentsException, EmptyStackException, WrongArgsException {
        if(context.getWords().length != 1) {
            throw new BadNumberOfArgumentsException("-");
        }
        if(context.getStack().isEmpty()) {
            throw new EmptyStackException();
        }
        String elem1 = context.contextStackPop();
        if(context.getStack().isEmpty()) {
            throw new EmptyStackException();
        }
        String elem2 = context.contextStackPop();
        Double NumberElem1;
        Double NumberElem2;
        if(Worker.isNumeric(elem1)) {
            NumberElem1 = Double.parseDouble(elem1);
        }
        else {
            throw new WrongArgsException();
        }
        if(Worker.isNumeric(elem2)) {
            NumberElem2 = Double.parseDouble(elem2);
        }
        else {
            throw new WrongArgsException();
        }
        Double res = NumberElem1 - NumberElem2;
        context.contextStackPush(res.toString());
        logger.info(NumberElem2.toString() + " successfully subtracted from " + NumberElem1.toString());
    }
}
