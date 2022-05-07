import java.util.Scanner;

public class TodoMenu {

    public void start() {
        String menuOptions = """
                    Press 'A' to add todo items
                    Press 'D' to delete an item
                    Press 'X' to check an item
                    Press 'U' to uncheck todo item
                    Press 'E' to edit an item
                    Press 'L' to list todo items
                    Press 'H' to list all the options
                    Press 'Q' to quit
                    """;

        TodoHolder todoHolder = new TodoHolder();

        System.out.println("Welcome");
        System.out.println(menuOptions);

        String chosenOption = "";
        while (!chosenOption.equals("Q")) {
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
                    System.out.println("Enter the item you want to uncheck");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.uncheckItem(item);
                }
                case "E" -> {
                    System.out.println("Enter the item you want to edit");
                    TodoItem item = new TodoItem(scanner.nextLine());
                    todoHolder.editItem(item);
                }
                case "L" -> todoHolder.print();
                case "H" -> System.out.println(menuOptions);
                case "Q" -> {
                    System.out.println("Goodbye");
                    chosenOption = "Q";
                }
                default -> System.out.println("didn't get that... Press 'H' to list all the options");
            }
            System.out.println("What's next?");

        }
    }
}
