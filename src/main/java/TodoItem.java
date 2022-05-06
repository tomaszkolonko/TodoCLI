import java.util.Objects;

public class TodoItem {

    private final String item;

    public TodoItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof TodoItem && this.equals((TodoItem) o);
    }

    private boolean equals(TodoItem other) {
        return Objects.equals(this.item, other.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "item='" + item + '\'' +
                '}';
    }
}
