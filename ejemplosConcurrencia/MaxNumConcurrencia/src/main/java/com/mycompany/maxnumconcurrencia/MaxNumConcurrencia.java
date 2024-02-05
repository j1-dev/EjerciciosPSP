package com.mycompany.maxnumconcurrencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class MaxNumConcurrencia {

     public static String[] creaVector(int len) {
        String[] newArray = new String[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = String.valueOf((long) (Math.random() * Long.MAX_VALUE) + 1);
        }
        return newArray;
    }

    public static void main(String[] args) {
        // Get the current working directory
        String currentPath = System.getProperty("user.dir");

        // Print the current working directory
        System.out.println("Current Path: " + currentPath);
        if (args.length != 1) {
            System.out.println("Numero incorrecto de argumentos");
            System.exit(0);
        }

        int len = Integer.parseInt(args[0]);
        String[] vectorNumeros = creaVector(len);

        int numProcesadores = Runtime.getRuntime().availableProcessors();
        int tamanoSubvector = len / numProcesadores;

        long maxGlobal = 0;

        for (int i = 0; i < numProcesadores; i++) {
            int inicio = i * tamanoSubvector;
            int fin = (i == numProcesadores - 1) ? len : (i + 1) * tamanoSubvector;
            String[] subvector = new String[fin - inicio];
            System.arraycopy(vectorNumeros, inicio, subvector, 0, fin - inicio);

            // Unir los elementos del subvector en una cadena separada por espacios
            StringJoiner sj = new StringJoiner(" ");
            for (String num : subvector) {
                sj.add(num);
            }
            String subvectorString = sj.toString();

            // Ejecutar el subproceso usando Runtime
            try {
                Process process = Runtime.getRuntime().exec("java "+ currentPath +"/src/main/java/com/mycompany/maxnumconcurrencia/MaxNumSubproceso.java " + subvectorString);

                // Leer la salida del subproceso
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        long maxParcial = Long.parseLong(line.trim());
                        if (maxParcial > maxGlobal) {
                            maxGlobal = maxParcial;
                        }
                    }
                }

                // Esperar a que el subproceso termine
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    // Imprimir cualquier error del subproceso si es necesario
                    try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                        String errorLine;
                        while ((errorLine = errorReader.readLine()) != null) {
                            System.err.println("Error en el subproceso: " + errorLine);
                        }
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Máximo global: " + maxGlobal);
    }
}
