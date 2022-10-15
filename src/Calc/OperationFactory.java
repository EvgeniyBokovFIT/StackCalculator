package Calc;

import Calc.Operations.Operation;

import java.io.*;
import java.util.TreeMap;

public class OperationFactory {
    private final TreeMap<String, Class> Operations;

    public OperationFactory(String cfgFilename) {
        this.Operations = new TreeMap<>();
        try {
            File cfg = new File(cfgFilename);
            BufferedReader buffer = new BufferedReader(new FileReader(cfg));
            String line = buffer.readLine();
            while (line != null) {
                try {
                    String[] words = line.split(" ");
                    this.Operations.put(words[0], Class.forName(Operation.class.getPackage().getName() + "." + words[1]));
                    line = buffer.readLine();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    TreeMap<String, Class> getOperations() {
        return this.Operations;
    }
}
