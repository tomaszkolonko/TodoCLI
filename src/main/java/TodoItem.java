import java.util.Objects;

public class TodoItem {

    private final String item;
    private boolean marked = false;
    private final int id;

    public TodoItem(String item, int id) {
        this.item = item;
        this.id = id;
    }

    public TodoItem(String item, boolean marked, int id) {
        this(item, id);
        this.marked = marked;
    }

    public void check() {
        this.marked = true;
    }

    public void uncheck() {
        this.marked = false;
    }

    public boolean isChecked() {
        return marked;
    }

    public int getUniqueId() {
        return id;
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
