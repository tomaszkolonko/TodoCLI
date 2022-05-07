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
        for(TodoItem todoItem : todos) {
            if(todoItem.equals(new TodoItem(todo))) {
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
                todos.remove(i);
                todos.add(i, new TodoItem(text, isChecked.equals("yes")));
            }
        }
    }

    void checkItem(TodoItem item) {
        TodoItem itemToBeChecked = todos.stream()
                .filter(item::equals)
                .findAny()
                .orElse(null);

        if(itemToBeChecked != null) {
            itemToBeChecked.check();
        }
//        for(TodoItem todoItem : todos) {
//            if(todoItem.equals(item)) {
//                todoItem.check();
//            }
//        }
    }

    void uncheckItem(TodoItem item) {
        for(TodoItem todoItem : todos) {
            if(todoItem.equals(item)) {
                todoItem.uncheck();
            }
        }
    }

    void print() {
        for(TodoItem todo : todos) {
            System.out.println(todo);
        }
    }

    public int getTodoSize() {
        return todos.size();
    }
}
