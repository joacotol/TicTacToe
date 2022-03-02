package main;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        printGrid();
    }

    public void printGrid() {
        char xChar = 'X';
        char oChar = 'O';
        System.out.printf("%c %c %c\n", xChar, oChar,xChar);
        System.out.printf("%c %c %c\n", oChar, xChar, oChar);
        System.out.printf("%c %c %c\n", xChar, xChar, oChar);

    }

}
