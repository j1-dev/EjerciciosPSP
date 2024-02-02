////////////////////////////////////////////////////////////////////////////////
////  EXAMEN PROCESOS  /////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Realizado por: Juan Garcia Marin  ////////
////////////////////////////////////////////////////////////////////////////////

package com.mycompany.examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import static java.lang.Runtime.getRuntime;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Se pide diseñar en Java un programa que permita lanzar distintas aplicaciones y/o comandos introducidos por el usuario. Para ello:

Deberá ofrecer un menú que permite elegir entre las siguientes opciones:
    -Lanzar una página web que introducirá el usuario.
    -Ejecutar un comando que introducirá el usuario. Tenga en cuenta que el usuario podrá introducir un comando compuesto, es decir, de tipo ls -l
    -Ejecutar una aplicación instalada en el sistema operativo de tipo Block de notas, calculadora, etc. Podrá pasarle un argumento para, por ejemplo, abrir un archivo de texto que se indica.
    -Conocer el estado de la Memoria de la máquina: RAM disponible y memoria ocupada.
    -Salir del programa.

El programa se ejecutará de forma indefinida hasta que el usuario elija la opción de Salir del programa.
Los datos que debe introducir el usuario, deberá de preguntárselo una vez introducida la opción que desea ejecutar el usuario.
El programa incluirá al principio (en comentarios) el nombre y apellidos del alumno.
*/

/**
 *
 * @author j1
 */
public class Examen {
    static Runtime r = getRuntime();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        String opcion;
        do {
            System.out.println("---- PROGRAMA EXAMEN PROCESOS JAVA ----");
            System.out.println("1. Lanzar una pagina web que introducira el usuario");
            System.out.println("2. Ejecutar un comando que introducira el usuario");
            System.out.println("3. Ejeccutar una aplicacion instalada en el sistema operativo");
            System.out.println("4. Conocer el estado de la Memoria de la maquina");
            System.out.println("5. Salir del programa");
            
            System.out.print("-- Introduzca una opcion: ");
            opcion = s.nextLine();
            
            switch(opcion) {
                case "1":
                    lanzarWeb();
                    break;
                case "2":
                    lanzarComando();
                    break;
                case "3":
                    lanzarSO();
                    break;
                case "4":
                    getStatus();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;
            }
        } while(!opcion.equals("5"));
    }
    
    public static void lanzarWeb() {
        System.out.println("-- Opcion 1: Lanzar una pagina web --");
        System.out.print("-- Introduzca la pagina que quiere visitar: ");
        
        String pagina = s.next();
        
        try {
            r.exec("firefox https://www."+pagina+".com");
        } catch (IOException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void lanzarComando() throws InterruptedException {
        System.out.println("-- Opcion 2: Ejecutar un comando --");
        System.out.print("-- Introduzca el comando a ejecutar: ");
        String comando = s.nextLine();
        String[] comandoSplit = comando.split(" ");

        try {
            ProcessBuilder pb = new ProcessBuilder(comandoSplit);
            pb.redirectOutput(Redirect.INHERIT);
            Process proceso = pb.start();
            proceso.waitFor();
        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
        }
    }

    private static void lanzarSO() {
        System.out.println("-- Opcion 3: Ejecutar una aplicacion del SO --");
        System.out.print("-- Introduzca el nombre de la aplicación a ejecutar: ");
        String aplicacion = s.next();
        System.out.print("-- Introduzca el argumento (si es necesario): ");
        String argumento = s.next();

        try {
            String comando = aplicacion + " " + argumento;
            Process proceso = r.exec(comando);
        } catch (IOException e) {
            System.err.println("Error al ejecutar la aplicación: " + e.getMessage());
        }
    }


    private static void getStatus() {
        System.out.println("-- Opcion 4: Conocer el estado de la Memoria de la maquina --");
        System.out.println("-- Memoria Total: " + r.totalMemory() + ".");
        System.out.println("-- Memoria Libre: " + r.freeMemory() + ".");
        System.out.println("-- Memoria Ocupada: " + (r.totalMemory() - r.freeMemory())+ ".");
        System.out.println("-- Procesadores disponibles: " + r.availableProcessors() + ".");
    }
}
