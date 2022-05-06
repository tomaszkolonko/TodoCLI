import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        boolean active = true;

        System.out.println("Welcome");

        while (active) {
            System.out.println("Press 'A' to add todo items");
            System.out.println("Press 'L' to list todo items");
            System.out.println("Press 'Q' to quit");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A":
                    System.out.println("Enter an item");
                    String item = scanner.nextLine();
                    items.add(item);
                    break;
                case "L":
                    for (String currentItem : items) {
                        System.out.println(currentItem);
                    }
                    break;
                case "Q":
                    System.out.println("Goodbye");
                    active = false;
                    break;
            }

        }


    }
}
