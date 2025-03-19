import java.util.Scanner;

class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Simple Text Editor");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1. Add a new line");
            System.out.println("2. Delete a line");
            System.out.println("3. Edit a line");
            System.out.println("4. View all lines");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Enter the line to add: ");
                    String line = scanner.nextLine();
                    System.out.println("Line added successfully");
                }
                case 2 -> {
                    System.out.print("Enter the line number to delete: ");
                    int lineNo = scanner.nextInt();
                    System.out.println("Line deleted successfully");
                }
                case 3 -> {
                    System.out.print("Enter the line number to edit: ");
                    int lineNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the new line: ");
                    String newLine = scanner.nextLine();
                    System.out.println("Line edited successfully");
                }
                case 4 -> {
                    System.out.println("All lines are:");
                    System.out.println("1. Line 1");
                    System.out.println("2. Line 2");
                    System.out.println("3. Line 3");
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }

    }
}