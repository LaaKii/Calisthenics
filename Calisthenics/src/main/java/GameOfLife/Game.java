package GameOfLife;

public class Game {
    private GameField gameField;
    private Generation generation;
    public Game(GameField field) {
        this.gameField=field;
    }

    public void showCurrentGeneration() {
        gameField.showCurrentGameField();
    }

    public void showNextGeneration() {
        gameField.showNextGeneration();
    }
}
