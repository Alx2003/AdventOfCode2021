import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LoadData {
    /**
     * Reads and extracts data from a txt file into an Integer List
     * @param fileLocation {@code String} containing txt file location
     * @return a {@code List<Integer>} containing the data extracted from the txt file
     */
    public List<Integer> dataToIntList(String fileLocation){
        List<Integer> input = new ArrayList<>();
        try {
            File data = new File(fileLocation);
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextInt()) {
                input.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return input;
    }

    /**
     * Reads and extracts data from a txt file into an String List
     * @param fileLocation {@code String} containing txt file location
     * @return a {@code List<String>} containing the data extracted from the txt file
     */
    public List<String> dataToStringList(String fileLocation){
        List<String> input = new ArrayList<>();
        try {
            File data = new File(fileLocation);
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        return input;
    }
}
