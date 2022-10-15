package Calc.Test;

import Calc.Context;
import Calc.Exception.*;
import Calc.Operations.*;

import static org.junit.jupiter.api.Assertions.*;

class Tester {

    @org.junit.jupiter.api.Test
    void testAdderCalculate() throws BadNumberOfArgumentsException, WrongArgsException, EmptyStackException {
        Context context = new Context();
        context.contextStackPush("5");
        context.contextStackPush("18");
        context.setWords("+");
        Adder adder = new Adder();
        adder.Calculate(context);
        assertEquals("23.0", context.contextStackPeek());
    }

    @org.junit.jupiter.api.Test
    void testDefinerCalculate() throws BadNumberOfArgumentsException, WrongArgsException {
        Context context = new Context();
        context.setWords("DEFINE a 7");
        Definer definer = new Definer();
        definer.Calculate(context);
        assertEquals(7, context.getDefines().get("a"));
    }

    @org.junit.jupiter.api.Test
    void testDividerCalculate() throws BadNumberOfArgumentsException, WrongArgsException, EmptyStackException, DivisionByZeroException {
        Context context = new Context();
        context.contextStackPush("5");
        context.contextStackPush("18");
        context.setWords("/");
        Divider divider = new Divider();
        divider.Calculate(context);
        assertEquals("3.6", context.contextStackPeek());
    }

    @org.junit.jupiter.api.Test
    void testMultiplierCalculate() throws BadNumberOfArgumentsException, WrongArgsException, EmptyStackException {
        Context context = new Context();
        context.contextStackPush("5");
        context.contextStackPush("18");
        context.setWords("*");
        Multiplier multiplier = new Multiplier();
        multiplier.Calculate(context);
        assertEquals("90.0", context.contextStackPeek());
    }
    @org.junit.jupiter.api.Test
    void testPopperCalculate() throws EmptyStackException, BadNumberOfArgumentsException {
        Context context = new Context();
        context.contextStackPush("5");
        context.setWords("POP");
        Popper popper = new Popper();
        popper.Calculate(context);
        assertEquals(true, context.getContextStack().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testPusherCalculate() throws BadNumberOfArgumentsException, WrongArgsException {
        Context context = new Context();
        context.setWords("PUSH 5");
        Pusher pusher = new Pusher();
        pusher.Calculate(context);
        assertEquals("5", context.contextStackPeek());
    }

    @org.junit.jupiter.api.Test
    void testRootExtractorCalculate() throws BadNumberOfArgumentsException, WrongArgsException, EmptyStackException, ExtractingRootOfNegativeNumException {
        Context context = new Context();
        context.contextStackPush("81");
        context.setWords("SQRT");
        RootExtractor extractor = new RootExtractor();
        extractor.Calculate(context);
        assertEquals("9.0", context.contextStackPeek());
    }

    @org.junit.jupiter.api.Test
    void testSubtractorCalculate() throws BadNumberOfArgumentsException, WrongArgsException, EmptyStackException {
        Context context = new Context();
        context.contextStackPush("5");
        context.contextStackPush("18");
        context.setWords("-");
        Subtractor subtractor = new Subtractor();
        subtractor.Calculate(context);
        assertEquals("13.0", context.contextStackPeek());
    }
}