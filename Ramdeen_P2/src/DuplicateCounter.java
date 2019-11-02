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
            populateHashMap();
            closeInputFile();
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
    private void printHashMap(){
        //filePrinter
        Object[] key = wordCounter.keySet().toArray();
        Object[] val = wordCounter.values().toArray();

        for(int i = 0; i < key.length; i++)
            filePrinter.printf("%-10s %s\n", key[i].toString(), val[i].toString());
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
