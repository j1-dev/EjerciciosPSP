/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sumatoriosync;

/**
 *
 * @author j1
 */
public class Acumulador {
    long acumulador = 0;
    
    Acumulador() {};
    
    long get() {
        return this.acumulador;
    }
    
    void set(long c) {
        this.acumulador = c;
    }
    
    void add(long c) {
        this.acumulador += c;
    }
}
