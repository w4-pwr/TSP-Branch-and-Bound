package pl.pwr;

import java.io.*;

public class Main {

    public static final boolean DEBUG = false;

    public static void main(String[] args) {
        Writer fileOutput = null;
        try {
            fileOutput = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("wyniki.txt"), "utf-8"));

            //cool down the situation bro
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 3; i < 20; i++) {
                long timeSum = testAlgorithm(i, 10);
                fileOutput.write(String.format(" %d wierzcholkow, czas %d \n", i, timeSum));
                System.out.println(String.format(" %d wierzcholkow, czas %d", i, timeSum));
            }
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        } finally {
            try {
                fileOutput.close();
            } catch (Exception ex) {/*ignore*/}

        }
    }

    private static long testAlgorithm(int i) {

            BBAlgorithm bbAlgorithm = new BBAlgorithm(i);

            long start = System.currentTimeMillis();
            bbAlgorithm.invoke();
            long stop = System.currentTimeMillis();
        return  (stop - start);
    }

    private static long testAlgorithm(int i, int howMany) {
        long timeSum = 0;
        for (int j = 0; j < howMany; j++) {
            timeSum += testAlgorithm(i);
        }
        return timeSum/howMany;
    }
}
