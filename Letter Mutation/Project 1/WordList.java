/* Imports */
import java.io.*;
import java.util.*;

/**
 * [WordList.java]
 * This class represents an object that holds a list of words
 * 
 * @author Peter Gu
 * @version 1.0 Dec 17, 2021
 */

 public class WordList{

    // Hashmap to store words
    private HashMap<String, String> dictionary = new HashMap<>();

    /**
     * Constructs a new wordList that stores a collection of words
     * @param fileName the name of the file that contains the dictionary
     */
    public WordList(String fileName) throws FileNotFoundException{

        // Create new input stream w/ filename
        File myFile = new File(fileName);

        Scanner fileInput = new Scanner(myFile);
        
        // Loop through the file until last line
        while (fileInput.hasNextLine()){
            String s = fileInput.nextLine().toUpperCase();

            this.dictionary.put(s, null); // Add word to dictionary
        }

        fileInput.close(); // Close input stream
    }

    /**
     * resetVisited
     * reset the word list so that each word has no previous word
     */
    public void resetVisited(){
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            entry.setValue(null);
        }
    }

    /**
     * connectWords
     * returns the mutation of the two specified words
     * @param wordA the first word
     * @param wordB the second word
     * @return a stack that represents the mutation
     */
    public Stack<String> connectWords(String wordA, String wordB){

        // Invalid parameters
        if (!dictionary.containsKey(wordA) || !dictionary.containsKey(wordB) || wordA.length() != wordB.length()) return null;

        // Reset the visited value for hashmap
        resetVisited();

        Queue<String> queue = new LinkedList<>();
        Stack<String> returnStack = new Stack<>();
        String curWord, nextWord, curKey;

        // Push wordA and mark visited
        queue.add(wordA);
        dictionary.put(wordA, Constants.HEAD_NODE);

        // End BFS only if queue is empty or wordB has been visited
        while (!queue.isEmpty() && dictionary.get(wordB) == null){
            curWord = queue.poll();
            
            for (int i = 0; i < curWord.length(); i++){
                // Loop through the alphabet and change the current letter accordingly
                for (int j = 0; j < Constants.ALPHABET_LENGTH; j++){
                    nextWord = curWord.substring(0, i) + Constants.ALPHABET.charAt(j) + curWord.substring(i+1, curWord.length());

                    // If word has not yet been visited, visit it
                    if (dictionary.containsKey(nextWord) && dictionary.get(nextWord) == null){
                        dictionary.put(nextWord, curWord);
                        queue.add(nextWord);
                    }
                }
            }
        }

        if (dictionary.get(wordB) == null) return null;
        
        curKey = wordB;
        
        // Retrace the path from wordA to wordB
        while (dictionary.containsKey(curKey)){
            returnStack.push(curKey);
            curKey = dictionary.get(curKey);
        }

        return returnStack;
    }
 }