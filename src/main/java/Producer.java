import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;
    private final MessageGenerator messageGenerator;
    private final Random random = new Random();
    private final int maxDelayBetweenMessages = 5000;

    Producer(BlockingQueue<Message> queue, MessageGenerator messageGenerator) {
        this.queue = queue;
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(maxDelayBetweenMessages));
                queue.put(messageGenerator.generateMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Interruption", e);
        }
    }
}
