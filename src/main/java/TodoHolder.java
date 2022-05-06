import java.util.ArrayList;
import java.util.List;

public class TodoHolder {

    private final List<String> todos = new ArrayList<>();

    void add(String item) {
        todos.add(item);
    }

    void delete(String item) {
        todos.remove(item);
    }

    void clearTodos() {
        todos.clear();
    }

    // edit

    // mark items

    void print() {
        for(String todo : todos) {
            System.out.println(todo);
        }
    }

    public int getTodoSize() {
        return todos.size();
    }
}
