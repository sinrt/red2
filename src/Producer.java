import java.util.LinkedList;
import java.util.List;

public class Producer extends Thread {
    List<Integer> list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                Integer num = (int) (Math.random() * 1000);
                System.out.println("add:" + num);
                list.add(num);
                list.notify();
            }
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
