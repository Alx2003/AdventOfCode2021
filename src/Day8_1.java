import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day8.txt");

        // variable declaration/initialization
        List<String[]> outputValues = new ArrayList<>();
        String outputs;
        int uniqueNum = 0;

        // set up list of output values
        for (String notes : input) {
            // filter out empty Strings
            outputs = notes.split("\\|")[1];
            outputValues.add(Arrays.stream(outputs.split(" "))
                    .filter(e ->  e.trim().length() > 0)
                    .toArray(String[]::new));
        }

        // count the number of time the unique number of segments digits appear
        for (String[] output : outputValues) {
            for (String digit : output) {
                if ((digit.length() == 2) || (digit.length() == 4) || (digit.length() == 3) || (digit.length() == 7)) {
                    uniqueNum ++;
                }
            }
        }
        System.out.println("The digits 1, 4, 7, and 8 appear " + uniqueNum + " times.");
    }
}
