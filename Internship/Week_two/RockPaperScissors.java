import java.util.*;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = {"Rock", "Paper", "Scissors"};
        String computerMove;
        String playerMove;
        while (true) {
            System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type Exit: ");
            playerMove = scanner.nextLine();
            if (playerMove.equalsIgnoreCase("Exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            if (!playerMove.equalsIgnoreCase("Rock") && 
                !playerMove.equalsIgnoreCase("Paper") && 
                !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }
            int randomIndex = random.nextInt(3); 
            computerMove = rps[randomIndex];
            System.out.println("Computer chose: " + computerMove);
            if (playerMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if (playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors") || 
                       playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock") || 
                       playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }
        
        scanner.close();
    }
}
