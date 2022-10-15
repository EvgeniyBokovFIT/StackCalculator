package Calc.Operations;

import Calc.Context;
import Calc.Exception.*;
import Calc.Worker;

import java.util.logging.Logger;

public class Divider implements Operation {
    private static final Logger logger = Logger.getLogger("Divider");
    @Override
    public void Calculate(Context context) throws DivisionByZeroException, WrongArgsException, BadNumberOfArgumentsException, EmptyStackException {
        if(context.getWords().length != 1) {
            throw new BadNumberOfArgumentsException("/");
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
        if (Worker.isNumeric(elem1)) {
            NumberElem1 = Double.parseDouble(elem1);
        } else {
            throw new WrongArgsException();
        }
        if (Worker.isNumeric(elem2)) {
            NumberElem2 = Double.parseDouble(elem2);
            if (NumberElem2 == 0) {
                throw new DivisionByZeroException();
            }
        } else {
            throw new WrongArgsException();
        }
        Double res = NumberElem1 / NumberElem2;
        context.contextStackPush(res.toString());
        logger.info(elem1 + " and " + elem2 + " successfully divided");

    }
}
