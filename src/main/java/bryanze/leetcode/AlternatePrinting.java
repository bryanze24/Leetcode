package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/09/05
 */
public class AlternatePrinting {

    private static final Object lock = new Object();
    private static boolean isZeroTurn = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(new ZeroOnePrinter(true));
        Thread t2 = new Thread(new ZeroOnePrinter(false));

        t1.start();
        t2.start();
    }

    static class ZeroOnePrinter implements Runnable {
        private boolean printZero;

        public ZeroOnePrinter(boolean printZero) {
            this.printZero = printZero;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    while (isZeroTurn != printZero) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(printZero ? "0" : "1");
                    isZeroTurn = !isZeroTurn;
                    lock.notifyAll();
                    i++;
                }
            }
        }
    }
}

