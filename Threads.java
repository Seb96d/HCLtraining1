public class Threads {

    public static void main(String[] args) {
        PrintOdd printOdd = new PrintOdd();
        PrintEven printEven = new PrintEven();

        printOdd.start();
        printEven.start();

        System.out.println("Im ENDED");
    }

    static class PrintOdd extends Thread {
        public void run() {
            for (int i = 1; i < 20; i = i + 2) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class PrintEven extends Thread {
        public void run() {
            for (int i = 0; i < 20; i = i + 2) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}