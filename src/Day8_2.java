import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day8_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day8.txt");

        // variable declaration/initialization
        List<String[]> outputValues = new ArrayList<>();
        List<String[]> inputValues = new ArrayList<>();
        List<HashMap> digitMap = new ArrayList<>();
        String[] inputSplit;
        StringBuilder answer;
        int outputSum = 0;

        // set up list of output values
        for (String notes : input) {
            // filter out empty Strings
            inputSplit = notes.split("\\|");
            outputValues.add(Arrays.stream(inputSplit[1].split(" "))
                    .filter(e ->  e.trim().length() > 0)
                    .toArray(String[]::new));
            inputValues.add(Arrays.stream(inputSplit[0].split(" "))
                    .filter(e ->  e.trim().length() > 0)
                    .toArray(String[]::new));
        }

        // decode the pattern for each input
        for (String[] inputValue : inputValues) {
            HashMap<String, String> digits = new HashMap<>();
            String ones = "";
            String fours = "";
            String sevens = "";
            StringBuilder L = new StringBuilder();
            // determine the pattern for digits with unique number of segments
            for (String digit : inputValue) {
                if (digit.length() == 2) {
                    ones = digit;
                    char[] chars = digit.toCharArray();
                    Arrays.sort(chars);
                    String sorted = new String(chars);
                    digits.put(sorted, "1");
                } else if (digit.length() == 4) {
                    fours = digit;
                    char[] chars = digit.toCharArray();
                    Arrays.sort(chars);
                    String sorted = new String(chars);
                    digits.put(sorted, "4");
                } else if (digit.length() == 3) {
                    sevens = digit;
                    char[] chars = digit.toCharArray();
                    Arrays.sort(chars);
                    String sorted = new String(chars);
                    digits.put(sorted, "7");
                } else if (digit.length() == 7) {
                    char[] chars = digit.toCharArray();
                    Arrays.sort(chars);
                    String sorted = new String(chars);
                    digits.put(sorted, "8");
                }
            }
            for (int chr = 0; chr < 4; chr++) {
                if (!ones.contains(fours.substring(chr, chr + 1))) {
                    L.append(fours.charAt(chr));
                }
            }
            // determine the pattern for digits with 5 segments
            for (String digit : inputValue) {
                if (digit.length() == 5) {
                    if (digit.contains(ones.substring(0, 1)) && digit.contains(ones.substring(1))) {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "3");
                    } else if (digit.contains(L.substring(0, 1)) && digit.contains(L.substring(1))) {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "5");
                    } else {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "2");
                    }
                }
            }
            //determine the pattern for digits with 6 segments
            for (String digit : inputValue) {
                if (digit.length() == 6) {
                    if (digit.contains(fours.substring(0, 1)) && digit.contains(fours.substring(1, 2)) &&
                            digit.contains(fours.substring(2, 3)) && digit.contains(fours.substring(3))) {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "9");
                    } else if (digit.contains(sevens.substring(0, 1)) && digit.contains(sevens.substring(1, 2)) &&
                            digit.contains(sevens.substring(2))) {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "0");
                    } else {
                        char[] chars = digit.toCharArray();
                        Arrays.sort(chars);
                        String sorted = new String(chars);
                        digits.put(sorted, "6");
                    }
                }
            }
            digitMap.add(digits);
        }

        // using the HashMaps decode the outputs and sum the results
        for (int i = 0; i < outputValues.size(); i++) {
            answer = new StringBuilder();
            for (String digit : outputValues.get(i)) {
                char[] chars = digit.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                answer.append(digitMap.get(i).get(sorted));
            }
            outputSum += Integer.parseInt(answer.toString());
        }
        System.out.println("The sum of all output values is: " + outputSum + ".");
    }
}
