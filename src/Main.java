import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String args[]) throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        Thread[] threads = {
                new Producer(list),
                new Producer(list),
                new Consumer(list),
                new Consumer(list)
        };
        for (Thread thread : threads)
            thread.start();
        for (Thread thread : threads)
            thread.join();
        System.out.println("Foinish" + list.size());
    }
}