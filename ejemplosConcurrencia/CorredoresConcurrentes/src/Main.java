// JUAN GARCIA MARIN
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crear tres corredores
        Corredor corredor1 = new Corredor("Corredor 1");
        Corredor corredor2 = new Corredor("Corredor 2");
        Corredor corredor3 = new Corredor("Corredor 3");

        // Iniciar los threads de los corredores
        corredor1.start();
        corredor2.start();
        corredor3.start();
    }
}

class Corredor extends Thread {
    private String nombre;
    private int distanciaRecorrida;
    private float tiempo;
    private Random random;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.tiempo = 0f;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (distanciaRecorrida < 3000) {
            int tiempoEspera = random.nextInt(1000) + 500; // Tiempo aleatorio entre 500 y 1500 milisegundos
            tiempo += tiempoEspera / 1000f;
            try {
                Thread.sleep(tiempoEspera); // Espera tiempo aleatorio antes de avanzar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distanciaRecorrida += 500; 
            System.out.println(nombre + " ha recorrido " + distanciaRecorrida + " metros - " +tiempo+ "s");
        }
        System.out.println(nombre + " ha llegado a la meta!");
    }
}
