import java.util.ArrayList;
import java.util.List;

public class TodoHolder {

    private final List<TodoItem> todos = new ArrayList<>();

    void add(TodoItem item) {
        if (todos.isEmpty()) {
            item.setUniqueId(0);
        } else {
            item.setUniqueId(todos.get(todos.size() - 1));
        }
        todos.add(item);
    }

    void delete(int id) {
        todos.removeIf(item -> item.is(id));
    }

    void clearTodos() {
        todos.clear();
    }

    TodoItem retrieveItem(int id) {
        for (TodoItem todoItem : todos) {
            if (todoItem.is(id)) {
                return todoItem;
            }
        }
        // work with null objects
        return null;
    }

    void editItem(int index, TodoItem item) {
        todos.set(index, item);
    }

    void checkItem(int id) {
        todos.stream()
                .filter(item -> item.is(id))
                .findAny()
                .ifPresent(TodoItem::check);
    }

    void uncheckItem(int id) {
        todos.stream()
                .filter(item -> item.is(id))
                .findFirst()
                .ifPresent(TodoItem::uncheck);
    }

    void print() {
        todos.forEach(System.out::println);
    }

    void printOnlyCheckedItems() {
        todos.stream()
                .filter(TodoItem::isChecked)
                .forEach(System.out::println);
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
