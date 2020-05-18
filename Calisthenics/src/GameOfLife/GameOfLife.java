package GameOfLife;

import java.io.File;

public class GameOfLife {
    public static void main(String[] args){
        GameField field = new GameField(new File("resources/config.txt"));
        field.initField();
        Game game = new Game(field);
        System.out.println("Start generation:");
        game.showCurrentGeneration();
        System.out.println("Next Generation:");
        game.showNextGeneration();
        System.out.println("Next Generation:");
        game.showNextGeneration();
    }
}
