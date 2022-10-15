package Calc;

import Calc.Operations.Operation;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                Worker worker = new Worker(args[0]);

            } else {
                System.out.println("Enter commands");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                FileWriter writer = new FileWriter("File1.txt");

                while (input != null && !input.trim().isEmpty() && !input.equals("\n")) {
                    writer.write(input + "\n");
                    input = scanner.nextLine();
                }
                writer.flush();
                writer.close();

                Worker worker = new Worker("File1.txt");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
