import java.util.*;
class NumberGuess{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String play="yes";
        while (play.equals("yes")) {
            Random rand=new Random();
            int randNum=rand.nextInt(100);
            int guess=-1,tries=0;

            while(guess!=randNum){
                System.out.println("Guess a number between 1 and 100:");
                guess=sc.nextInt();
                tries++;
                if(guess==randNum){
                    System.out.println("Awesome , You guess the number correctly:");
                    System.out.println("It only took you "+tries+"  guesses!");
                    System.out.println("Would you like to play again? (Yes or No): ");
                    play=sc.next().toLowerCase();
                }else if(guess<randNum){
                    System.out.println("Your guess is too low");
                }else{
                    System.out.println("Your guess is too high");
                }
            }
        }
        System.out.println("See You Again :)");
        sc.close();
    }
}