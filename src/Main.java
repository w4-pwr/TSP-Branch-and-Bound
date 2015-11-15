import java.io.*;

public class Main {


    public static void main(String[] args) {
        Writer fileOutput = null;
        try {
            fileOutput = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("wynik2.txt"), "utf-8"));

//            for (int i = 3; i < 14; i++) {
//                long timeSum = testAlgorithm1Time(i);
//
//                fileOutput.write(String.format(" %d wierzcholkow, czas %d \n", i, timeSum));
//            }
            long timeSum = testAlgorithm1Time(19);
            System.out.println(String.format(" %d wierzcholkow, czas %d \n", 14, timeSum));
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        } finally {
            try {
                fileOutput.close();
            } catch (Exception ex) {/*ignore*/}

        }
    }

    private static long testAlgorithm1Time(int i) {

            long start = System.currentTimeMillis();
            BBAlgorithm bbAlgorithm = new BBAlgorithm(i);
            bbAlgorithm.invoke();
            long stop = System.currentTimeMillis();
        return  (stop - start);


    }

    private static long testAlgorithm10Times(int i) {
        long timeSum = 0;
        for (int j = 0; j < 10; j++) {
            timeSum += testAlgorithm1Time(i);
        }
        return timeSum/10;
    }
}
