package Calc;

import Calc.Exception.EmptyStackException;
import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Stack;
import java.util.TreeMap;

public class Context {
    private TreeMap<String, Double> Defines;
    private Stack<String> stack;
    private String[] words;

    public Context() {
        this.stack = new Stack();
        this.Defines = new TreeMap<>();
    }

    public void setWords(String line) {
        this.words = line.split(" ");
    }

    public String[] getWords() {
        return this.words;
    }

    public TreeMap<String, Double> getDefines() {
        return this.Defines;
    }

    public Stack<String> getContextStack() {
        return this.stack;
    }

    public void setDefines(String name, Double value)
    {
        this.Defines.put(name, value);
    }

    public Stack getStack() {
        return this.stack;
    }

    public void contextStackPush(String elem) {
        this.stack.push(elem);
    }

    public String contextStackPop() throws EmptyStackException {
        if (this.stack.empty()) {
            throw new EmptyStackException();
        }
        return this.stack.pop();
    }
    public String contextStackPeek()
    {
        return this.stack.peek();
    }
}

