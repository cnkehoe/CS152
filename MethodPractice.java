/**
 * CS152 Lab 4 -- Welcome to Methods.
 *
 * Implement all the methods described below.
 *
 * Student name: Carly Kehoe
 */
public class MethodPractice {
    
    /**
     * Returns largest of its arguments.
     * @param x First argument
     * @param y Second argument
     * @param z Third argument
     * @return Maximum of x, y and z
     */
    public static int maxThree( int x, int y, int z) {
        int largest;
        //check between first and second argument
        if (x > y) {
            largest = x;
        }
        else {
            largest = y;
        }
        //now check between largest and third argument
        if (z > largest) {
            largest = z;
        }
       return largest;
    }
    
    /**
     * Is the argument even?
     * (Recall that even numbers are divisible by 2)
     * @param x Value to check.
     * @return True if x is an even number, false otherwise.
     */
    public static boolean isEven( int x ) {
        boolean isEven;
        if (x % 2 != 0) {
            isEven = false;
        }
        else {
            isEven = true;
        }
        return isEven;
    }
    
    /**
     * Does the given string contain the letter G (either upper or
     * lower case)?
     * @param x String to check
     * @return True if x contains G, false otherwise.
     */
    public static boolean hasG( String x ) {
        boolean hasG = false;
        for (int i = 0; i < x.length(); i++) {
            if (Character.toString(x.charAt(i)).equalsIgnoreCase("g")) {
                hasG = true;
            }
        }
        return hasG;
    }
    
    /**
     * Where is the location of the letter G (upper or lower case) in
     * the given string?
     * @param x String to check
     * @return 0 based location of first occurrence of G in x,
     *         -1 if G is not present.
     */
    public static int indexOfG( String x ) {
        //disregarding capital letters
        x = x.toLowerCase();
        
        //checking to see whether the string has g in the first place
        //made my life 200000000% easier
        //shazam
        if (hasG(x)) {
            return x.indexOf("g");
        }
        else {
            return -1;
        }
    }
    
    /**
     * This method returns a response based on the string input:
     *     Apple => Orange
     *     Hello => Goodbye!
     *     Turing => Machine
     *     Yay! => \o/
     * Any other input should be responded to with:
     *     What should I say?
     * @param input The input string
     * @return Corresponding output string.
     */
    public static String respond( String input ) {
        String response;
        
        switch (input) {
            case "Apple":
                response = "Orange";
                break;
            case "Hello":
                response = "Goodbye!";
                break;
            case "Turing":
                response = "Machine";
                break;
            case "Yay!":
                response = "\\o/";
                break;
            default:
                response = "What should I say?";
        }
        return response;
    }
    
    /**
     * Average up to five even numbers. Any odd values are
     * not included in the average.
     * @param a First value
     * @param b Second value
     * @param c Third value
     * @param d Fourth value
     * @param e Fifth value
     * @return Average of the even input values. If none are even, returns -1000.
     */
    public static double averageEvens( int a, int b, int c, int d, int e ) {
      double average = 0.0;
      int[] input = {a, b, c, d, e};
      int oddCounter = 0;
      for (int i = 0; i < input.length; i++) {
          if (input[i] % 2 != 0) {
              input[i] = 0;
              oddCounter++;
          }
          average += input[i];
      }
      if (oddCounter == 5) {
          average = -1000;
      }
      else {
          average /= (input.length - oddCounter);
      }
        return average;
    }
    
    
    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called doubleOddSquareEven that returns twice
    // odd numbers and returns even values squared.
    //
    // The method should take a single int argument and return an int
    //
    // Don't forget to use the public static modifiers
    
    public static int doubleOddSquareEven (int x) {
        if (x % 2 != 0) {
            return x * 2;
        }
        else {
            return x * x;
        }
    }
    
    
    
    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called calculateTotalPayment that takes two
    // arguments, an int meal which is the cost of a meal, and a
    // double tip which represents the tip percentage one would add to
    // the bill.
    // The method must return a double which equals how much should be
    // paid.
    //
    // int meal must be greater than 0
    // double tip must be 0 or greater and .7 or less (no tips over 70%)
    // If either number is invalid, return -1;
    //
    // Don't forget to use the public static modifiers
    
    public static double calculateTotalPayment (int meal, double tip) {
        double total = meal + (meal * tip);
        if (meal <= 0 || (tip <= 0 || tip > 0.7)) {
            total = -1;
        }
        return total;
    }
    
    
    
    
    
    // This code tests your program's completeness.
    public static void main(String[] args) {
        int numCorrect = 0;
        
        if( maxThree(1, 2, 3) == 3 ) { numCorrect++; }
        if( maxThree(4,-5, 2) == 4 ) { numCorrect++; }
        if( maxThree(0, 7, 5) == 7 ) { numCorrect++; }
        
        if( !isEven(3) ) { numCorrect++; }
        if( isEven(-2) ) { numCorrect++; }
        if( isEven(0) ) { numCorrect++; }
        
        if( !hasG( "man" ) ) { numCorrect++; }
        if( hasG( "dog" ) ) { numCorrect++; }
        if( hasG( "EGGSHELL" ) ) { numCorrect++; }
        
        if( indexOfG( "man" ) == -1 ) { numCorrect++; }
        if( indexOfG( "EGGSHELL" ) == 1 ) { numCorrect++; }
        if( indexOfG( "dog" ) == 2 ) { numCorrect++; }
        if( indexOfG( "xyzggGGggG" ) == 3 ) { numCorrect++; }
        if( indexOfG( "xyzGGggGGg" ) == 3 ) { numCorrect++; }
        
        if( respond( "Apple" ).equals( "Orange" ) ) { numCorrect++; }
        if( respond( "Hello" ).equals( "Goodbye!" ) ) { numCorrect++; }
        if( respond( "Turing" ).equals( "Machine" ) ) { numCorrect++; }
        if( respond( "Yay!" ).equals( "\\o/" ) ) { numCorrect++; }
        if( respond( "xyz" ).equals( "What should I say?" ) ) { numCorrect++; }
        
        if( averageEvens(12, 13, 12, 13, 12) == 12.0) { numCorrect++; }
        if( averageEvens(-1, 3, -5, 7, 9) == -1000.0) { numCorrect++; }
        if( averageEvens(0, 0, 15, 0, -2) == -0.5) { numCorrect++; }
        if( averageEvens(100, -3, 4021, -2, 13) == 49.0) { numCorrect++; }
        
        // Uncomment these tests AFTER IMPLEMENTING doubleOddSquareEven
         if( doubleOddSquareEven( 4 ) == 16 ) { numCorrect++; }
         if( doubleOddSquareEven( 3 ) == 6 ) { numCorrect++; }
        
        // Uncomment these tests AFTER IMPLEMENTING calculateTotalPayment
         if( calculateTotalPayment( 0, .3 ) == -1 ) { numCorrect++; }
         if( calculateTotalPayment( 10, .2 ) == 12.0 ) { numCorrect++; }
         if( calculateTotalPayment( 100, .5 ) == 150 ) { numCorrect++; }
         if( calculateTotalPayment( 100, .71 ) == -1 ) { numCorrect++; }
         if( calculateTotalPayment( 120, .32 ) == 158.4 ) { numCorrect++; }
        
        System.out.println( "Your program's completeness is currently: "
                + numCorrect + "/30" );
    }
    
}

//for the longest time, this was failing one test and i looked at it and
//forgot to capitalize the m in machine moral of the story debugging will
//continue until morale improves







//*in Emeril Lagasse voice* BAM*s