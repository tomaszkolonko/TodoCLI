import java.util.Objects;

public class TodoItem {

    private final String item;
    private boolean marked = false;

    private int id = -1;

    public TodoItem(String item) {
        this.item = item;
    }

    public TodoItem(String item, boolean marked) {
        this(item);
        this.marked = marked;
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

    public void setUniqueId(TodoItem item) {
        this.id = item.id + 1;
    }

    public void setUniqueId(int id) {
        this.id = id;
    }

    public boolean is(int id) {
        return this.id == id;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof TodoItem && this.equals((TodoItem) o);
    }

    private boolean equals(TodoItem other) {
        return this.item.equals(other.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return id + ": [" + (marked ? "x" : " ") + "]  " + item;
    }
}
