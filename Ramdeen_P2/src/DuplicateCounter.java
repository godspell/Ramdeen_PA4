/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 4 - Problem 2
 */

import java.util.*;
import java.io.*;

public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter;
    private FileInputStream fileInputByteStream;
    private Scanner fileScanner;
    private FileOutputStream fileOutputByteStream;
    private PrintWriter filePrinter;

    public DuplicateCounter(){
        wordCounter = new HashMap<String, Integer>();
    }

    // counts the amount of times a word occurs in a file.
    public void count(String dataFile){
        try{
            loadInputFile(dataFile); // Throws I/O Exception if fails to load
            populateHashMap(); // counts the words in file and stores it in a HashMap
            closeInputFile(); // Throws I/O Exception if fails to close the file
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    // writes the contents of wordCounter HashMap into a file
    public void write(String dataFile){
        try{
            loadOutputFile(dataFile); // throws I/O Exception if fails to load the file
            printHashMap();
            closeOutputFile(); // throws I/O Exception if fails to close
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }


    /* Helper Methods */
    // load words from file into a HashMap
    private void populateHashMap(){
        String currentWord;
        int currentCount;
        while(fileScanner.hasNext()){
            currentWord = fileScanner.next();
            if(!wordCounter.containsKey(currentWord)) // Word does not exist in the HashMap
                wordCounter.put(currentWord, 1);
            else { // Word Already Exists in the HashMap. Just increment the current value.
                currentCount = wordCounter.get(currentWord);
                currentCount++;
                wordCounter.put(currentWord, currentCount);
            }
        }
    }

    // prints the contents of wordCounter HashMap to a file
    // removes punctuation characters from the output file.
    private void printHashMap(){
        Object[] key = wordCounter.keySet().toArray();
        Object[] val = wordCounter.values().toArray();
        String currentWord;

        for(int i = 0; i < key.length; i++) {
            currentWord = key[i].toString().replaceAll("[^a-zA-Z ]", "");
            if (!currentWord.equals("")) // if the word is just all punctuation characters, don't print it to the file.
                filePrinter.printf("%-10s %s\n", currentWord, val[i].toString()); // no point converting to an int b/c its being printed
        }
        filePrinter.flush();
    }

    // load file - input
    private void loadInputFile(String dataFile) throws Exception{
        fileInputByteStream = new FileInputStream(dataFile);
        fileScanner = new Scanner(fileInputByteStream);
    }

    // close file - input
    private void closeInputFile() throws Exception{
        fileInputByteStream.close();
        fileScanner.close();
    }

    // load file - output
    private void loadOutputFile(String dataFile) throws Exception{
        fileOutputByteStream = new FileOutputStream(dataFile);
        filePrinter = new PrintWriter(fileOutputByteStream);
    }

    // close file - output
    private void closeOutputFile() throws Exception{
        fileOutputByteStream.close();
        filePrinter.close();
    }
}
