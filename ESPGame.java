/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description: (Give a brief description for each Class)
 * Due: 02/17/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: _____VIvan Perera_____
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
    public static void main(String[] args) throws IOException {
        final int MAX_ATTEMPTS = 3;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String userName, userDescription, dueDate;
        
        
        //this is true until 4 is chosen or no
        boolean continueGame = true;
        
        //while loop that loops the game till 4 is chosen 
        while (continueGame) {
            System.out.println("\nChoose an option:");
            System.out.println("1- Read and display first 16 colors");
            System.out.println("2- Read and display first 10 colors");
            System.out.println("3- Read and display first 5 colors");
            System.out.println("4- Exit the program");
            System.out.print("Enter your option: ");
            
            
            //scanner
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            
            //checks what was chosen 
            int limit = 0;
            switch (choice) {
                case 1:
                    limit = 16;
                    break;
                case 2:
                    limit = 10;
                    break;
                case 3:
                    limit = 5;
                    break;
                case 4:
                    continueGame = false;
                    continue;
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }
            
            // Ask for the file name
            System.out.print("Enter the filename: ");
            String fileName = scanner.nextLine().trim();
            File file = new File(fileName);
            
            //check if file does not exist print not found 
            if (!file.exists()) {
                System.out.println("File not found. Please check the file name and try again.");
                continue;
            }
            
            Scanner fileScanner = new Scanner(file);
            
            int count = 0;
            System.out.println("\nAvailable colors:");
            while (fileScanner.hasNextLine() && count < limit) {
                count++;
                String color = fileScanner.nextLine().trim();
                System.out.println(count + ". " + color);
            }
            fileScanner.close();
            
            int correctGuesses = 0;
            for (int round = 1; round <= MAX_ATTEMPTS; round++) {
                // Randomly chooses color 
                int randomIndex = random.nextInt(limit);
                fileScanner = new Scanner(file);
                String chosenColor = "";
                
                for (int i = 0; i <= randomIndex; i++) {
                    chosenColor = fileScanner.nextLine().trim();
                }
                
                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.");
                System.out.print("Enter your guess: ");
                String guess = scanner.nextLine();
                
                if (guess.equalsIgnoreCase(chosenColor)) {
                    correctGuesses++;
                }
                System.out.println("I was thinking of: " + chosenColor);
                
                fileScanner.close();
            }
            
            System.out.println("\nGame Over");
            System.out.println("You guessed " + correctGuesses + " out of " + MAX_ATTEMPTS + " correctly.");
            
            // Write results to output file
            FileWriter writer = new FileWriter("EspGameResults.txt", true);
            System.out.print("Enter your name: ");
            userName = scanner.nextLine();
            System.out.print("Describe yourself: ");
            userDescription = scanner.nextLine();
            System.out.print("Enter Due Date (MM/DD/YY): ");
            dueDate = scanner.nextLine();
            
            writer.write("Game Over\n");
            writer.write("You guessed " + correctGuesses + " out of " + MAX_ATTEMPTS + " correctly.\n");
            writer.write("Due Date: " + dueDate + "\n");
            writer.write("Username: " + userName + "\n");
            writer.write("User Description: " + userDescription + "\n");
            writer.write("Date: " + dueDate + "\n\n");
            writer.close();
            
            System.out.print("Would you like to continue the game? (Yes/No): ");
            String response = scanner.nextLine();
            
            //makes the boolean false and ends loop
            continueGame = response.equals("yes");
        }
        
        FileWriter writer = new FileWriter("EspGameResults.txt", true);
        System.out.print("Enter your name: ");
        userName = scanner.nextLine();
        System.out.print("Describe yourself: ");
        userDescription = scanner.nextLine();
        System.out.print("Enter Due Date (MM/DD/YY): ");
        dueDate = scanner.nextLine();
        
        writer.write("Due Date: " + dueDate + "\n");
        writer.write("Username: " + userName + "\n");
        writer.write("User Description: " + userDescription + "\n");
        writer.write("Date: " + dueDate + "\n\n");
        writer.close();
        
        scanner.close();
        System.out.println("Thank you for playing ESP Game!");
    }
}
