/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ampliacion;

import java.io.IOException;
import java.time.ZonedDateTime;

/**
 *
 * @author j1
 */
public class Ampliacion {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona al menos un programa ejecutable.");
            return;
        }

        for (String programa : args) {
            ejecutarPrograma(programa);
        }
    }

    public static void ejecutarPrograma(String programa) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(programa);
            Process proceso = processBuilder.start();
            long pid = proceso.pid();
            ZonedDateTime inicio = ZonedDateTime.now();

            System.out.println("Lanzado el comando " + programa + " con PID " + pid + " en " + inicio);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el programa " + programa + ": " + e.getMessage());
        }
    }
}
