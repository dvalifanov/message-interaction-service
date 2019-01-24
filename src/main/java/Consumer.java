import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;
    private final int consumerId;

    Consumer(BlockingQueue<Message> queue, int consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = queue.take();
                Thread.sleep(1000);
                System.out.println(String.format("Consumer {%d} %s", consumerId, message.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Interruption", e);
        }
    }
}
