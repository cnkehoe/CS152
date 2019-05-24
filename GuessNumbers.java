/**
 * @version date (in_ISO_8601 format: 2019-01-24
 * @author Carly Kehoe
 *
 * This is a simple class that runs a shortv"guess my number" game
 * in the console, selecting a random number between 1 and 10, then
 * prompting the user for their name and guessing a number
 */


//importing scanner object
import java.util.Scanner;

public class GuessNumbers {
   
    
    /**
     * Holds game stuff
     */
    public static void gamePlay () {
        //create new scanner object
        Scanner scanIn = new Scanner(System.in);
        //empty string to hold player's name
        String playerName;
        //generating random number
        int randNum = (int)(Math.random() * 10) + 1;
        //ask player if they want to play
        System.out.println("Hello! I am thinking of a number between 1 and " +
        " 10. Do you want to try and guess my number? (Y/N)");
        //string to hold player's answer
        String yesNo = scanIn.nextLine();
        //if the player wants to play the game
        if (yesNo.equals("y") || yesNo.equals("Y")) {
            System.out.println("Great! What's your name?");
            playerName = scanIn.nextLine();
            System.out.println("Okay, " + playerName + ". Please choose a" +
                    " number between 1 and 10");
            int playerGuess = scanIn.nextInt();
            if (playerGuess == randNum) {
                System.out.println("Hooray! You guessed my number!");
            }
            if (playerGuess != randNum) {
                System.out.println("You didn't guess my number. :( " +
                        "The number I was thinking of was " + randNum +
                        ".");
                System.out.println("You are a ninny.");
            }
            //System.out.println(randNum);
            //prints the number to test code
        }
        //if player says no
        if (yesNo.equals("n") || yesNo.equals("N")) {
            System.out.println("Well fine, be that way.");
        }
        
    }
    public static void main(String[] args){
        
        gamePlay();
    }
}
