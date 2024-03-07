package org.example.ejemplosync;

public class SincornizacionMetodos implements Runnable {
	public void metodo1() {
		System.out.println("comienzo 1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			return;
		}
		System.out.println("fin 1");
	}

	public void metodo2() {
		System.out.println("comienzo 2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			return;
		}
		System.out.println("fin 2");
	}
	
	@Override
	public void run() {
		metodo1();
		metodo2();
	}
}
