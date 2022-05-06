import java.util.Scanner;

public class TodoMenu {

    public void start() {

        TodoHolder todoHolder = new TodoHolder();

        boolean active = true;

        System.out.println("Welcome");

        while (active) {
            String menuOptions = """
                    Press 'A' to add todo items
                    Press 'L' to list todo items
                    Press 'Q' to quit
                    """;
            System.out.println(menuOptions);

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A" -> {
                    System.out.println("Enter an item");
                    String item = scanner.nextLine();
                    todoHolder.add(item);
                }
                case "L" -> todoHolder.print();
                case "Q" -> {
                    System.out.println("Goodbye");
                    active = false;
                }
            }

        }
    }
}
