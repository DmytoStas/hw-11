package task_2;

import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {

    private final int inputNumber;
    private final AtomicInteger currentNumber = new AtomicInteger(1);

    public FizzBuzz(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public int getCurrentNumber() {
        return currentNumber.get();
    }

    public synchronized void searchFizz(Saver doValidation) {
        while (currentNumber.get() <= inputNumber) {
            if (currentNumber.get() % 3 != 0 || currentNumber.get() % 5 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            doValidation.save();
            currentNumber.addAndGet(1);
            notifyAll();
        }
    }

    public synchronized void searchBuzz(Saver doValidation) {
        while (currentNumber.get() <= inputNumber) {
            if (currentNumber.get() % 5 != 0 || currentNumber.get() % 3 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            doValidation.save();
            currentNumber.addAndGet(1);
            notifyAll();
        }
    }

    public synchronized void searchFizzBuzz(Saver doValidation) {
        while (currentNumber.get() <= inputNumber) {
            if (currentNumber.get() % 15 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            doValidation.save();
            currentNumber.addAndGet(1);
            notifyAll();
        }
    }

    public synchronized void number(Saver doValidation) {
        while (currentNumber.get() <= inputNumber) {
            if (currentNumber.get() % 3 == 0 || currentNumber.get() % 5 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            doValidation.save();
            currentNumber.addAndGet(1);
            notifyAll();
        }
    }
}
