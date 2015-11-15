import java.io.*;

public class Main {


    public static void main(String[] args) {
        Writer fileOutput = null;
        try {
            fileOutput = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));

            for (int i = 3; i < 15; i++) {
                long timeSum = testAlgorithm10Times(i);
                timeSum/=10;
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

    private static long testAlgorithm10Times(int i) {
        long timeSum = 0;
        for (int j = 0; j < 10; j++) {
            long start = System.currentTimeMillis();
            BBAlgorithm bbAlgorithm = new BBAlgorithm(i);
            bbAlgorithm.invoke();
            long stop = System.currentTimeMillis();
            timeSum += (stop - start);
        }
        return timeSum;
    }
}
