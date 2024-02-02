/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzador3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author j1
 */
public class Lanzador3 {

    public static void main(String[] args) throws InterruptedException, IOException {
        String app[] = {"firefox", "https://google.com"};
        ProcessBuilder pb = new ProcessBuilder(app);
        Process p = pb.start();
        
        boolean isProcessDead = p.waitFor(3, TimeUnit.SECONDS);
        
        if(!isProcessDead) {
            System.out.println("Destruyendo la aplicacion");
            p.destroy();
        }
        
        while(p.isAlive()) {
            System.out.println("El proceso sigue vivo. Espero un milisegundo");
            p.waitFor(1,TimeUnit.MILLISECONDS);
        }
        
        System.out.println("El proceso ha finalizado con la salida: " + p.exitValue());
    }
}
