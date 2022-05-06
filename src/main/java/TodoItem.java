import java.util.Objects;

public class TodoItem {

    private final String item;

    public TodoItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(item, todoItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
