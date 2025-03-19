import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {

    private static final List<String> textLines = new ArrayList<>();
    private static final String FILE_NAME = "text_data.txt";

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Text Editor");

        loadFromFile();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add a new line");
                System.out.println("2. Delete a line");
                System.out.println("3. Edit a line");
                System.out.println("4. View all lines");
                System.out.println("5. Save to File");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> addLine(scanner);
                    case 2 -> deleteLine(scanner);
                    case 3 -> editLine(scanner);
                    case 4 -> viewLines();
                    case 5 -> saveToFile();
                    case 6 -> {
                        System.out.println("Saving data to file before exit...");
                        saveToFile();
                        System.out.println("See you later gufer!...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");
                }

            }

        }

    }

    private static void addLine(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter the line to add: ");
        String line = scanner.nextLine();
        textLines.add(line);
        System.out.println("Line added successfully");
    }

    private static void deleteLine(Scanner scanner) {
        viewLines();
        scanner.nextLine();
        System.out.print("Enter the line number to delete: ");
        int lineNo = scanner.nextInt();
        scanner.nextLine();

        if (lineNo > 0 && lineNo <= textLines.size()) {
            textLines.remove(lineNo - 1);
            System.out.println("Line deleted successfully");
        } else {
            System.out.println("Invalid line number");
        }

    }

    private static void editLine(Scanner scanner) {
        viewLines();
        scanner.nextLine();
        System.out.print("Enter the line number to edit: ");
        int lineNo = scanner.nextInt();
        scanner.nextLine();

        if (lineNo > 0 && lineNo <= textLines.size()) {
            System.out.print("Enter the new line: ");
            String newLine = scanner.nextLine();
            textLines.set(lineNo - 1, newLine);
            System.out.println("Line edited successfully");
        } else {
            System.out.println("Invalid line number");
        }
    }

    private static void viewLines() {
        if (textLines.isEmpty()) {
            System.out.println("No lines to display");
        } else {
            System.out.println();
            System.out.println("Total lines: " + textLines.size());
            System.out.println("All lines are:");
            for (int i = 0; i < textLines.size(); i++) {
                System.out.println((i + 1) + ". " + textLines.get(i));
            }
            System.out.println();
        }
    }

    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String line : textLines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data saved to file successfully");
        } catch (Exception e) {
            System.out.println("An error occurred while saving data to file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textLines.add(line);
                }
                System.out.println("Data loaded from file successfully");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data from file: " + e.getMessage());
            }
        }
    }
}