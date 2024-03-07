/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sumatoriosync;

/**
 *
 * @author j1
 */
public class SumatorioSync {

    public static void main(String[] args) {
        long i1 = 1L;
        long i2 = 20L;
        
        Acumulador ac = new Acumulador();
        
        try {
            Runtime runtime = Runtime.getRuntime();
            int procesadores = runtime.availableProcessors();
            
            long gap = ((i2 - i1)/(procesadores-1));
            
            Thread vectorHilos[] = new Thread[procesadores];
            
            for (int i = 0; i < procesadores; i++) {
               long ini = i1 + gap * i;
               long fin = i1 + gap * (i+1) - 1;
               
               if (fin > i2) {
                   fin = i2;
               }
               
               Suma sum = new Suma(ini,fin,ac); 
               
               vectorHilos[i] = new Thread(sum);
               vectorHilos[i].start();
            }
            
            for (int i = 0; i < procesadores; i++) {
                vectorHilos[i].join();
            }
            
            System.out.println(ac.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
