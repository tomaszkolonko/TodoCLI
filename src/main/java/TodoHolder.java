import java.util.ArrayList;
import java.util.List;

public class TodoHolder {

    private final List<TodoItem> todos = new ArrayList<>();
    private final int NEGATIVE_OFFSET = -1;

    int getNextID() {
        return todos
                .stream()
                .mapToInt(TodoItem::getId)
                .max()
                .orElse(NEGATIVE_OFFSET) + 1;
    }

    void add(final TodoItem item) {
        todos.add(item);
    }

    void delete(final int id) {
        todos.removeIf(item -> item.is(id));
    }

    void clearTodos() {
        todos.clear();
    }

    TodoItem retrieveItem(final int id) {
        for (TodoItem todoItem : todos) {
            if (todoItem.is(id)) {
                return todoItem;
            }
        }
        // TODO refactor to use optional
        // work with "null object pattern"
        return null;
    }

    void replaceItem(final int index, final TodoItem item) {
        todos.set(index, item);
    }

    void checkItem(final int id) {
        todos.stream()
                .filter(item -> item.is(id))
                .findAny()
                .ifPresent(TodoItem::check);
    }

    void uncheckItem(final int id) {
        todos.stream()
                .filter(item -> item.is(id))
                .findFirst()
                .ifPresent(TodoItem::uncheck);
    }

    void print() {
        todos.forEach(System.out::println);
        System.out.println("================");
        final String quantifier = todos.stream().filter(todoItem -> !todoItem.isChecked()).count() >= 3 ? "still" : "only";
        System.out.println(quantifier + " " + todos.stream().filter(todoItem -> !todoItem.isChecked()).count() + " to go...\n");
    }

    void printOnlyCheckedItems() {
        todos.stream()
                .filter(TodoItem::isChecked)
                .forEach(System.out::println);
    }

    void clearCheckedTodos() {
        todos.removeIf(TodoItem::isChecked);
    }

    void printOnlyUncheckedItems() {
        todos.stream()
                .filter(todoItem -> !todoItem.isChecked())
                .forEach(System.out::println);
    }

    public int getTodoSize() {
        return todos.size();
    }

    public int getIndexOf(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).is(id)) {
                return i;
            }
        }
        return -1;
    }
}
