package task_2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FizzBuzzTest {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(60);

        List<String> result = new CopyOnWriteArrayList<>();

        Saver saveFizz = () -> result.add("Fizz");
        Saver saveBuzz = () -> result.add("Buzz");
        Saver saveFizzBuzz = () -> result.add("FizzBuzz");
        Saver saveNumber = () -> result.add(String.valueOf(fizzBuzz.getCurrentNumber()));


        Thread threadA = new Thread(() -> fizzBuzz.searchFizz(saveFizz));

        Thread threadB = new Thread(() -> fizzBuzz.searchBuzz(saveBuzz));

        Thread threadC = new Thread(() -> fizzBuzz.searchFizzBuzz(saveFizzBuzz));

        Thread threadD = new Thread(() -> fizzBuzz.number(saveNumber));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(result);
    }
}
