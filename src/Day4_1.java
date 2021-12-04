import java.util.Arrays;
import java.util.List;

public class Day4_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day4.txt");

        // variable declaration/initialization
        String[] drawOrder = input.get(0).split(",");
        int gridSize = 5;
        int numGrids = 0;
        int currentGrid = 0;
        int currentRow = 0;
        int winningGrid = 0;
        int lastDraw = 0;
        int score = 0;
        String draw;
        String[][][] grids;
        boolean[][][] markedGrids;

        // determine how many grids there are
        for (int i = 1; i <input.size(); i++){
            if (input.get(i).equals("")){
                numGrids++;
            }
        }

        // initialize the 3D array containing the grids and fill each array with the grid numbers
        grids = new String[numGrids][gridSize][gridSize];
        markedGrids = new boolean[numGrids][gridSize][gridSize];
        for (int i = 2; i <input.size(); i++){
            if (!input.get(i).equals("")){
                // removes blank spaces that result from just using split by converting to a stream and
                // filtering out the unwanted blank spaces
                String[] splitResult = Arrays.stream(input.get(i).split(" ", -1))
                        .filter(e -> e.trim().length() > 0)
                        .toArray(String[]::new);
                grids[currentGrid][currentRow] = splitResult;
                currentRow++;
            } else {
                currentGrid++;
                currentRow = 0;
            }
        }

        // iterate through the number draws and mark each grid until a winner is found
        breakpoint:
        for (String s : drawOrder) {
            draw = s;
            // iterate though each number on each grid
            for (int gridI = 0; gridI < grids.length; gridI++) {
                for (int rowI = 0; rowI < gridSize; rowI++) {
                    for (int colI = 0; colI < gridSize; colI++) {
                        // check if the current number matches the draw
                        if (draw.equals(grids[gridI][rowI][colI])) {
                            markedGrids[gridI][rowI][colI] = true;
                            // determine if a winner has been found
                            for (int check = 0; check < gridSize; check++) {
                                boolean rowMarked = markedGrids[gridI][check][0] && markedGrids[gridI][check][1] &&
                                        markedGrids[gridI][check][2] && markedGrids[gridI][check][3] &&
                                        markedGrids[gridI][check][4];
                                boolean colMarked = markedGrids[gridI][0][check] && markedGrids[gridI][1][check] &&
                                        markedGrids[gridI][2][check] && markedGrids[gridI][3][check] &&
                                        markedGrids[gridI][4][check];
                                if (rowMarked || colMarked) {
                                    winningGrid = gridI;
                                    lastDraw = Integer.parseInt(draw);
                                    break breakpoint;
                                }
                            }
                        }
                    }
                }
            }
        }

        // determine score of winning grid using given formula
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (!markedGrids[winningGrid][i][j]) {
                    score += Integer.parseInt(grids[winningGrid][i][j]);
                }
            }
        }
        score *= lastDraw;
        System.out.println("The final score of the first winning board is: " + score + ".");
    }
}
