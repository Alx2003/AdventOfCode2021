import java.util.List;

public class Day1_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<Integer> input = data.dataToIntList("src\\puzzleInputs\\day1.txt");

        // variable declaration/initialization
        int count = 0;

        // iterate through data and increment count if next value if greater.
        for (int i = 0; i < input.size() - 1; i++){
            if (input.get(i + 1) > input.get(i)){
                count++;
            }
        }
        System.out.println(count + " measurements are larger than the previous measurement.");
    }
}
