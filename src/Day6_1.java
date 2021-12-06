import java.util.ArrayList;
import java.util.List;

public class Day6_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        String input = data.dataToString("src\\puzzleInputs\\day6.txt");

        // variable declaration/initialization
        List<Integer> ages = new ArrayList<>();
        String[] initialAgesString;
        int newFish;

        // set up the initial conditions of the fish population and ages
        initialAgesString = input.split(",");
        for (String s : initialAgesString){
            ages.add(Integer.parseInt(s));
        }

        // iterate through 80 cycles (80 days) to model the population
        for (int day = 0; day < 80; day++) {
            newFish = 0;
            for (int fish = 0; fish < ages.size(); fish++) {
                // reset timer on fish if timer is 0
                if (ages.get(fish) == 0){
                    ages.set(fish, 6);
                    newFish ++;
                } else {
                    ages.set(fish, ages.get(fish) - 1);
                }
            }
            // implement new fish
            for (int babyFish = 0; babyFish < newFish; babyFish++){
                ages.add(8);
            }
        }
        System.out.println("There would be " + ages.size() + " lanternfish after 80 days.");
    }
}
