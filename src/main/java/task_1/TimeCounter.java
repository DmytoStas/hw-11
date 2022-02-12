package task_1;

import java.util.concurrent.atomic.AtomicInteger;

public class TimeCounter {

    private final int period;

    private final AtomicInteger seconds = new AtomicInteger(0);

    public TimeCounter(int period) {
        this.period = period;
    }

    public int getSeconds() {
        return seconds.get();
    }

    public void countTime() {
        for (int i = 0; i < period; i++) {

            seconds.addAndGet(1);

            if (seconds.get() < 10) {
                System.out.println("Щетчик времени - " + 0 + getSeconds() + " сек");
            } else {
                System.out.println("Щетчик времени - " + getSeconds() + " сек");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }
}
