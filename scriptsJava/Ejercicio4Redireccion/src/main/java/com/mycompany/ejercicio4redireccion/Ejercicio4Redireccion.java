/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio4redireccion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author j1
 */
public class Ejercicio4Redireccion {

    public static void main(String[] args) {
        try {
            // Pedir al usuario el comando a ejecutar
            System.out.print("Ingrese el comando a ejecutar: ");
            Scanner scanner = new Scanner(System.in);
            String comando = scanner.nextLine();

            // Pedir al usuario el nombre del archivo de salida
            System.out.print("Ingrese el nombre del archivo de salida: ");
            String nombreArchivoSalida = scanner.nextLine();

            // Crear un proceso para ejecutar el comando
            ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", comando);

            // Redirigir la salida estándar al archivo
            File archivoSalida = new File(nombreArchivoSalida);
            builder.redirectOutput(archivoSalida);

            Process proceso = builder.start();

            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
