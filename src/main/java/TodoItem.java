import java.util.Objects;

public class TodoItem {

    private final String item;
    private boolean marked;

    public TodoItem(String item) {
        this.item = item;
        this.marked = false;
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
        return "[" + (marked ? "x" : " ") + "]  " + item;
    }

    public void check() {
        this.marked = true;
    }

    public void uncheck() {
        this.marked = false;
    }

    public boolean isChecked() {
        return this.marked;
    }
}
