import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        try {
            // Read input file
            List<String> reports = Files.readAllLines(Paths.get("2024/Day 2/input.txt"));

            // Solve part 1
            int result1 = part1(reports);
            System.out.println("Result for Part 1: " + result1);

            // --------------------------------------------------------------------------

            // Solve part 2
            int result2 = part2(reports);
            System.out.println("Result for Part 2: " + result2);
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

    private static int part2(List<String> reports) {
        int sol = 0;

        for (String report : reports) {
            // Splits string into an array of strings
            // Then converts the array into a stream
            // Then maps each element into an int
            // Then turns the stream into an array
            int[] levels = Arrays.stream(report.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            // Convert the above array into a list
            // There's def a better way to do it, but I'm taking it step by step rn
            List<Integer> levelsList = Arrays.stream(levels).boxed().collect(Collectors.toList());

            if (isSafe2(levelsList)) {
                sol++;
                continue;
            }
    
            // If not safe, try removing one element at a time and keep checking if level is safe
            for (int i = 0; i < levelsList.size(); i++) {
                List<Integer> listCopy = new ArrayList<>(levelsList);
                listCopy.remove(i);
    
                if (isSafe2(listCopy)) {
                    sol++;
                    break; 
                }
            }
        }

        return sol;
    }

    private static boolean isSafe2(List<Integer> levels) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = Math.abs(levels.get(i) - levels.get(i + 1));

            if (diff < 1 || diff > 3) {
                return false;
            } 

            if (levels.get(i) < levels.get(i + 1)) {
                dec = false;
            } else if (levels.get(i) > levels.get(i + 1)) {
                inc = false;
            }
        }

        return inc || dec;
    }
}