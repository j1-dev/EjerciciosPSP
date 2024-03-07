/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parimparthread;

/**
 *
 * @author j1
 */
public class ParImparThread {

    public static void main(String[] args) {
        ImpresorPares hiloPares1 = new ImpresorPares();
        ImpresorPares hiloPares2 = new ImpresorPares();
        ImpresorImpares hiloImpares1 = new ImpresorImpares();
        ImpresorImpares hiloImpares2 = new ImpresorImpares();

        hiloPares1.start();
        hiloPares2.start();
        hiloImpares1.start();
        hiloImpares2.start();
    }
}

class ImpresorPares extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Hilo de Pares: " + i);
        }
    }
}

class ImpresorImpares extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Hilo de Impares: " + i);
        }
    }
}

