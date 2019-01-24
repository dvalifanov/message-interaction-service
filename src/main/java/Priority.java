import java.util.Random;

public enum Priority {

    LOW(0),
    MIDDLE(1),
    HIGH(2);

    private static final Random RANDOM = new Random();
    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public static Priority getPriorityRandomly() {
        return Priority.values()[RANDOM.nextInt(3)];
    }

    public int getValue() {
        return value;
    }
}
