package pl.pwr;

import java.io.*;

public class Main {

    public static final boolean DEBUG = false;
    public static final int MORE_INFO = 10;

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

            for (int i = 3; i < 21; i++) {
                if(i > MORE_INFO) {
                    System.out.println(i + " wierzchołki > czas poszczególnych przejść: ");
                }
                long timeSum = -1;
                if(i == 19){
                    timeSum = testAlgorithm(i, 5);
                } else if (i == 20){
                     timeSum = testAlgorithm(i, 3);
                }

                timeSum = testAlgorithm(i, 10);

                System.out.println(i + " wierzchołki, średnia: " + timeSum);
                fileOutput.write(String.format(" %d wierzcholkow, czas %d \n", i, timeSum));
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
            long singleTime = testAlgorithm(i);
            if(i > MORE_INFO){
            System.out.println("przejście " + j + " czas: " + singleTime);
            }

            timeSum += singleTime;
        }
        return timeSum/howMany;
    }
}
