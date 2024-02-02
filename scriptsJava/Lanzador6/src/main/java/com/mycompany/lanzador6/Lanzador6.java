/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzador6;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author j1
 */
public class Lanzador6 {

   public static void main(String[] args) {
        try {
            // Comando para abrir Firefox
            ProcessBuilder processBuilder = new ProcessBuilder("firefox", "https://www.google.com");
            Process process = processBuilder.start();

            // Obtener el PID del proceso
            long pid = process.pid();

            // Ruta del programa
            String programPath = processBuilder.command().get(0);

            // Obtener la línea de comandos que lo ejecuta
            String commandLine = String.join(" ", processBuilder.command());

            // Fecha/hora del inicio de la instancia
            Date startDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Usuario que lo ha iniciado
            String userName = System.getProperty("user.name");

            // Mostrar la información por pantalla
            System.out.println("PID: " + pid);
            System.out.println("Ruta del programa: " + programPath);
            System.out.println("Línea de comandos: " + commandLine);
            System.out.println("Fecha/hora de inicio: " + dateFormat.format(startDate));
            System.out.println("Usuario: " + userName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
