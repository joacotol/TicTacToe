package main;

import java.util.ArrayList;
public class CharacterList {
    private ArrayList<Character> charList;
    private boolean xWins;
    private boolean oWins;
    final private int TOTALX = 264;
    final private int TOTALO = 237;

    public CharacterList() {
        this.charList = new ArrayList<>();
        this.xWins = false;
        this.oWins = false;
    }

    // Objective 2
    public void addCharacters(String symbols) {
        for (int i = 0; i < symbols.length(); i++) {
            char symbol = symbols.charAt(i);
            charList.add(symbol);
        }
    }

    public void printBoard() {
        System.out.println("---------");
        System.out.print("| ");
        for (int j = 0; j <= charList.size(); j++) {
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

    // Objective 3
    // All methods below are for Objective 3

    public void checkHorizontal() {
        for (int i = 0; i < charList.size(); i += 3) {
            if (charList.get(i) + charList.get(i + 1) + charList.get(i + 2) == TOTALX) {
                xWins = true;
            } else if (charList.get(i) + charList.get(i + 1) + charList.get(i + 2) == TOTALO) {
                oWins = true;
            }
        }
    }

    public void checkVertical() {
        for (int i = 0; i < 3; i++) {
            if (charList.get(i) + charList.get(i + 3) + charList.get(i + 6) == TOTALX) {
                xWins = true;
            } else if (charList.get(i) + charList.get(i + 3) + charList.get(i + 6) == TOTALO) {
                oWins = true;
            }
        }
    }

    public void checkDiagonal() {
        for (int i = 0; i < 3; i += 2) {
            // Left Diagonal
            if (charList.get(i) + charList.get(i + 4) + charList.get(charList.size() - 1) == TOTALX) {
                xWins = true;
            } else if (charList.get(i) + charList.get(i + 4) + charList.get(charList.size() - 1) == TOTALO) {
                oWins = true;
            }

            // Right Diagonal
            if (charList.get(i) + charList.get(i + 2) + charList.get(i + 4) == TOTALX) {
                xWins = true;
            } else if (charList.get(i) + charList.get(i + 2) + charList.get(i + 4) == TOTALO) {
                oWins = true;
            }
        }
    }

    public void checkTheWinner() {
        checkHorizontal();
        checkVertical();
        checkDiagonal();
        if (xWins && !oWins) {
            System.out.println("X Wins");
            return;
        } else if (!xWins && oWins) {
            System.out.println("O Wins");
            return;
        }

        if (!xWins && !oWins && !hasEmptyCells()) {
            System.out.println("Draw");
        } else if ((xWins && oWins) || isImpossible()){
            System.out.println("Impossible");
        } else {
            System.out.println("Game not finished");
        }

    }

    public boolean isImpossible() {
        int xCount = 0;
        int oCount = 0;

        for (Character single : charList) {
            if (single.equals('X')) {
                xCount++;
            } else if (single.equals('O')) {
                oCount++;
            }
        }

        return xCount - oCount > 1 || oCount - xCount > 1;
    }

    // Game not Finished
    // when neither side has three a row but the grid still has empty cells
    public boolean hasEmptyCells() {
        for (Character single : charList) {
            if (single.equals('_')) {
                return true;
            }
        }
        return false;
    }
}
