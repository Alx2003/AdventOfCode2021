import java.util.List;

public class Day2_1 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day2.txt");

        // variable declaration/initialization
        int dist = 0;
        int depth = 0;
        String[] command;

        // iterate through data input and adjust dist and depth accordingly.
        for (String s : input) {
            // check if command is forward, down, or up to adjust appropriate counter
            command = s.split(" ");
            if (command[0].equals("forward")) {
                dist += Integer.parseInt(command[1]);
            } else if (command[0].equals("up")) {
                depth -= Integer.parseInt(command[1]);
            } else {
                depth += Integer.parseInt(command[1]);
            }
        }
        System.out.println("Multiplying the horizontal position by the depth results in: " + dist*depth + ".");
    }
}
