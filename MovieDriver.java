package Lab1;
import java.util.Scanner;

public class MovieDriver {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);
     String continueResponse;

       do {
           // new object
           Movie movie = new Movie();

           // Gets name of movie
           System.out.print("Enter the Name of the movie: ");
           String title = scanner.nextLine();
           movie.setTitle(title);

           // gets the movie rating
           System.out.print("Enter the movie's rating: ");
           String rating = scanner.nextLine();
           movie.setRating(rating);

           // ask for number of tickets sold
           System.out.print("Enter the number of tickets sold: ");
           int ticketsSold = scanner.nextInt();
           movie.setSoldTickets(ticketsSold);
           scanner.nextLine();

           // Print out the information using the movie's toString method
           System.out.println("\nMovie Information:");
           System.out.println(movie.toString());

           // Ask the user if they want to continue
           System.out.print("\nDo you want to enter another movie? (yes/no): ");
           continueResponse = scanner.nextLine();

       } while (continueResponse.equalsIgnoreCase("yes"));

       // Close the scanner
       scanner.close();
   }


}
