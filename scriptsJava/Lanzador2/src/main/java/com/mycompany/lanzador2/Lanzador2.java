/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzador2;

import java.io.IOException;

/**
 *
 * @author j1
 */
public class Lanzador2 {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("google-chrome", "https://blogsaverroes.juntadeandalucia.es/iesvegademijas/");
        Process p1 = pb.start();
    }
}
