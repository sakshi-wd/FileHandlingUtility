import java.io.*;
import java.util.Scanner;

/**
 * This Java program provides a file handling utility that allows users to:
 * - Read files from folder in which we are running this java program
 * - Write content to files
 * - Modify existing file content
 */
public class UniversalFileHandler {
    // Scanner object for user input
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Method to write content to a file at a specified path
     * @param filePath - Full path of the file to write to
     * @param content - Content to be written to the file
     */
    public static void writeToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("\nSuccessfully wrote to file: " + filePath);
        } catch (IOException e) {
            System.out.println("\nError writing to file: " + e.getMessage());
        }
    }

    /**
     * Method to read content from file 
     * @param filePath - Full path of the file to read
     */
    public static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\nContents of " + filePath + ":");
            System.out.println("------------------------------------");
            
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not found at path: " + filePath);
        } catch (IOException e) {
            System.out.println("\nError reading file: " + e.getMessage());
        }
    }

    /**
     * Method to modify content in an existing file
     * @param filePath - Full path of the file to modify
     * @param oldContent - Text to be replaced
     * @param newContent - New text to replace with
     */
    public static void modifyFile(String filePath, String oldContent, String newContent) {
        try {
            // Read existing content
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
            }
            
            // Perform replacement
            String content = contentBuilder.toString();
            String modifiedContent = content.replace(oldContent, newContent);
            
            // Write back to file if changes were made
            if (!content.equals(modifiedContent)) {
                writeToFile(filePath, modifiedContent);
                System.out.println("\nFile modified successfully.");
            } else {
                System.out.println("\nNo changes made. Old content not found in file.");
            }
        } catch (IOException e) {
            System.out.println("\nError modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("\nUNIVERSAL FILE HANDLING UTILITY");
        
        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Read a file");
            System.out.println("2. Write to a file");
            System.out.println("3. Modify a file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: // Read file
                    System.out.print("\nEnter full path of file to read: ");
                    String readPath = scanner.nextLine();
                    readFromFile(readPath);
                    break;
                    
                case 2: // Write to file
                    System.out.print("\nEnter full path of file to write: ");
                    String writePath = scanner.nextLine();
                    System.out.println("Enter content (type 'END' on a new line to finish):");
                    StringBuilder contentBuilder = new StringBuilder();
                    String line;
                    while (!(line = scanner.nextLine()).equals("END")) {
                        contentBuilder.append(line).append("\n");
                    }
                    writeToFile(writePath, contentBuilder.toString());
                    break;
                    
                case 3: // Modify file
                    System.out.print("\nEnter full path of file to modify: ");
                    String modifyPath = scanner.nextLine();
                    System.out.print("Enter text to replace: ");
                    String oldText = scanner.nextLine();
                    System.out.print("Enter new text: ");
                    String newText = scanner.nextLine();
                    modifyFile(modifyPath, oldText, newText);
                    break;
                    
                case 4: // Exit
                    System.out.println("\nExiting program...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
