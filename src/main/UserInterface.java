package main;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private CharacterList list;

    public UserInterface(Scanner scanner, CharacterList list) {
        this.scanner = scanner;
        this.list = list;
    }

    public void start() {
        System.out.print("\nEnter cells: ");
        String symbols = this.scanner.nextLine();
        this.list.addCharacters(symbols);
        this.list.printBoard();
        this.list.checkTheWinner();

    }

    // Objective 1
    public void printGrid() {
        char xChar = 'X';
        char oChar = 'O';
        System.out.printf("%c %c %c\n", xChar, oChar,xChar);
        System.out.printf("%c %c %c\n", oChar, xChar, oChar);
        System.out.printf("%c %c %c\n", xChar, xChar, oChar);

    }

}
