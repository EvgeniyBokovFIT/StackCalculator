package Calc;

import Calc.Exception.UnknownOperationNameException;
import Calc.Operations.Operation;

import java.io.*;

public class Worker {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Worker(String filename) throws Exception{

        try {
            File instructions = new File(filename);
            BufferedReader buffer = new BufferedReader(new FileReader(instructions));
            String line = buffer.readLine();
            OperationFactory factory = new OperationFactory("OperationsConfig.txt");
            Context context = new Context();
            while (line != null && !line.equals("\n")) {
                try {
                    String[] words = line.split(" ");
                    if (words[0].equals("#")) {
                        continue;
                    } else if (words[0].equals("DEFINE") || words[0].equals("POP") || words[0].equals("PUSH") ||
                words[0].equals("+") || words[0].equals("-") || words[0].equals("*") || words[0].equals("/") ||
                words[0].equals("SQRT") || words[0].equals("PRINT")) {
                       Operation operation = (Operation) factory.getOperations().get(words[0]).newInstance();
                       context.setWords(line);
                       operation.Calculate(context);
                    }
                    else {
                        throw new UnknownOperationNameException(words[0]);
                    }
                    line = buffer.readLine();

                }  catch (Exception e) {
                    e.printStackTrace();
                    line = buffer.readLine();
                }

            }

        } catch (Exception e) {
            throw e;
        }


    }
}

