import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class App {
    public static void main(String[] args) {
        final var queue = new PriorityBlockingQueue<Message>();
        final var executor = Executors.newFixedThreadPool(2);
        final var producer = new Producer(queue, new MessageGeneratorImpl());
        final var consumer = new Consumer(queue);

        executor.execute(producer);
        executor.execute(consumer);
    }
}
