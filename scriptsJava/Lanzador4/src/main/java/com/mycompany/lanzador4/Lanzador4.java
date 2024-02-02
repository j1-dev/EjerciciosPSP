/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzador4;

import java.io.IOException;

/**
 *
 * @author j1
 */
public class Lanzador4 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("google-chrome", "https://blogsaverroes.juntadeandalucia.es/iesvegademijas/");
        Process p1 = pb.start();
        Process p2 = pb.start();
        
        System.out.println("PID del proceso 1: "+p1.pid());
        System.out.println("PID del proceso 2: "+p2.pid());
    }
}
