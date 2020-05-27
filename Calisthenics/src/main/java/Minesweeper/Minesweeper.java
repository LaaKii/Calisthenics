package Minesweeper;

import java.io.File;

public class Minesweeper {
    public static void main(String[] args){
        GameField gameField = new GameField();
        gameField.loadField(new File("resources/MinesweeperConfig.txt"));
        gameField.printGamefield();
    }
}
