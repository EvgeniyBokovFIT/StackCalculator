package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.EmptyStackException;
import Calc.Exception.ExtractingRootOfNegativeNumException;
import Calc.Exception.WrongArgsException;
import Calc.Worker;

import java.util.logging.*;

import static java.lang.Math.sqrt;

public class RootExtractor implements Operation {
    private static final Logger logger = Logger.getLogger("RootExtractor");
    @Override
    public void Calculate(Context context) throws WrongArgsException, BadNumberOfArgumentsException, EmptyStackException, ExtractingRootOfNegativeNumException {
        if (context.getWords().length != 1) {
            throw new BadNumberOfArgumentsException("SQRT");
        }
        if (context.getStack().isEmpty()) {
            throw new EmptyStackException();
        }
        String elem1 = context.contextStackPop();
        Double NumberElem1;
        Double res;
        if (Worker.isNumeric(elem1)) {
            NumberElem1 = Double.parseDouble(elem1);
            if (NumberElem1 < 0) {
                throw new ExtractingRootOfNegativeNumException();
            }
        } else {
            throw new WrongArgsException();
        }

        res = sqrt(NumberElem1);
        context.contextStackPush(res.toString());
        logger.info("Root of a " + elem1 + " successfully extracted");

    }
}
