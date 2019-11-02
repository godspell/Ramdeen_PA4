/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 4 - Problem 1
 */

public class Application {

    public static void main(String[] args) {
        DuplicateRemover remover = new DuplicateRemover();
        remover.remove("problem1.txt");
        remover.write("unique_words.txt");

        System.out.println("finished executing...");
    }
}
