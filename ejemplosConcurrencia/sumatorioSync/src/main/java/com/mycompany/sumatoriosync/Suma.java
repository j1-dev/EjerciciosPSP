/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sumatoriosync;

/**
 *
 * @author j1
 */
public class Suma implements Runnable {
    long n1;
    long n2;
    Acumulador ac;
    
    Suma() {
        this.n1 = 0;
        this.n2 = 0;
    }
    
    Suma(long n1, long n2, Acumulador ac) {
        this.n1 = n1;
        this.n2 = n2;
        this.ac = ac;
    }
    
    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        System.out.println("Iniciando: " + hiloActual.getName() + " / n1 = " + this.n1 + " / n2 = " + this.n2);
        
        long res = 0;
        
        try {            
            for (long i = this.n1; i <= this.n2; i++) {
                res += i;
            }
            
            Thread.sleep(500);
            System.out.println("finalizando hilo " + hiloActual.getName());
            System.out.println("Resultado: " + res);
            long tmp = this.ac.get();
            this.ac.set(res+tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
