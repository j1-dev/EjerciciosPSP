package ejemploC;

import java.io.File;
import java.io.IOException;

public class Lanzador {
	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("/home/j1/Documents/Class/PSP/ejemplosConcurrencia/ejemploC/ejemplo");
			pb.directory(new File("/home/j1/Documents/Class/PSP/ejemplosConcurrencia/ejemploC"));
			Process proceso = pb.start();
			int vr = proceso.waitFor();
			if (vr == 0) {
				System.out.println("el proceso se ha completado satisfactoriamente");
			} else {
				System.out.println("ERROR");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
