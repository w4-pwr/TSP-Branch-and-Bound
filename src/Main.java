public class Main {



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BBAlgorithm bbAlgorithm = new BBAlgorithm();
        bbAlgorithm.invoke();
        long stop = System.currentTimeMillis();
        System.out.println(stop-start);
    }
}
