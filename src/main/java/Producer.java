import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final List<BlockingQueue<Message>> queues;
    private final MessageGenerator messageGenerator;
    private final Random random = new Random();
    private final int maxDelayBetweenMessages = 5000;

    Producer(List<BlockingQueue<Message>> queues, MessageGenerator messageGenerator) {
        this.queues = queues;
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(maxDelayBetweenMessages));
                final var message = messageGenerator.generateMessage();
                queues.forEach(queue -> {
                    try {
                        queue.put(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException("Interruption", e);
                    }
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Interruption", e);
        }
    }
}
