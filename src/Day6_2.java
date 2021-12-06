import java.util.Arrays;

public class Day6_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        String input = data.dataToString("src\\puzzleInputs\\day6.txt");

        // variable declaration/initialization
        long[] numEachAge = new long[9];
        String[] initialAgesString;
        long newFish;
        long totalFish = 0;

        // set up the initial conditions of the fish population and ages
        initialAgesString = input.split(",");
        for (String s : initialAgesString){
            numEachAge[Integer.parseInt(s)]++;
        }

        // iterate through 256 cycles (256 days) to model the population
        for (int day = 0; day < 256; day++) {
            newFish = numEachAge[0];
            for (int ageGroup = 0; ageGroup < numEachAge.length; ageGroup++) {
                // add fish that just gave birth
                if (ageGroup == 6) {
                    numEachAge[ageGroup] = numEachAge[7];
                    numEachAge[ageGroup] += newFish;
                // add just born fish
                } else if (ageGroup == 8) {
                    numEachAge[ageGroup] = newFish;
                // age each group of fish
                } else {
                    numEachAge[ageGroup] = numEachAge[ageGroup + 1];
                }
            }
        }

        // count total number of fish
        for (long i : numEachAge) {
            totalFish += i;
        }
        System.out.println(Arrays.toString(numEachAge));
        System.out.println("There would be " + totalFish + " lanternfish after 256 days.");
    }
}
