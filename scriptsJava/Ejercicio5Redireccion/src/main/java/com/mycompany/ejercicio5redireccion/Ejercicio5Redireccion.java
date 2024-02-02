/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio5redireccion;

import java.io.IOException;

/**
 *
 * @author j1
 */
public class Ejercicio5Redireccion {

    public static void main(String[] args) throws InterruptedException {
        try {
            ProcessBuilder pb = new ProcessBuilder("ps", "aux");
                        
            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            
            pb.start();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
