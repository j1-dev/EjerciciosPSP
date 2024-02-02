/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzador2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author j1
 */
public class Lanzador2 {

    public static void main(String[] args) throws IOException {
        try {
            // Comando para listar procesos y su terminal en sistemas Unix
            String comando = "ps -e -o pid,tty,command";

            // Crear un proceso para ejecutar el comando
            ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", comando);
            Process proceso = builder.start();

            // Obtener la entrada de la consola del proceso
            InputStream inputStream = proceso.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Leer y mostrar la salida del comando línea por línea
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

            // Cerrar los recursos
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
