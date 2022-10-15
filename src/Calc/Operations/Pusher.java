package Calc.Operations;

import Calc.Context;
import Calc.Exception.BadNumberOfArgumentsException;
import Calc.Exception.WrongArgsException;
import Calc.Worker;

import java.util.logging.Logger;

public class Pusher implements Operation {
    private static final Logger logger = Logger.getLogger("Pusher");
    @Override
    public void Calculate(Context context) throws WrongArgsException, BadNumberOfArgumentsException {
        if(context.getWords().length != 2) {
            throw new BadNumberOfArgumentsException("PUSH");
        }
        String elem = context.getWords()[1];
        if (Worker.isNumeric(elem)){
            context.contextStackPush(elem);
        }
        else if(context.getDefines().containsKey(elem))
        {
            context.contextStackPush(context.getDefines().get(elem).toString());
        }
        else {
            throw new WrongArgsException();
        }
        logger.info("'" + elem + "'" + " successfully pushed onto the stack");
    }

}

