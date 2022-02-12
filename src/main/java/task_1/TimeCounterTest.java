package task_1;

public class TimeCounterTest {

    private static final int PERIOD = 12;

    private static final TimeCounter count = new TimeCounter(PERIOD);

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (count.getSeconds() != PERIOD) {
                if (count.getSeconds() % 5 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - \"Прошло " + 5 + " секунд\"");
                    System.out.println("----------------------------------");
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
            }
                }
        });
        thread.setName("Поток_0");
        thread.start();

        count.countTime();

    }
}
