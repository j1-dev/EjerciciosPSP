/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numparimparthreads;

/**
 *
 * @author j1
 */
class ParImparRunnable implements Runnable {
    private int inicio;
    private int fin;

    public ParImparRunnable(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i += 2) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class NumParImparThreads {
    public static void main(String[] args) {
        Thread par1 = new Thread(new ParImparRunnable(2, 10));
        Thread par2 = new Thread(new ParImparRunnable(2, 10));

        par1.setName("Hilo Par 1");
        par2.setName("Hilo Par 2");

        Thread impar1 = new Thread(new ParImparRunnable(1, 10));
        Thread impar2 = new Thread(new ParImparRunnable(1, 10));

        impar1.setName("Hilo Impar 1");
        impar2.setName("Hilo Impar 2");

        par1.start();
        par2.start();
        impar1.start();
        impar2.start();
    }
}
