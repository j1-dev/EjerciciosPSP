/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.runtime2;

/**
 *
 * @author j1
 */
public class Runtime2 {
    private Runtime r = Runtime.getRuntime();
    
    private void InfoCPU() {
        System.out.println("Procesadores disponibles: " + this.r.availableProcessors());
    }
    
    private void InfoMem() {
        System.out.println("Memoria Total: " + this.r.totalMemory());
        System.out.println("Memoria Libre: " + this.r.freeMemory());
        System.out.println("Memoria Ocupada: " + (this.r.totalMemory() - this.r.freeMemory()));
    }
    
    private void InvocarGB() {
        this.r.gc();
    }
    
    public static void main(String[] args) {
        Runtime2 ejRt = new Runtime2();
        ejRt.InfoCPU();
        
        System.out.println("\n-----------Estado Inicial-----------");
        ejRt.InfoMem();
        
        for (int i = 0; i <= 10000; i++) {
            new Object();
        }
        
        System.out.println("\n--Estado después de crear 10000 Objectos--");
        ejRt.InfoMem();
        
        ejRt.InvocarGB();
        
        System.out.println("\n------Estado después de invocar el GB------");
        ejRt.InfoMem();
    }
}
