import java.util.List;

public class Day3_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day3.txt");

        // variable declaration/initialization
        int numSize = input.get(0).length();
        int[] onesCount = new int[numSize];
        int [] gamma = new int[numSize];
        int[] epsilon = new int[numSize];
        int gammaValue = 0;
        int epsilonValue = 0;
        int power;

        // iterate through data input to determine if 1 is the most common bit of each digit of each input
        for (String s : input) {
            for (int i = 0; i < numSize; i++) {
                if (s.charAt(i) == '1') {
                    onesCount[i]++;
                }
            }
        }

        // adjust gamma and epsilon according to most common and least common bit
        // if the number of 1's > half the size of the input, 1 is the most common bit of that digit
        // else 0 is the most common bit of that digit
        for (int i = 0; i < numSize; i++) {
            if (onesCount[i] > input.size() / 2){
                gamma[i] = 1;
                epsilon[i] = 0;
            } else {
                gamma[i] = 0;
                epsilon[i] = 1;
            }
        }

        // convert binary numbers to decimal and calculate the power according to given formula
        for (int i = 0; i < numSize; i++) {
            gammaValue += (Math.pow(2, numSize - 1 - i) * gamma[i]);
            epsilonValue += (Math.pow(2, numSize - 1 - i) * epsilon[i]);
        }
        power = gammaValue*epsilonValue;
        System.out.println("The power consumption of the submarine is " + power + ".");
    }
}
