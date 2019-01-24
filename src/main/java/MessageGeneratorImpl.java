public class MessageGeneratorImpl implements MessageGenerator {

    private static int messageId = 0;

    public Message generateMessage() {
        messageId++;
        String content = "Message № " + messageId;
        return new Message(content, Priority.getPriorityRandomly());
    }
}
