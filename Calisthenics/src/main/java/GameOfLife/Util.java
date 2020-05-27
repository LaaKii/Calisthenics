package GameOfLife;

public class Util {

    public static String[][] copyArray(String[][] arrayToCopy){
        String[][] newArray = new String[arrayToCopy.length][arrayToCopy.length];
        for(int i = 0; i < arrayToCopy.length; i++)
            newArray[i] = arrayToCopy[i].clone();
        return newArray;
    }
}
