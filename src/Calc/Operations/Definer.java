package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.WrongArgsException;
import Calc.Worker;

import java.util.logging.Logger;

public class Definer implements Operation {
    private static final Logger logger = Logger.getLogger("Definer");
    @Override
    public void Calculate(Context context) throws WrongArgsException, BadNumberOfArgumentsException {
        if (context.getWords().length != 3) {
            throw new BadNumberOfArgumentsException("DEFINE");
        }
        if (!Worker.isNumeric(context.getWords()[2])) {
            throw new WrongArgsException();

        } else {
            context.setDefines(context.getWords()[1], Double.parseDouble(context.getWords()[2]));
        }
        logger.info("'" + context.getWords()[1] +"'" + " successfully defined like " + context.getWords()[2]);

    }
}
