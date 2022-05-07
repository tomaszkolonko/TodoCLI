import java.util.Scanner;

public class TodoMenu {

    public void start() {

        TodoHolder todoHolder = new TodoHolder();

        System.out.println("Welcome");

        String chosenOption = "";
        while (!chosenOption.equals("Q")) {
            String menuOptions = """
                    Press 'A' to add todo items
                    Press 'D' to delete an item
                    Press 'X' to check an item
                    Press 'U' to uncheck todo item
                    Press 'L' to list todo items
                    Press 'Q' to quit
                    """;
            System.out.println(menuOptions);

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A" -> {
                    System.out.println("Enter an item");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.add(item);
                }
                case "D" -> {
                    System.out.println("Enter an item to be deleted");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.delete(item);
                }
                case "X" -> {
                    System.out.println("Enter the item you want to check");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.checkItem(item);
                }
                case "U" -> {
                    System.out.println("Enter the item you want to UNcheck");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.uncheckItem(item);
                }
                case "L" -> todoHolder.print();
                case "Q" -> {
                    System.out.println("Goodbye");
                    chosenOption = "Q";
                }
            }

        }
    }
}
