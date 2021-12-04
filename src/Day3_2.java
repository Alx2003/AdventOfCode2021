import java.util.ArrayList;
import java.util.List;

public class Day3_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day3.txt");

        // variable declaration/initialization
        int numSize = input.get(0).length();
        int oxygenRatingNum = 0;
        int co2RatingNum = 0;
        String oxygenRating;
        String co2Rating;
        int lifeSupportRating;

        // determine the numbers for the oxygen rating and co2 rating using function listed below
        oxygenRating = determineMostCommon(input, 0).get(0);
        co2Rating = determineLeastCommon(input, 0).get(0);

        // convert binary numbers to decimal and calculate the life support rating according to given formula
        for (int i = 0; i < numSize; i++) {
            oxygenRatingNum += (Math.pow(2, numSize - 1 - i) * Character.getNumericValue(oxygenRating.charAt(i)));
            co2RatingNum += (Math.pow(2, numSize - 1 - i) * Character.getNumericValue(co2Rating.charAt(i)));
        }
        lifeSupportRating = oxygenRatingNum*co2RatingNum;
        System.out.println("The life support rating of the submarine is " + lifeSupportRating + ".");

    }

    // recursively determines a string with the most common digit for every index
    public static List<String> determineMostCommon(List<String> input, int index) {
        List<String> ones = new ArrayList<>();
        List<String> zeroes = new ArrayList<>();
        List<String> output;

        // store the numbers that have 1's and 0's for that digit separately
        for (String s : input) {
            if (s.charAt(index) == '1') {
                ones.add(s);
            } else {
                zeroes.add(s);
            }
        }

        // recursively call on function to find the most common digit for a given index
        // and test those numbers for the next index
        if (ones.size() >= zeroes.size() && ones.size() != 1) {
            return determineMostCommon(ones, index + 1);
        } else if (ones.size() < zeroes.size() && zeroes.size() != 1) {
            return determineMostCommon(zeroes, index + 1);
        }

        // return the appropriate number containing the most common digit for every index
        // of non-removed numbers
        if (ones.size() == 1) {
            output = ones;
        } else {
            output = zeroes;
        }
        return output;
    }

    // recursively determines a string with the least common digit for every index
    public static List<String> determineLeastCommon(List<String> input, int index) {
        List<String> ones = new ArrayList<>();
        List<String> zeroes = new ArrayList<>();
        List<String> output;

        // store the numbers that have 1's and 0's for that digit separately
        for (String s : input) {
            if (s.charAt(index) == '1') {
                ones.add(s);
            } else {
                zeroes.add(s);
            }
        }

        // recursively call on function to find the least common digit for a given index
        // and test those numbers for the next index
        if (zeroes.size() <= ones.size() && zeroes.size() != 1) {
           return determineLeastCommon(zeroes, index + 1);
        } else if (zeroes.size() > ones.size() && ones.size() != 1) {
           return determineLeastCommon(ones, index + 1);
        }

        // return the appropriate number containing the least common digit for every index
        // of non-removed numbers
        if (ones.size() == 1) {
            output = ones;
        } else {
            output = zeroes;
        }
        return output;
    }
}
