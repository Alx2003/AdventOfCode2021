import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        String input = data.dataToString("src\\puzzleInputs\\day7.txt");

        // variable declaration/initialization
        List<Integer> positions = new ArrayList<>();
        String[] inputSplit;
        int n;
        int currentFuel;
        int minFuel = 0;

        // set up the initial conditions of the crab positions
        inputSplit = input.split(",");
        for (String s : inputSplit) {
            positions.add(Integer.parseInt(s));
        }

        // determine the total fuel required for the cheapest outcome
        for (int alignPos = 0; alignPos < Collections.max(positions); alignPos++) {
            currentFuel = 0;
            for (int currentPos : positions) {
                n = Math.abs(currentPos - alignPos);
                // summation of n terms formula
                currentFuel += ((Math.pow(n, 2) + n) / 2);
            }
            if (minFuel == 0) {
                minFuel = currentFuel;
            } else if (currentFuel < minFuel) {
                minFuel = currentFuel;
            }
        }
        System.out.println("The amount of fuel needed to spend to align to the cheapest position is: " + minFuel + ".");
    }
}
