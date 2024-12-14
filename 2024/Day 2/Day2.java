import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        try {
            // Read input file
            List<String> reports = Files.readAllLines(Paths.get("2024/Day 2/input1.txt"));

            // Solve part 1
            int result1 = part1(reports);
            System.out.println("Result for Part 1: " + result1);

            // --------------------------------------------------------------------------

            // Solve part 2
            System.out.println("Result for Part 2: " + result1);
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    private static int part1(List<String> reports) {
        int sol = 0;

        for (String report : reports) {
            // Splits string into an array of strings
            // Then converts the array into a stream
            // Then maps each element into an int
            // Then turns the stream into an array
            int[] levels = Arrays.stream(report.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (isSafe(levels)) {
                sol++;
            }
        }

        return sol;
    }

    private static boolean isSafe(int[] levels) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < levels.length - 1; i++) {
            int diff = Math.abs(levels[i] - levels[i + 1]);

            if (diff < 1 || diff > 3) {
                return false;
            } 

            if (levels[i] < levels[i + 1]) {
                dec = false;
            } else if (levels[i] > levels[i + 1]) {
                inc = false;
            }
        }

        return inc || dec;
    }

    private static int part2() {

        return 0;
    }
}