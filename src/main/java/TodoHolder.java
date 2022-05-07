import java.util.ArrayList;
import java.util.List;

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

    // edit

    void checkItem(TodoItem item) {
        for(TodoItem todoItem : todos) {
            if(todoItem.equals(item)) {
                todoItem.check();
            }
        }
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
