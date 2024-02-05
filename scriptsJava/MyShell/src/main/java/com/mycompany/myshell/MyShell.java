////////////////////////////////////////////////////////////////////////////////
////  EJERCICIO 1: MYSHELL  ////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Realizado por: Juan Garcia Marin  ////////
////////////////////////////////////////////////////////////////////////////////


package com.mycompany.myshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author j1
 */
public class MyShell {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command;

            while (true) {
                System.out.print("#MyShell> ");
                command = reader.readLine();

                if (command.equals("quit")) {
                    System.out.println("Exiting MyShell...");
                    break;
                }

                executeCommand(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command.split("\\s+"));
            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                printColoredOutput(process.getInputStream(), "\u001B[32m"); // Green color
            } else {
                printColoredOutput(process.getErrorStream(), "\u001B[31m"); // Red color
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printColoredOutput(java.io.InputStream inputStream, String colorCode) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(colorCode + line + "\u001B[0m"); // Reset color
        }
    }
}
