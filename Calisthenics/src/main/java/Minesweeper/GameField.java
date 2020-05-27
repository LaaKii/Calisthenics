package Minesweeper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameField {
    private Character[][] mineFields;

    public void loadField(File config) {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(config.toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mineFields = new Character[allLines.get(0).length()][allLines.size()];
        for(int i = 0; i<allLines.size();i++){
            fillRowOfGameField(i, allLines.get(i));
        }
        System.out.println("Field initialized");
    }

    private void fillRowOfGameField(int rowToFill, String rowContent) {
        char[] rowChars = rowContent.toCharArray();
        for(int i =0; i<rowChars.length;i++){
            mineFields[rowToFill][i] = rowChars[i];
        }
    }

    public void printGamefield(){
        System.out.println(Arrays.deepToString(mineFields).replace("], ", "]\n").replace("[[","[").replace("]]","]"));
    }
}
