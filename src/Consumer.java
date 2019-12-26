import java.util.List;

public class Consumer extends Thread {
    List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer i = 0; i < 100; i++) {
            synchronized (list) {
                while (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {

                    }
                }
                Integer fetch = list.remove(0);
                System.out.println("Fetched:" + fetch);
            }
            try {
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
