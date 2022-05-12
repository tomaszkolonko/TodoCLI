import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoHolder {

    private final List<TodoItem> todos = new ArrayList<>();

    void add(TodoItem item) {
        if(todos.isEmpty()) {
            item.setUniqueId(0);
        } else {
            item.setUniqueId(todos.get(todos.size()-1));
        }
        todos.add(item);
    }

    void delete(TodoItem item) {
        todos.remove(item);
    }

    void clearTodos() {
        todos.clear();
    }

    TodoItem retrieveItem(String todo) {
        TodoItem item = new TodoItem(todo);

        for(TodoItem todoItem : todos) {
            if(todoItem.equals(item)) {
                return todoItem;
            }
        }
        // work with null objects
        return null;
    }

    void editItem(int id) {
        for(int i = 0; i < todos.size(); i++) {
            TodoItem todoItem = todos.get(i);
            if(todoItem.is(id)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Item was retrieved. What's the text?");
                String text = scanner.nextLine();
                System.out.println("is it a checked item? [yes|no]");
                String isChecked = scanner.nextLine().toLowerCase();
                TodoItem newItem = new TodoItem(text, isChecked.equals(("yes")));
                newItem.setUniqueId(id);
                todos.set(i, newItem);
            }
        }
    }

    void checkItem(TodoItem item) {
        todos.stream()
                .filter(item::equals)
                .findAny()
                .ifPresent(TodoItem::check);
    }

    void uncheckItem(TodoItem item) {
        todos.stream()
                .filter(item::equals)
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
}
