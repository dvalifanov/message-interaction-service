public class Message implements Comparable<Message> {
    private String content;
    private Priority priority;

    Message(String content, Priority priority) {
        this.content = content;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Message message) {
        return Integer.compare(message.priority.getValue(), this.priority.getValue());
    }
}
