import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class App {
    public static void main(String[] args) {
        final var numberOfConsumers = 5;
        final var queues = new ArrayList<BlockingQueue<Message>>();
        final var consumers = new ArrayList<Consumer>();
        final var executor = Executors.newFixedThreadPool(numberOfConsumers + 1);

        for (int i = 0; i < numberOfConsumers; i++) {
            final var queue = new PriorityBlockingQueue<Message>();
            final var consumer = new Consumer(queue, i);
            queues.add(queue);
            consumers.add(consumer);
        }
        final var producer = new Producer(queues, new MessageGeneratorImpl());

        consumers.forEach(executor::execute);
        executor.execute(producer);
    }
}
