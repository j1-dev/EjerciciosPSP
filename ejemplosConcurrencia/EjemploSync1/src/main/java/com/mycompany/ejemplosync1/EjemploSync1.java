/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplosync1;

/**
 *
 * @author j1
 */
import java.util.Random;

class HiloVector extends Thread {
    private int[] vector;
    private int size;

    public HiloVector(int size) {
        this.size = size;
        this.vector = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(100); // Llenado del vector con números aleatorios entre 0 y 99
        }
    }

    @Override
    public void run() {
        System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
        System.out.println("PID del hilo: " + Thread.currentThread().getId());
        System.out.println("Prioridad del hilo: " + Thread.currentThread().getPriority());

        int suma = 0;
        int sumaCuadrados = 0;
        for (int i = 0; i < size; i++) {
            suma += vector[i];
            sumaCuadrados += vector[i] * vector[i];
        }

        System.out.println("Suma de los elementos del vector: " + suma);
        System.out.println("Suma de los cuadrados de los elementos del vector: " + sumaCuadrados);
        System.out.println("Media de los elementos del vector: " + (double) suma / size);
    }
}

public class EjemploSync1 {
    public static void main(String[] args) {
        int[] tamanosVectores = {5, 10, 15}; // Tamaños de vectores para probar

        for (int tamaño : tamanosVectores) {
            System.out.println("\nResultados para un vector de tamaño " + tamaño + ":");
            HiloVector hilo = new HiloVector(tamaño);
            hilo.start();
            try {
                hilo.join(); // Esperar a que el hilo termine antes de pasar al siguiente tamaño
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
