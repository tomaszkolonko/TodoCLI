import java.util.ArrayList;
import java.util.List;

public class TodoHolder {

    private final List<String> todos = new ArrayList<>();

    void add(String item) {
        todos.add(item);
    }

    // delete

    // clearTodos

    // edit

    // mark items

    // print

    List<String> getTodos() {
        return todos;
    }


}
