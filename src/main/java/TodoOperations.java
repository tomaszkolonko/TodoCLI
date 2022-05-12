import java.util.Scanner;

public class TodoOperations {

    TodoHolder todoHolder = new TodoHolder();
    private Scanner scanner = new Scanner(System.in);


    public void addItem() {
        System.out.println("Enter an item");
        TodoItem item = new TodoItem(scanner.nextLine());
        todoHolder.add(item);
    }

    public void deleteItem() {
        System.out.println("Enter an item to be deleted");
        TodoItem item = new TodoItem(scanner.nextLine());
        todoHolder.delete(item);
    }

    public void checkItem() {
        System.out.println("Enter the item you want to check");
        TodoItem item = new TodoItem(scanner.nextLine());
        todoHolder.checkItem(item);
    }

    public void uncheckItem() {
        System.out.println("Enter the item you want to uncheck");
        TodoItem item = new TodoItem(scanner.nextLine());
        todoHolder.uncheckItem(item);
    }

    public void editItem() {
        System.out.println("Enter the id of the item you want to edit");
        int id = Integer.parseInt(scanner.nextLine());
        todoHolder.editItem(id);
    }

    public void print() {
        todoHolder.print();
    }

    public void printCheckedItems() {
        todoHolder.printOnlyCheckedItems();
    }

    public void printUncheckedItems() {
        todoHolder.printOnlyUncheckedItems();
    }
}
