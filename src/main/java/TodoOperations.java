import java.util.Scanner;

public class TodoOperations {

    final TodoHolder todoHolder = new TodoHolder();
    private final Scanner scanner = new Scanner(System.in);

    void addItem() {
        System.out.println("Enter an item");
        final int nextID = todoHolder.getNextID();
        TodoItem item = new TodoItem(scanner.nextLine(), nextID);
        todoHolder.add(item);
    }

    void deleteItem() {
        System.out.println("Enter the id of the item to be deleted");
        final int id = getIdOfItem();
        todoHolder.delete(id);
    }

    void checkItem() {
        System.out.println("Enter the id of the item you want to check");
        int id = getIdOfItem();
        todoHolder.checkItem(id);
    }

    void uncheckItem() {
        System.out.println("Enter the id of the item you want to uncheck");
        int id = getIdOfItem();
        todoHolder.uncheckItem(id);
    }

    void editItem() {
        System.out.println("Enter the id of the item you want to edit");
        int id = getIdOfItem();
        int index = todoHolder.getIndexOf(id);
        if (index == -1) {
            System.out.println("item not found");
            return;
        }
        TodoItem newItem = createNewItem(id);
        todoHolder.replaceItem(index, newItem);
    }

    void print() {
        todoHolder.print();
    }

    void printCheckedItems() {
        todoHolder.printOnlyCheckedItems();
    }

    void printUncheckedItems() {
        todoHolder.printOnlyUncheckedItems();
    }

    void clearCheckedItems() {
        todoHolder.clearCheckedTodos();
    }

    // todo: can refactor so that this validates that the ID is associated with a todo, as well
    private int getIdOfItem() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("That was not the items id, try again");
            return getIdOfItem();
        }
    }

    private TodoItem createNewItem(int id) {
        System.out.println("Item was retrieved. What's the text?");
        String text = scanner.nextLine();
        System.out.println("is it a checked item? [yes|no]");
        String isChecked = scanner.nextLine().toLowerCase();
        return new TodoItem(text, isChecked.equals("yes"), id);
    }
}
