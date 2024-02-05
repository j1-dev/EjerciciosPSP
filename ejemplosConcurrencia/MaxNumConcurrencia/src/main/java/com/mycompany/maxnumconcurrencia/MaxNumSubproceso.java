/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maxnumconcurrencia;

/**
 *
 * @author j1
 */
public class MaxNumSubproceso {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Numero incorrecto de argumentos");
            System.exit(1);
        }

        long max = encuentraMaximo(args);
        System.out.println(max);
    }

    public static long encuentraMaximo(String[] vector) {
        long max = 0;
        for (int i = 0; i < vector.length; i++) {
            long aux = Long.parseLong(vector[i]);
            if (aux > max) max = aux;
        }
        return max;
    }
}
