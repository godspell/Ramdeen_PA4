/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 4 - Problem 1
 */

public class Application {

    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("test1.txt");
        duplicateRemover.write("test1_output.txt");

        System.out.println("finished executing...");
    }
}
