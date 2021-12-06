import java.util.ArrayList;
import java.util.List;

public class Day5_2 {
    public static void main(String[] args) {
        // extract data into appropriate List type
        LoadData data = new LoadData();
        List<String> input = data.dataToStringList("src\\puzzleInputs\\day5.txt");

        // variable declaration/initialization
        String[] coordinates;
        List<String[]> startPosition = new ArrayList<>();
        List<String[]> endPosition = new ArrayList<>();
        int[][] plane = new int[1000][1000];
        int numOverlap = 0;
        int indexStart;
        int indexEnd;
        int y;

        // store the start and end positions as coordinates in two separate arrays (x,y)
        for (String s : input) {
            coordinates = s.split(" -> ", -1);
            startPosition.add(coordinates[0].split(","));
            endPosition.add(coordinates[1].split(","));
        }

        // increment positions on the grid which hold vertical lines, horizontal lines, or lines with slopes of 1/-1
        for (int i = 0; i < input.size(); i++) {
            if (startPosition.get(i)[0].equals(endPosition.get(i)[0])) {
                indexStart = Math.min(Integer.parseInt(startPosition.get(i)[1]),
                        Integer.parseInt(endPosition.get(i)[1]));
                indexEnd = Math.max(Integer.parseInt(startPosition.get(i)[1]),
                        Integer.parseInt(endPosition.get(i)[1]));
                for (int j = indexStart; j <= indexEnd; j++) {
                    plane[j][Integer.parseInt(startPosition.get(i)[0])]++;
                }
            } else if (startPosition.get(i)[1].equals(endPosition.get(i)[1])) {
                indexStart = Math.min(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                indexEnd = Math.max(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                for (int j = indexStart; j <= indexEnd; j++) {
                    plane[Integer.parseInt(startPosition.get(i)[1])][j]++;
                }
            } else if (startPosition.get(i)[0].equals(endPosition.get(i)[1]) &&
                    startPosition.get(i)[1].equals(endPosition.get(i)[0])) {
                indexStart = Math.min(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                indexEnd = Math.max(Integer.parseInt(startPosition.get(i)[1]),
                        Integer.parseInt(endPosition.get(i)[1]));
                for (int j = indexStart, k = indexEnd; j <= indexEnd; j++, k--){
                    plane[j][k]++;
                }
            } else if (((Integer.parseInt(endPosition.get(i)[1]) - Integer.parseInt(startPosition.get(i)[1])) /
                    ((Integer.parseInt(endPosition.get(i)[0]) - Integer.parseInt(startPosition.get(i)[0]))) == 1)) {
                indexStart = Math.min(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                indexEnd = Math.max(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                if (indexStart == Integer.parseInt(startPosition.get(i)[0])) {
                    y = Integer.parseInt(startPosition.get(i)[1]);
                } else {
                    y = Integer.parseInt(endPosition.get(i)[1]);
                }
                for (int j = indexStart, k = y; j<= indexEnd; j++, k++) {
                    plane[k][j] ++;
                }
            } else if (((Integer.parseInt(endPosition.get(i)[1]) - Integer.parseInt(startPosition.get(i)[1])) /
                    ((Integer.parseInt(endPosition.get(i)[0]) - Integer.parseInt(startPosition.get(i)[0]))) == -1)) {
                indexStart = Math.min(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                indexEnd = Math.max(Integer.parseInt(startPosition.get(i)[0]),
                        Integer.parseInt(endPosition.get(i)[0]));
                if (indexStart == Integer.parseInt(startPosition.get(i)[0])) {
                    y = Integer.parseInt(startPosition.get(i)[1]);
                } else {
                    y = Integer.parseInt(endPosition.get(i)[1]);
                }
                for (int j = indexStart, k = y; j<= indexEnd; j++, k--) {
                    plane[k][j] ++;
                }
            }
        }

        // count the number of points with at least two lines overlapping
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (plane[i][j] >= 2){
                    numOverlap++;
                }
            }
        }
        System.out.println("At least two lines overlap at " + numOverlap +" points.");
    }
}
