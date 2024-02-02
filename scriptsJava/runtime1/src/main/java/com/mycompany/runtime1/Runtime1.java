/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.runtime1;

import java.io.IOException;

/**
 *
 * @author j1
 */
public class Runtime1 {

    public static void main(String[] args) throws IOException, InterruptedException {
//        String[] infoProceso = {"gedit","ejemplo1.txt"}; //Ejemplo1
        String[] infoProceso = {"firefox", "https://www.youtube.com/"};
        Process proceso = Runtime.getRuntime().exec(infoProceso);
        int codigoRetorno = proceso.waitFor();
        System.out.println("Fin de la ejecución: " + codigoRetorno);
    }
}
