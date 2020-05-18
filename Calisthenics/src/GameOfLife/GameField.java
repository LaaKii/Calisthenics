package GameOfLife;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameField {
    private String[][] field;
    private File pathToConfig;

    public GameField(File file) {
        pathToConfig = file;
    }

    public void initField(){
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(pathToConfig.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        field = new String[allLines.size()][allLines.size()];
        for(int i = 0; i<allLines.size();i++){
            fillRowOfGameField(i, allLines.get(i).split(" "));
        }
        System.out.println("Field initialized");
    }

    private void fillRowOfGameField(int rowToFill, String[] content){
        for(int i = 0; i<field.length;i++){
            field[rowToFill][i]=content[i];
        }
    }

    public void showCurrentGameField(){
        System.out.println(Arrays.deepToString(field).replace("], ", "]\n").replace("[[","[").replace("]]","]"));
    }

    public void showNextGeneration(){
        Generation generation = new Generation();
        field = generation.nextGeneration(field);
        showCurrentGameField();
    }
}