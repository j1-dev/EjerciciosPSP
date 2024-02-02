/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2redireccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author j1
 */
public class Ejercicio2Redireccion {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, proporciona el nombre del archivo de salida.");
            System.exit(1);
        }

        String nombreArchivoSalida = args[0];

        try {
            // Comando para listar procesos y su terminal en sistemas Unix
            String comando = "ps -e -o pid,tty,command";

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
