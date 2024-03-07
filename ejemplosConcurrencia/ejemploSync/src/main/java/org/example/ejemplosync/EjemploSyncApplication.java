package org.example.ejemplosync;


public class EjemploSyncApplication  {

	public static void main(String[] args) {
		SincornizacionMetodos sm = new SincornizacionMetodos();
		new Thread(sm).start();
		new Thread(sm).start();
	}

}
