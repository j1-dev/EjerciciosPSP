/*
    Autor: JUAN GARCIA MARIN
    Curso: Desarrollo de Aplicaciones Multiplataforma
    Modulo: Programacion de servicios y procesos
*/

package com.mycompany.ejercicio1;

import java.util.Random;

class Liebre extends Thread {
    private int posicion = 0;

    public void run() {
        Random random = new Random();

        while (posicion < 100) {
            int avance = random.nextInt(6); // Liebre avanza entre 0 y 5 casillas
            if (avance == 0) {
                System.out.println("La liebre se durmió.");
            } else {
                posicion += avance;
                System.out.println("Liebre avanza " + avance + " casillas. Se encuentra en la casilla " + posicion);
            }

            
        }

        System.out.println("¡La liebre ha llegado a la meta!");
    }
}

class Tortuga extends Thread {
    private int posicion = 0;

    public void run() {
        Random random = new Random();

        while (posicion < 100) {
            int avance = random.nextInt(3) + 1; // Tortuga avanza entre 1 y 3 casillas
            posicion += avance;

            System.out.println("Tortuga avanza " + avance + " casillas. Se encuentra en la casilla " + posicion);
        }

        System.out.println("¡La tortuga ha llegado a la meta!");
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Liebre liebre = new Liebre();
        Tortuga tortuga = new Tortuga();
        
        liebre.start();
        tortuga.start();
    }
}
