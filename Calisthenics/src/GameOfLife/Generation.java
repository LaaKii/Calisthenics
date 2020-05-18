package GameOfLife;

public class Generation {
    private String[][] nextGeneration;

    public String[][] nextGeneration(String[][] currGeneration){
        nextGeneration=Util.copyArray(currGeneration);
        for(int i = 0; i<currGeneration.length; i++){
            checkSingleRow(i, currGeneration);
        }
        return nextGeneration;
    }

    private void checkSingleRow(int currentRow, String[][] currGeneration){
        for (int j = 0; j<currGeneration.length; j++){
            checkSingleField(currentRow, j, currGeneration);
        }
    }

    private void checkSingleField(int currentRow, int currentField, String[][] currGeneration){
        int aliveNeighbours=0;
        //1. Any live cell with fewer than two live neighbours dies, as if caused by under-population
        //2. Any live cell with two or three live neighbours lives on to the next generation.
        //3. Any live cell with more than three live neighbours dies, as if by overcrowding.
        if (currGeneration[currentRow][currentField].equalsIgnoreCase("X")){
            aliveNeighbours=checkForAmountOfAliveNeighbours(currentRow,currentField,currGeneration);
            killCellIfNecessary(aliveNeighbours, currentRow, currentField);
        }
        //4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        if (currGeneration[currentRow][currentField].equalsIgnoreCase(".")){
            aliveNeighbours=checkForAmountOfAliveNeighbours(currentRow,currentField,currGeneration);
            createNewCellIfNecessary(aliveNeighbours, currentRow, currentField);
        }
    }

    private void createNewCellIfNecessary(int aliveNeighbours, int currentRow, int currentField) {
        if (aliveNeighbours==3){
            nextGeneration[currentRow][currentField] = "X";
        }
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    private void killCellIfNecessary(int aliveNeighbours, int currentRow, int currentField) {
        if (aliveNeighbours<2 || aliveNeighbours>3){
            nextGeneration[currentRow][currentField] = ".";
        }
    }


    private int checkForAmountOfAliveNeighbours(int currentRow, int currentField, String[][] currGeneration){
        int amount = 0;
        //Row above current row
        amount += checkRow(currentRow-1, currentField, currGeneration);
        //Current row
        amount += checkRow(currentRow, currentField, currGeneration);
        //own field has to be substracted
        if (currGeneration[currentRow][currentField].equalsIgnoreCase("X")){
        amount--;
        }
        //Row below current row
        amount += checkRow(currentRow+1, currentField, currGeneration);
        return amount;
    }

    private int checkRow(int rowToCheck, int fieldToCheck, String[][] currGeneration){
        int amount = 0;
        if (rowToCheck<0 || rowToCheck>currGeneration.length-1){
            return 0;
        }
        if (fieldToCheck>0 && currGeneration[rowToCheck][fieldToCheck-1].equalsIgnoreCase("X")){
            amount++;
        }
        if (currGeneration[rowToCheck][fieldToCheck].equalsIgnoreCase("X")){
            amount++;
        }
        if (fieldToCheck<currGeneration.length-1 && currGeneration[rowToCheck][fieldToCheck+1].equalsIgnoreCase("X")){
            amount++;
        }
        return amount;
    }
}