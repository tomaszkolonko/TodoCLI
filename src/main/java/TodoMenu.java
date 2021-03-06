import java.util.Scanner;

public class TodoMenu {

    final TodoOperations todoOperations = new TodoOperations();
    final String menuOptions = """
                    Press 'A' to add todo items
                    Press 'D' to delete an item
                    Press 'X' to check an item
                    Press 'U' to uncheck todo item
                    Press 'E' to edit an item
                    Press 'L' to list todo items
                    Press 'Lx' to list only checked items
                    Press 'Lu' to list only unchecked items
                    Press 'H' to list all the options
                    Press 'Cx' to clear the checked items
                    Press 'Q' to quit
                    """;

    public void start() {
        System.out.println("Welcome");
        System.out.println(menuOptions);

        selectOperation();
    }

    private void selectOperation() {
        String chosenOption = "";
        while (!chosenOption.equals("Q")) {
            final Scanner scanner = new Scanner(System.in);
            final String option = scanner.nextLine();

            chosenOption = doOperation(todoOperations, chosenOption, option);

            System.out.println("What's next?");
        }
    }

    private String doOperation(TodoOperations todoOperations, String chosenOption, String option) {
        switch (option.toUpperCase()) {
            case "A" -> todoOperations.addItem();
            case "D" -> todoOperations.deleteItem();
            case "X" -> todoOperations.checkItem();
            case "U" -> todoOperations.uncheckItem();
            case "E" -> todoOperations.editItem();
            case "L" -> todoOperations.print();
            case "LX" -> todoOperations.printCheckedItems();
            case "LU" -> todoOperations.printUncheckedItems();
            case "H" -> System.out.println(menuOptions);
            case "CX" -> todoOperations.clearCheckedItems();
            case "Q" -> {
                System.out.println("Goodbye");
                chosenOption = "Q";
            }
            default -> System.out.println("didn't get that... Press 'H' to list all the options");
        }
        return chosenOption;
    }
}
