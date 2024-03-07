/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.supermercado;

/**
 *
 * @author j1
 */
import java.util.Arrays;

class Cajera extends Thread {
    private Cliente cliente;

    public Cajera(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        int[] productos = cliente.getProductos();
        int tiempoTotal = Arrays.stream(productos).sum();

        System.out.println("Cobrando productos del cliente: " + cliente.getId());
        for (int producto : productos) {
            try {
                Thread.sleep(producto * 1000); // Simula el tiempo que tarda en escanear un producto
                System.out.println("Producto escaneado: " + producto + " segundos.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cliente " + cliente.getId() + " ha sido cobrado en " + tiempoTotal + " segundos.");
    }
}

class Cliente {
    private static int idCounter = 1;
    private int id;
    private int[] productos;

    public Cliente(int[] productos) {
        this.id = idCounter++;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public int[] getProductos() {
        return productos;
    }
}

public class Supermercado {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(new int[]{1, 9, 4});
        Cliente cliente2 = new Cliente(new int[]{2, 4, 6});

        Cajera cajera1 = new Cajera(cliente1);
        Cajera cajera2 = new Cajera(cliente2);

        cajera1.start();
        cajera2.start();
    }
}
