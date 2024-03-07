/*
    Autor: JUAN GARCIA MARIN
    Curso: Desarrollo de Aplicaciones Multiplataforma
    Modulo: Programacion de servicios y procesos
*/

package com.mycompany.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class Ejercicio2 {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int option;

    do {
      System.out.println("Menú:");
      System.out.println("1. Mostrar números primos y su suma.");
      System.out.println("2. Mostrar números no primos y su suma.");
      System.out.println("0. Salir");
      System.out.print("Seleccione una opción: ");

      try {
        option = Integer.parseInt(reader.readLine());

        switch (option) {
          case 1:
            System.out.println("Mostrando números primos y su suma:");
            llamadaScript("Ejercicio2.py", "primo");
            break;
          case 2:
            System.out.println("Mostrando números no primos y su suma:");
            llamadaScript("Ejercicio2.py", "noprimo");
            break;
          case 0:
            System.out.println("Saliendo del programa.");
            break;
          default:
            System.out.println("Opción incorrecta. Por favor, seleccione una opción válida.");
        }
      } catch (IOException | NumberFormatException e) {
        System.out.println("Error al leer la entrada.");
        option = -1;
      }

    } while (option != 0);
  }

  private static void llamadaScript(String nombre, String argumento) throws IOException {
    // la variable pathToScript es la ruta hasta la carpeta donde se encuentra el
    // script de python.
    String pathToScript = "/home/j1/Documents/Class/PSP/ExamenUltimo/Ejercicio2/src/main/java/com/mycompany/ejercicio2/";

    ProcessBuilder processBuilder = new ProcessBuilder("python3", pathToScript + nombre, argumento);
    processBuilder.redirectOutput(Redirect.INHERIT);
    processBuilder.start();
  }
}
