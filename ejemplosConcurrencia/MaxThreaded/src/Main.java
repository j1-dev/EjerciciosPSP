// JUAN GARCIA MARIN
import java.util.ArrayList;

class MaxCalculator implements Runnable {
    private ArrayList<Integer> sublist;
    private SharedMax sharedMax;

    public MaxCalculator(ArrayList<Integer> sublist, SharedMax sharedMax) {
        this.sublist = sublist;
        this.sharedMax = sharedMax;
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        for (int num : sublist) {
            if (num > max) {
                max = num;
            }
        }
        sharedMax.update(max);
    }
}

class SharedMax {
    private int max = Integer.MIN_VALUE;

    public synchronized void update(int newMax) {
        if (newMax > max) {
            max = newMax;
        }
    }

    public synchronized int getMax() {
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            numbers.add(Integer.parseInt(args[i]));
        }

        int numThreads = Runtime.getRuntime().availableProcessors(); // Número de threads que deseas utilizar
        int sublistSize = numbers.size() / numThreads;

        SharedMax sharedMax = new SharedMax();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int start = i * sublistSize;
            int end = (i == numThreads - 1) ? numbers.size() : (i + 1) * sublistSize;
            ArrayList<Integer> sublist = new ArrayList<>(numbers.subList(start, end));
            MaxCalculator calculator = new MaxCalculator(sublist, sharedMax);
            Thread thread = new Thread(calculator);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El máximo de la lista es: " + sharedMax.getMax());
    }
}
