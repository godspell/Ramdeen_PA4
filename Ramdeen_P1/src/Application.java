/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 4 - Problem 1
 */

public class Application {

    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");

        System.out.println("finished executing...");
    }
}
