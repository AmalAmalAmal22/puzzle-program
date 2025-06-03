/*
String and Number Puzzle Program, 
Wednesday 11th of November 2020
 */
package StringandNumberPuzzleProgram;

import java.util.Scanner;

public class BCRAssi3 
{
    public static void main(String[] args) 
    {
        while (true) 
        {
            displayMainMenu();
        }
    } // main method braces

    public static int displayMainMenu() 
    {
        System.out.print("Welcome to the string and number puzzles program\n--------------------------------------------------\n"
                + "    1. Display Middle Char puzzle\n"
                + "    2. Even Fibonacci Sum\n"
                + "    3. Mid Point\n"
                + "    4. Count Words puzzle\n"
                + "--------------------------------------------------\n");
        System.out.print("Enter your choice (1-4) or -1 to exit : ");
        Scanner input = new Scanner(System.in);
        int Choice = input.nextInt();
        System.out.println();

        switch (Choice) 
        {
            case -1:
                // Exit from the program
                System.out.println("\n------ BYE ------");
                System.exit(0);
            case 1:
                // Display "displayMiddle" method
                System.out.println("Middle Character Puzzle");
                System.out.print("Enter a string: ");
                String userString = input.nextLine();
                displayMiddle(userString);
                break;
                // return to main method
            case 2:
                // Display "evenFibonacciSum" method
                System.out.println("Even Fibonacci Sum Puzzle");
                System.out.print("Enter limit (n): ");
                int userFibonacciNum = input.nextInt();
                System.out.println("The sum of the even Fibonacci numbers <= " + userFibonacciNum + " is: " + evenFibonacciSum(userFibonacciNum) + "\n");
                break;
                // return to main method
            case 3:
                // Display "hasMidPoint" method
                System.out.println("Mid Point Puzzle");
                System.out.print("Enter 3 numbers: ");
                int num1 = input.nextInt();
                int num2 = input.nextInt();
                int num3 = input.nextInt();
                boolean Midpoint = hasMidPoint(num1, num2, num3);
                if (Midpoint == true)
                {
                    System.out.println("Has a middle point\n");    
                }
                else 
                {
                    System.out.println("Has no middle point\n");   
                }
                break;
                // return to main method
            case 4:
                // Display "countWords" method
                System.out.println("Count Word Puzzle");
                System.out.print("Enter a string: ");
                countWords();
                break;
                // return to main method
            default:
                break;
        } // switch end
        return 0;
    } // displayMainMenu method braces 

    // Second method (Display middle character)
    public static void displayMiddle(String s) 
    {
        Scanner input = new Scanner(System.in);
        s = input.nextLine();

        if (s.length() % 2 == 0) 
        { // if the string is even
            int MiddleChar = s.length() / 2 - 1; // subtract 1 for the other middle character
            int MiddleChar1 = s.length() / 2; // divide string length on 2 to find the middle character
            char Char = s.charAt(MiddleChar);
            char Char1 = s.charAt(MiddleChar1);
            System.out.println("The middle character is: " + Char + Char1 + "\n");
        } 
        else 
        { // if the string is odd
            int MiddleChar = s.length() / (2);
            char Char = s.charAt(MiddleChar);
            System.out.println("The middle character is: " + Char + "\n");
        }
    } // displayMiddle method braces

    public static int evenFibonacciSum(int n) 
    {
        int f = 0; // first number
        int s = 1; // second number
        int totalsum = 0; // the sum of all fibonacci numbers
        int sum = 0; // the sum of all even fibonacci numbers
        for (int i = 1; i <= n; i++)
        {
            if (f <= n) 
            {
                totalsum = f + s;
                f = s;
                s = totalsum;   
            }
            
            if (totalsum <= n && totalsum % 2 == 0)
            {
                sum = sum + totalsum;
            }
        }
        return sum;
    } // evenFibonacciSum method braces

    // Fourth method (has mid point)
    public static boolean hasMidPoint(int num1, int num2, int num3) 
    {
        int high = Math.max(num1, Math.max(num2, num3)); // the highest value
        int low = Math.min(num1, Math.min(num2, num3)); // the lowest value
        int midpoint = (num1 + num2 + num3) - high - low; // the midpoint
        // check if true or false
        return high - midpoint == midpoint - low; 
    } // hasMidPoint method braces

    // Fifth method (count words)
    public static void countWords() 
    {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        /* I will count the number of words by counting the number of whitespaces between the words, then adding 1 to 
        the final count to get the number of words. Note if there was more than 1 whitespace between the words, it might change the result*/

        int numOfwords = 0; // initialize the counter
        for (int i = 0; i < s.length(); i++) 
        { // initialize i, i will take the value of each character in the string
            char s2 = s.charAt(i);
            if (Character.isWhitespace(s2)) 
            { // Check each character if it's a whitespace by using (Character.isWhitespace)
                numOfwords++; // if it's a whitespace (true) increase numOfwords by 1
            }
        }
        int totalwords = numOfwords + 1; // Add additional 1 to numOfwords

        if (Character.isWhitespace(s.charAt(0)) && Character.isWhitespace(s.charAt(s.length() - 1))) 
        { // if the user entered a whitespace first and last, subtract the extra 2 whitespaces
            totalwords = totalwords - 2;
        } 
        else if (Character.isWhitespace(s.charAt(0)) || Character.isWhitespace(s.charAt(s.length() - 1))) 
        { // if the user entered a whitespace first or last, subtract the extra 1 whitespace
            totalwords = totalwords - 1;
        }
        System.out.println("The string has " + totalwords + " words\n");
    } // countWords method braces
}// Class Braces
