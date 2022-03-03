package main;
import java.util.ArrayList;
import java.util.Scanner;

public class CharacterList {
    ArrayList<Character> charList;

    public CharacterList() {
        this.charList = new ArrayList<>();
    }

    public void addCharacters(String symbols) {
        for (int i = 0;i < symbols.length();i++) {
            char symbol = symbols.charAt(i);
            charList.add(symbol);
        }
    }

    public void printBoard() {
        System.out.println("---------");
        System.out.print("| ");
        for (int j = 0; j <= charList.size();j++) {
            if (j == 3 || j == 6) {
                System.out.print("|\n| ");
            }
            if (j == 9) {
                System.out.println("|");
                break;
            } else {
                System.out.print(charList.get(j) + " ");
            }
        }
        System.out.println("---------");
    }


}
