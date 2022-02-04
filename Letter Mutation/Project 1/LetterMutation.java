/* Imports */
import java.util.*;
import java.io.*;

/**
 * [Letter Mutation.java]
 * This class contains the main method and holds the logic for the program
 * 
 * @author Peter Gu
 * @version 1.0 Dec 17, 2021
 */

public class LetterMutation{

    // Class Variables
    private static WordList currentWordList;

    /*** MAIN METHOD ***/
    public static void main(String[] args) throws FileNotFoundException{

        // Handling IO
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Please input the name of the dictionary: ");
        String fileName = consoleInput.nextLine();

        // Create a new wordList with dictionary
        currentWordList = new WordList(fileName);

        boolean inLoop = true;

        while(inLoop){
            String wordA, wordB, mutationString = "";
            Stack<String> wordStack;

            System.out.println("PLEASE INPUT THE TWO WORDS YOU WOULD LIKE TO CREATE A PATH BETWEEN (INPUT 0 0 TO EXIT)");

            wordA = consoleInput.next().toUpperCase(); wordB = consoleInput.next().toUpperCase();

            if (wordA.equals("0") && wordB.equals("0")) {
                inLoop = false;
            }else {
                // double start = System.nanoTime()/1000000.0;

                // Method within wordList
                wordStack = currentWordList.connectWords(wordA, wordB);

                // double end = System.nanoTime()/1000000.0;

                // System.out.println(end - start);

                if (wordStack == null) {
                    System.out.println("NO SUCH MUTATION EXISTS");
                }else{
                    System.out.println("THERE EXISTS A MUTATION OF LENGTH " + wordStack.size());

                    // Iterate the stack and append to string
                    while (!wordStack.isEmpty()){
                        mutationString += wordStack.peek();
                        if (wordStack.size() > 1) {
                            mutationString += Constants.ARROW;
                        }
                        wordStack.pop();
                    }
        
                    System.out.println(mutationString);
                }
            }
        }

        consoleInput.close(); // Close console input
    }
}