import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = queue.take();
                Thread.sleep(1000);
                System.out.println(message.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Interruption", e);
        }
    }
}
