import java.util.List;

public class Day1_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<Integer> input = data.dataToIntList("src\\puzzleInputs\\day1.txt");

        // variable declaration/initialization
        int count = 0;
        int sum1;
        int sum2;

        // iterate through data input and increment count if the next summation window is greater.
        for (int i = 0; i < input.size() - 3; i++) {
            sum1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            sum2 = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);

            if (sum2 > sum1) {
                count++;
            }
        }
        System.out.println(count + " sums are larger than the previous sum.");
    }
}
