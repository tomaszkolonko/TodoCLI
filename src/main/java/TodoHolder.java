import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoHolder {

    private final List<TodoItem> todos = new ArrayList<>();

    void add(TodoItem item) {
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

    void editItem(TodoItem item) {
        for(int i = 0; i < todos.size(); i++) {
            TodoItem todoItem = todos.get(i);
            if(todoItem.equals(item)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Item was retrieved. What's the text?");
                String text = scanner.nextLine();
                System.out.println("is it a checked item? [yes|no]");
                String isChecked = scanner.nextLine().toLowerCase();
                todos.set(i, new TodoItem(text, isChecked.equals("yes")));
            }
        }
    }

    void checkItem(TodoItem item) {
        todos.stream()
                .filter(item::equals)
                .findAny()
                .ifPresent(itemToCheck -> itemToCheck.check());
    }

    void uncheckItem(TodoItem item) {
        for(TodoItem todoItem : todos) {
            if(todoItem.equals(item)) {
                todoItem.uncheck();
            }
        }
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
