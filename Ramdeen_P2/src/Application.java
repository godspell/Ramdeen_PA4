/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 4 - Problem 2
 */

public class Application {

    public static void main(String[] args) {
        DuplicateCounter counter = new DuplicateCounter();

        counter.count("problem2.txt");
        counter.write("unique_word_counts.txt");

        System.out.println("finished executing...");
    }
}
